package hello.core.scope;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.inject.Provider;

public class SingletonWithPrototypeTest3 {

    @Test
    public void singletonWithPrototypeTest(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(SingleTon3.class, Prototype3.class);
        SingleTon3 singleTon3 = ac.getBean(SingleTon3.class);
        int data1 = singleTon3.logic();
        Assertions.assertThat(data1).isEqualTo(1);

        int data2 = singleTon3.logic();
        Assertions.assertThat(data1).isEqualTo(1);
    }



    static class SingleTon3{
//        @Autowired
//        private ObjectProvider<Prototype3> objectProvider;
//
//        public int logic(){
//            Prototype3 providerObject = objectProvider.getObject();
//            providerObject.add();
//            int count = providerObject.getCount();
//            return count;
//        }

        @Autowired
        private Provider<Prototype3> objectProvider;

        public int logic(){
            Prototype3 providerObject = objectProvider.get();
            providerObject.add();
            int count = providerObject.getCount();
            return count;
        }
    }


    static class Prototype3{

        int count = 0;

        public int getCount(){
            return count;
        }

        public void add(){
            count++;
        }

    }



}
