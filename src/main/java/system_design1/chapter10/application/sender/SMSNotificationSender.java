package system_design1.chapter10.application.sender;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import system_design1.chapter10.domain.NotificationType;

@Slf4j
@Service
public class SMSNotificationSender implements NotificationSender {

    @Override
    public boolean isSupport(final NotificationType notificationType) {
        return notificationType == NotificationType.SMS;
    }

    @Override
    public void sendNotification() {
        log.info("SMS 전송 테스트");
    }
}
