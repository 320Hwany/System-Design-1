package system_design1.chapter10.application.notification;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import system_design1.chapter10.dto.NotificationAppendRequest;
import system_design1.chapter10.persistence.entity.notication.NotificationJpaEntity;
import system_design1.chapter10.persistence.repository.notification.NotificationRepository;

@Service
public class NotificationAppender {

    private final NotificationRepository notificationRepository;

    public NotificationAppender(final NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    @Transactional
    public void save(final NotificationAppendRequest notificationAppendRequest) {
        NotificationJpaEntity notificationJpaEntity = NotificationJpaEntity.of(notificationAppendRequest);
        notificationRepository.save(notificationJpaEntity);
    }
}
