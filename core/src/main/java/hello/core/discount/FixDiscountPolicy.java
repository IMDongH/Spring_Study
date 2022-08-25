package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
//@Qualifier("fixDiscountPolicy")
public class FixDiscountPolicy implements DiscountPolicy{

    private int discountFixAmount = 1000; //1000원 할인
    @Override
    public int discount(Member member, int price) {
        //Enum은 == 사용하는 것이 맞다.
        if(member.getGrade()== Grade.VIP)
        {
            return discountFixAmount;
        }
        else
        {
            return 0;
        }

    }
}
