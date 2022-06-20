package ar.mario.proto.bean;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.mario.proto.vo.SampleVo;

@Repository
public interface CustomerRepository extends JpaRepository<SampleVo, Integer>{
    public List<SampleVo> findByName(String name);
	//like검색도 가능
	public List<SampleVo> findByNameLike(String keyword);
}