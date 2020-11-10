package hello.core.autowired;

import hello.core.member.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.lang.Nullable;

import javax.swing.text.html.Option;
import java.util.Optional;

public class AutowiredTest {

    @Test
    void AutouwiredOption(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);
        ac.getBean(Member.class);
        System.out.println("AutowiredTest.AutouwiredOption");
    }

    static class TestBean {

        @Autowired(required = false)
        public void setNoBean1(Member member){
            System.out.println(member);
        }

        @Autowired
        public void setNoBean2(@Nullable Member member){
            System.out.println(member);
        }

        @Autowired
        public void setNoBean3(Optional<Member> member){
            System.out.println(member);
        }

    }

}
