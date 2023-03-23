package jpabook.jpashop;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class MemberRepository {

    @PersistenceContext
    private EntityManager em;

    // 저장하는 코드
    // 왜 Member 가 아닌 Id를 리턴하지 ?
    //command 와 쿼리를 분리하란 원칙에 의해서. 커맨드성일때 리턴값을 거의 안만듬. 그러나 ID가 있으면 다음에 조회할 수 있기때문에.
    public Long save(Member member) {
        em.persist(member);
        return member.getId();
    }

    public Member find(Long id) {
        return em.find(Member.class, id);
    }

}
