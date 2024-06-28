package system_design1.chapter10.persistence.repository.notification;

import org.springframework.data.jpa.repository.JpaRepository;
import system_design1.chapter10.persistence.entity.notication.NotificationJpaEntity;

import java.util.List;

public interface NotificationRepository extends JpaRepository<NotificationJpaEntity, Long> {

    List<NotificationJpaEntity> findAllByMemberId(final long memberId);
}
