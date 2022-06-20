package ar.mario.proto.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@SequenceGenerator(
                   name="ARM_TEST_SEQ_GEN", //시퀀스 제너레이터 이름
                   sequenceName="ARM_TEST_SEQ", //시퀀스 이름
                   initialValue=1, //시작값
                   allocationSize=1 //메모리를 통해 할당할 범위 사이즈
                  )
@Entity(name="sample")
@Table(name = "ARM_TEST")
public class SampleVo {
    @Id
    @GeneratedValue(
                    strategy=GenerationType.SEQUENCE, //사용할 전략을 시퀀스로  선택
                    generator="ARM_TEST_SEQ_GEN" //식별자 생성기를 설정해놓은  USER_SEQ_GEN으로 설정        
                   )
    @Column(name = "CUST_NO")
    private int custNo;

    @Column(length = 20, nullable = false, name = "NAME")
    private String name;

    @Column(length = 200, nullable = false, name = "DESCRIPTION")
    private String desc;

    @Builder
    public SampleVo( String name, String desc){
        this.name = name;
        this.desc = desc;
    }

    @Builder
    public SampleVo( int custNo, String name, String desc){
        this.custNo = custNo;
        this.name = name;
        this.desc = desc;
    }
}