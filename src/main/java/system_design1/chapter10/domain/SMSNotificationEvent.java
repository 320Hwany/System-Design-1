package system_design1.chapter10.domain;

public record SMSNotificationEvent(
        long memberId,
        String phoneNumber,
        String message
) {
}
