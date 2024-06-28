package system_design1.chapter10.persistence.repository.notification;

import org.springframework.data.jpa.repository.JpaRepository;
import system_design1.chapter10.persistence.entity.notication.FailEventJpaEntity;

public interface FailEventRepository extends JpaRepository<FailEventJpaEntity, Long> {

    void processFailEvent();
}
