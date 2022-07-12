package hello.core.discount;

import hello.core.AppConfig;
import hello.core.member.Grade;
import hello.core.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RateDiscountPolicyTest {
    DiscountPolicy discountPolicy;
    @BeforeEach
    public void beforeEach()
    {
        AppConfig appConfig = new AppConfig();
        discountPolicy = appConfig.discountPolicy();
    }

    @Test
    @DisplayName("VIP 할인이 적용되었습니다")
    void vip_o()
    {
        Member member = new Member(1L,"memberVIP", Grade.VIP);

        int discount = discountPolicy.discount(member,10000);

        Assertions.assertThat(discount).isEqualTo(1000);
    }

    @Test
    @DisplayName("VIP 할인이 적용되지 않았습니다")
    void vip_x()
    {

        Member member = new Member(2L,"memberBASIC", Grade.BASIC);

        int discount = discountPolicy.discount(member,10000);

        Assertions.assertThat(discount).isEqualTo(0);

    }
}
