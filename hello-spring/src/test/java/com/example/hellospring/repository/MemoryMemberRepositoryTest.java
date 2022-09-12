package com.example.hellospring.repository;

import com.example.hellospring.domain.Member;
import com.example.hellospring.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach(){
        repository.clearStore();
    }


    @Test
    public void save(){
        Member member = new Member();
        member.setName("kang48450");
        repository.save(member);

        Member result = repository.findById(member.getId()).get();
        assertThat(member).isEqualTo(result);
    }

    @Test
    public void findByName(){
        Member member1 = new Member();
        member1.setName("Ryan");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("David");
        repository.save(member2);

        Member result = repository.findByName("Ryan").get();
        assertThat(result).isEqualTo(member1);

    }

    @Test
    public void findALl(){
        Member member1 = new Member();
        member1.setName("Ryan");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("David");
        repository.save(member2);

        List<Member> result = repository.findAll();
        assertThat(result.size()).isEqualTo(2);
    }



}
