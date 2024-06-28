package system_design1.chapter10.domain;

public record EmailNotificationEvent(
        long memberId,
        String email,
        String message
) {
}
