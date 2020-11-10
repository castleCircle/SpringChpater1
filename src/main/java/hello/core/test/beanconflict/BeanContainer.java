package hello.core.test.beanconflict;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BeanContainer {

    private final BeanTest beanTest;

    BeanContainer(BeanTest beanTest){
        this.beanTest = beanTest;
    }

}
