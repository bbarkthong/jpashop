package jpabook.jpashop.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;

@SpringBootTest
@Transactional
public class MemberServiceTest {

    @Autowired
    MemberService memberService;
    @Autowired
    MemberRepository memberRepository;
    // @Autowired EntityManager em;

    @Test
    public void 회원가입() throws Exception {
        // given
        Member member = new Member();
        member.setName("kim");
        // member.setAddress(new Address("서울", "강가", "123-123"));

        // when
        Long savedId = memberService.join(member);

        // then
        // em.flush();
        assertEquals(member, memberRepository.findOne(savedId));
    }

    @Test
    void 중복_회원_예외() throws Exception {
        // given
        Member member1 = new Member();
        member1.setName("kim1");

        Member member2 = new Member();
        member2.setName("kim1");

        // when
        memberService.join(member1);

        // then
        IllegalStateException thrown = assertThrows(IllegalStateException.class,
                () -> memberService.join(member2));
        assertEquals("이미 존재하는 회원입니다.", thrown.getMessage());
    }
}
