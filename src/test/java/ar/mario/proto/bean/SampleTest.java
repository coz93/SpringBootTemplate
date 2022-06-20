// package ar.mario.proto.bean;

// import static org.hamcrest.CoreMatchers.is;

// import java.util.List;

// import org.junit.jupiter.api.Test;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.context.SpringBootTest;

// import ar.mario.proto.vo.SampleVo;

// @SpringBootTest
// public class SampleTest {

// 	@Autowired
// 	CustomerRepository customerRepository;
	
// 	@Test
// 	public void SampleTest(){
//         SampleVo customer = SampleVo.builder().name("크리스").phone("010-1224-1225").build();
// 		customerRepository.save(customer);
		
// 		List<SampleVo> customerList = customerRepository.findAll();
		
// 		SampleVo chris = customerList.get(0);
// 		assertThat(chris.getName(), is("크리스"));
// 		assertThat(chris.getPhone(), is("010-1224-1225"));
// 	}
    
//     @After
//     public void deleteAll() {
//         customerRepository.deleteAll();
//     }

// }