package hello.core.member;

public class MemberServiceImpl implements MemberService{
    //인터페이스를 의존하지만 실제 할당하는 부분에서 구현체를 의존하기 때문에 MemberServiceImpl는 추상화에도 의존하고 구체화에도 의존하는 문제점이 있음
    //DIP 위반 - 변경할 때 문제가 발생한다
    private final MemberRepository memberRepository = new MemoryMemberRepository();

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
