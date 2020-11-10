package hello.core.test.beanconflict;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class BeanContainer {

    private final BeanTest beanTest;

    BeanContainer(@Qualifier("aa") BeanTest beanTest){
        this.beanTest = beanTest;
    }

}
