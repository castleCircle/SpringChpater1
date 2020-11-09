package hello.core.beanconflict;

import hello.core.AutoAppConfig;
import hello.core.test.beanconflict.BeanTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

public class beanConflictTest {

    @Test
    void beanTest(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(BeanConflict.class);
    }

    static class BeanConflict{

        @Autowired
        public void test(BeanTest beanTest){
            beanTest.test();
        }

    }



}
