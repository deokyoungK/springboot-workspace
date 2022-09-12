package hello.core.member;


import hello.core.Appconfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {

    MemberService memberService;

    @BeforeEach
    public void beforeEach(){
        Appconfig appconfig = new Appconfig();
        this.memberService = appconfig.memberService();
    }



    @Test
    void join(){
        //given
        Member member = new Member(1L,"memberA",Grade.VIP);

        //when
        memberService.join(member);
        Member saveMember = memberService.findMember(member.getId());

        //then
        Assertions.assertThat(member).isEqualTo(saveMember);
    }

}