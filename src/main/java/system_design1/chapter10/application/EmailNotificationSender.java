package system_design1.chapter10.application;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class EmailNotificationSender implements NotificationSender {

    @Override
    public void sendNotification() {
        log.info("Email 전송 테스트");
    }
}
