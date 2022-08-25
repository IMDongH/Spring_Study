package hello.core.autoWired;

import hello.core.member.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.lang.Nullable;

import java.lang.annotation.Annotation;
import java.util.Optional;

public class AutoWiredTest {

    @Test
    void AutoWiredOption(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);

    }

    static class TestBean{

        @Autowired(required = false)//false로 되어 있을경우 대상이 없으면 호출이 되지 않는다
        public void setNoBean1(Member noBean1){
            System.out.println("noBean1 = " + noBean1);
        }
        @Autowired//Nullable이 있으면 호출은 되지만 null이 된다.
        public void setNoBean2(@Nullable  Member noBean2){
            System.out.println("noBean2 = " + noBean2);
        }
        @Autowired//Optional 문법인데 값이 없으면 Optional.empty로 넣어준다.
        public void setNoBean3(Optional<Member> noBean3){
            System.out.println("noBean3 = " + noBean3);
        }
    }
}
