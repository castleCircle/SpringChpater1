package hello.core.beanconflict;

import hello.core.AppConfig;
import hello.core.AutoAppConfig;
import hello.core.test.beanconflict.Abean;
import hello.core.test.beanconflict.Bbean;
import hello.core.test.beanconflict.BeanContainer;
import hello.core.test.beanconflict.BeanTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

public class beanConflictTest {

    @Test
    void beanTest(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);
//        ac.getBean(BeanContainer.class);
    }



}
