package hello.core.scope;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class SingletonWithPrototypeTest2 {

    @Test
    public void protoTest(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(PrototyeBeanTest.class);
        PrototyeBeanTest bean = ac.getBean(PrototyeBeanTest.class);
        bean.count();
        Assertions.assertThat(bean.getCount()).isEqualTo(1);

        PrototyeBeanTest bean1 = ac.getBean(PrototyeBeanTest.class);
        bean1.count();
        Assertions.assertThat(bean1.getCount()).isEqualTo(1);
    }

    @Test
    public void prototypeInSingleton(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(ContainPrototypeSingleTon.class,PrototyeBeanTest.class);
        ContainPrototypeSingleTon bean = ac.getBean(ContainPrototypeSingleTon.class);
        Assertions.assertThat(bean.getData()).isEqualTo(1);

        ContainPrototypeSingleTon bean1 = ac.getBean(ContainPrototypeSingleTon.class);
        Assertions.assertThat(bean1.getData()).isEqualTo(1);
    }

    @Scope("singleton")
    static class ContainPrototypeSingleTon{

//        private final PrototyeBeanTest prototyeBeanTest;
//
//        public ContainPrototypeSingleTon(PrototyeBeanTest prototyeBeanTest) {
//            this.prototyeBeanTest = prototyeBeanTest;
//        }

        @Autowired
        private ObjectProvider<PrototyeBeanTest> objectProvider;

        public int getData(){
            PrototyeBeanTest providerObject = objectProvider.getObject();
            providerObject.count();
            return providerObject.getCount();
        }

    }

    @Scope("prototype")
    static class PrototyeBeanTest{
        private int count = 0;

        public int getCount(){
            return count;
        }

        public void count(){
            count++;
        }

        @PostConstruct
        public void init(){
            System.out.println("PrototyeBeanTest.init" + this);
        }

        @PreDestroy
        public void destroy(){
            System.out.println("destroy");
        }
    }

}
