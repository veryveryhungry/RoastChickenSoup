package algopa.study.repository;

import algopa.study.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findByName(String name);
    List<Member> findAll();
}
