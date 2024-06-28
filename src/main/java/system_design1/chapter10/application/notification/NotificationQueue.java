package system_design1.chapter10.application.notification;

import org.springframework.stereotype.Service;
import system_design1.chapter10.domain.AppNotificationEvent;
import system_design1.chapter10.domain.EmailNotificationEvent;
import system_design1.chapter10.domain.SMSNotificationEvent;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

@Service
public class NotificationQueue {

    private final Queue<AppNotificationEvent> appNotificationEventQueue = new ConcurrentLinkedQueue<>();
    private final Queue<SMSNotificationEvent> SMSNotificationEventQueue = new ConcurrentLinkedQueue<>();
    private final Queue<EmailNotificationEvent> EmailNotificationEventQueue = new ConcurrentLinkedQueue<>();

    public void addAppNotificationEvent(final AppNotificationEvent appNotificationEvent) {
        appNotificationEventQueue.add(appNotificationEvent);
    }

    public AppNotificationEvent popAppNotificationEvent() {
        return appNotificationEventQueue.poll();
    }

    // todo 나머지 큐
}
