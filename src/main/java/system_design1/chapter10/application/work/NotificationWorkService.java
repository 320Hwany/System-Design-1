package system_design1.chapter10.application.work;

import org.springframework.stereotype.Service;
import system_design1.chapter10.application.notification.NotificationQueue;
import system_design1.chapter10.application.sender.NotificationSender;
import system_design1.chapter10.domain.AppNotificationEvent;
import system_design1.chapter10.domain.NotificationType;
import system_design1.chapter10.persistence.repository.notification.FailEventRepository;

import java.util.List;

@Service
public class NotificationWorkService {

    private final NotificationQueue notificationQueue;
    private final List<NotificationSender> notificationSenders;
    private final FailEventRepository failEventRepository;

    public NotificationWorkService(final NotificationQueue notificationQueue,
                                   final List<NotificationSender> notificationSenders,
                                   final FailEventRepository failEventRepository) {
        this.notificationQueue = notificationQueue;
        this.notificationSenders = notificationSenders;
        this.failEventRepository = failEventRepository;
    }

    // todo
    public void sendNotification(final NotificationType notificationType) {
        AppNotificationEvent appNotificationEvent = notificationQueue.popAppNotificationEvent();
        for (NotificationSender notificationSender : notificationSenders) {

            try {
                if (notificationSender.isSupport(notificationType)) {
                    notificationSender.sendNotification();
                }
            } catch (IllegalArgumentException e) {
                failEventRepository.processFailEvent();
            }
        }
    }
}
