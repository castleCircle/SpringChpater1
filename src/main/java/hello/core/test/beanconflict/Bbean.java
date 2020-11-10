package hello.core.test.beanconflict;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("bb")
public class Bbean implements BeanTest{
    @Override
    public void test() {
        System.out.println("Bbean.test");
    }
}
