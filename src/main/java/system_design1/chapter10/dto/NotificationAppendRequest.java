package system_design1.chapter10.dto;

import system_design1.chapter10.domain.NotificationType;

public record NotificationAppendRequest(
        long memberId,
        NotificationType notificationType,
        String message
) {
}
