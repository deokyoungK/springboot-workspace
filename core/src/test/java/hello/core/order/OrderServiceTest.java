package hello.core.order;

import hello.core.Appconfig;
import hello.core.member.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {

    MemberService memberService;
    OrderService orderService;

    @BeforeEach
    public void beforeEach(){
        Appconfig appconfig = new Appconfig();
        this.memberService = appconfig.memberService();
        this.orderService = appconfig.orderService();
    }

    @Test
    void createOrder(){

        Member member = new Member(1L, "memberA", Grade.VIP );
        memberService.join(member);

        Order order = orderService.createOrder(member.getId(),"JPA",10000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);

    }
}
