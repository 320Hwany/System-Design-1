package system_design1.chapter10.persistence.repository.member;

import org.springframework.data.jpa.repository.JpaRepository;
import system_design1.chapter10.persistence.entity.member.MemberJpaEntity;

public interface MemberRepository extends JpaRepository<MemberJpaEntity, Long> {
}
