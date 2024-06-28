package system_design1.chapter10.application.sender;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import system_design1.chapter10.domain.NotificationType;

@Slf4j
@Service
public class AppPushNotificationSender implements NotificationSender {

    @Override
    public boolean isSupport(final NotificationType notificationType) {
        return notificationType == NotificationType.APP_PUSH;
    }

    @Override
    public void sendNotification() {
        log.info("앱 푸쉬 알람 전송 테스트");
    }
}
