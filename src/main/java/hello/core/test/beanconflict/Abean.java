package hello.core.test.beanconflict;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Qualifier("aa")
public class Abean implements BeanTest{
    @Override
    public void test() {
        System.out.println("Abean.test");
    }
}
