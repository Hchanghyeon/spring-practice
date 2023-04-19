package spring.practice;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring.practice.repository.MemberRepository;
import spring.practice.repository.MemoryMemberRepository;
import spring.practice.service.MemberService;

@Configuration
public class SpringConfig {
/*

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }
*/

}



