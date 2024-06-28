package system_design1.chapter10.application.notification;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import system_design1.chapter10.persistence.entity.notication.NotificationJpaEntity;
import system_design1.chapter10.persistence.repository.notification.NotificationRepository;

import java.util.List;

@Service
public class NotificationFinder {

    private final NotificationRepository notificationRepository;
    private final NotificationQueue notificationQueue;

    public NotificationFinder(final NotificationRepository notificationRepository,
                              final NotificationQueue notificationQueue) {
        this.notificationRepository = notificationRepository;
        this.notificationQueue = notificationQueue;
    }

    @Transactional(readOnly = true)
    public void addNotification(final long memberId) {
        List<NotificationJpaEntity> notificationJpaEntities = notificationRepository.findAllByMemberId(memberId);
        for (NotificationJpaEntity notificationJpaEntity : notificationJpaEntities) {
            // todo queue 에 넣기
        }
    }
}
