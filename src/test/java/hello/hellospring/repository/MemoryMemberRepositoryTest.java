package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();
    Member member = new Member();

    @AfterEach
    void afterEach() {
        repository.clearStore();
    }

    @Test
    void findByIdTest() {
        member.setName("spring");
        repository.save(member);
        Member result = repository.findById(member.getId()).get();
        assertThat(member).isEqualTo(result);
    }

    @Test
    void findByNameTest() {
        member.setName("spring");
        repository.save(member);
        Member result = repository.findByName("spring").get();
        assertThat(member).isEqualTo(result);
    }

    @Test
    void findAllTest() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        List<Member> result = repository.findAll();

        assertThat(result.size()).isEqualTo(2);
    }
}