package system_design1.chapter10.domain;


public record AppNotificationEvent(
        long memberId,
        String deviceToken,
        String message
) {
}
