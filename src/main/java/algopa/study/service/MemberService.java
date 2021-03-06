package algopa.study.service;

import algopa.study.domain.Member;
import algopa.study.repository.MemberRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
public class MemberService {
    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /*
     * 회원 가입
     * */
    public Long join(Member member){
        checkDuplicateMember(member);

        memberRepository.save(member);
        return member.getId();
    }
    public void deleteMember(Long id){
        System.out.println(id+"번 삭제하러 service까진 잘 작동됨");
        memberRepository.deleteById(id);
    }
    private void checkDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }
    //    전체 회원 조회
    public List<Member> findAllMembers(){
        return memberRepository.findAll();
    }
}
