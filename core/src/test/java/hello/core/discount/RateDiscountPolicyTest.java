package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.order.Order;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {

    private final DiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP고객은 10%할인되어야 한다.")
    void vip_o(){
        Member member = new Member(1L,"memberVIP", Grade.VIP);
        int discountPrice = discountPolicy.discount(member, 10000);
        Assertions.assertThat(discountPrice).isEqualTo(1000);

    }

    @Test
    @DisplayName("BASIC고객은 10%할인이 되지 않는다.")
    void vip_x(){
        Member member = new Member(2L,"memberBASIC", Grade.BASIC);
        int discountPrice = discountPolicy.discount(member, 10000);
        Assertions.assertThat(discountPrice).isEqualTo(0);
    }
}