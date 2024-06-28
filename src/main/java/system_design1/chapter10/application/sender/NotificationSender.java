package system_design1.chapter10.application.sender;

import system_design1.chapter10.domain.NotificationType;

public interface NotificationSender {

    boolean isSupport(final NotificationType notificationType);

    void sendNotification();
}