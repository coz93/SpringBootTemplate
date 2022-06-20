package ar.mario.proto;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import ar.mario.proto.bean.CustomerRepository;
import ar.mario.proto.vo.SampleVo;

@SpringBootApplication
@Controller
public class ProtoApplicationController {

	@Autowired
	CustomerRepository cr;

	public static void main(String[] args) {
		SpringApplication.run(ProtoApplicationController.class, args);
	}

	@GetMapping("/api/hello") 
	@ResponseBody
	public String hello(){ return "안녕하세요. 현재 서버시간은 "+new Date() +"입니다. \n"; }

	// @RequestMapping
	// @ResponseBody
	// public String index() {
	// 	return "안녕하세요. 현재 서버시간은 "+new Date() +"입니다. \n";
	// }

	@PostMapping("/save")
	public @ResponseBody List<SampleVo> createSample(@RequestBody Map<String, String> param){
		String name = param.get("name");
		String desc = param.get("desc");
		SampleVo sv = SampleVo.builder().name(name).desc(desc).build();
		cr.save(sv);
		return cr.findAll();
	}

	@PostMapping("/delete")
	public @ResponseBody List<SampleVo> deleteSample(@RequestBody Map<String, String> param){
		int custNo = Integer.parseInt(param.get("custNo"));
		cr.deleteById(custNo);
		return cr.findAll();
	}

	@PostMapping("/update")
	public @ResponseBody List<SampleVo> updateSample(@RequestBody Map<String, String> param){
		int custNo = Integer.parseInt(param.get("custNo"));
		Optional<SampleVo> e = cr.findById(custNo);

		if(e.isPresent()){
			String name = param.get("name");
			String desc = param.get("desc");
			e.get().setCustNo(custNo);
			e.get().setName(name);
			e.get().setDesc(desc);
			SampleVo sv = SampleVo.builder().custNo(custNo).name(name).desc(desc).build();
			cr.save(sv);
		}


		
		return cr.findAll();
	}


}
