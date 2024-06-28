package system_design1.chapter10.persistence.entity.notication;

import jakarta.persistence.*;
import lombok.Getter;
import system_design1.chapter10.domain.NotificationType;
import system_design1.chapter10.dto.NotificationAppendRequest;

@Getter
@Table(name = "notification")
@Entity
public class NotificationJpaEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "notification_id")
    private Long id;

    private Long memberId;

    @Enumerated(EnumType.STRING)
    private NotificationType notificationType;

    private String message;

    protected NotificationJpaEntity() {
    }

    private NotificationJpaEntity(final Long memberId, final NotificationType notificationType,
                                  final String message) {
        this.memberId = memberId;
        this.notificationType = notificationType;
        this.message = message;
    }

    public static NotificationJpaEntity of(final NotificationAppendRequest notificationAppendRequest) {
        return new NotificationJpaEntity(
                notificationAppendRequest.memberId(),
                notificationAppendRequest.notificationType(),
                notificationAppendRequest.message()
        );
    }

    public boolean isAppPush() {
        return notificationType.equals(NotificationType.APP_PUSH);
    }

    public boolean isSMS() {
        return notificationType.equals(NotificationType.SMS);
    }

    public boolean isEmail() {
        return notificationType.equals(NotificationType.EMAIL);
    }
}
