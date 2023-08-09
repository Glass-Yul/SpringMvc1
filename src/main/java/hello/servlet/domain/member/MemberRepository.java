package hello.servlet.domain.member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemberRepository {
    /**
     * 간단한 예제이기에 동시성 문제가 고려되어 있지 않음 => 실무에선 ConcurrentHashMap, AtomicLong 사용을 고려해야 함
     */
    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;

    private static final MemberRepository instance = new MemberRepository(); // 싱글톤

    public static MemberRepository getInstance() {
        return instance;
    }
    private MemberRepository(){

    }
    public Member save(Member member){
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }
    public Member findById(Long id) {
        return store.get(id);
    }
    public List<Member> findAll() {
        return new ArrayList<>(store.values()); // 저장되어 있는 원본은 건드리기 싫기 때문에 새로 객체를 만들어 보냄
    }
    public void clearStore() {
        store.clear(); // 테스트 시 사용
    }


}
