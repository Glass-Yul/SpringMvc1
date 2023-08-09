package hello.servlet.domain.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;


class MemberRepositoryTest { // Junit5임

    MemberRepository memberRepository = MemberRepository.getInstance();

    @AfterEach // 테스트가 끝날 떄마다
    void afterEach(){
        memberRepository.clearStore();
    }

    @Test
    void save()
    {
        Member member = new Member("hello", 20);

        Member saveMember = memberRepository.save(member);

        Member findMember = memberRepository.findById(saveMember.getId());
        assertThat(findMember).isEqualTo(saveMember);
    }

    @Test
    void findAll(){
        Member member1 = new Member("memebr1", 20);
        Member member2 = new Member("memebr2", 20);
        memberRepository.save(member1);
        memberRepository.save(member2);

        List<Member> result = memberRepository.findAll();

        assertThat(result.size()).isEqualTo(2); // 갯수 확인
        assertThat(result).contains(member1, member2); // 객체 확인
    }
}