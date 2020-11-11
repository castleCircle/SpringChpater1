package hello.core.autowired;

import hello.core.AutoAppConfig;
import hello.core.discount.DiscountPolicy;
import hello.core.member.Grade;
import hello.core.member.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;
import java.util.Map;

public class AllBeanMyTest {

    @Test
    void allBeanTest(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class,AllBean.class);
        AllBean bean = ac.getBean(AllBean.class);

        Member testMember = new Member(1L, "test", Grade.VIP);
        int money = bean.discount(testMember,10000,"rateDiscountPolicy");
        System.out.println(money);

    }

    static class AllBean{

        private final Map<String, DiscountPolicy> discountPolicyMap;
        private final List<DiscountPolicy> discountPolicyList;

        @Autowired
        public AllBean(Map<String, DiscountPolicy> discountPolicyMap, List<DiscountPolicy> discountPolicyList) {
            this.discountPolicyMap = discountPolicyMap;
            this.discountPolicyList = discountPolicyList;
        }

        public int discount(Member member,int money,String policy){
            return discountPolicyMap.get(policy).discount(member,money);
        }

    }







}
