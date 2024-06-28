package system_design1.chapter10.persistence.entity.notication;

import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Table(name = "fail_event")
@Entity
public class FailEventJpaEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "fail_event_id")
    private Long id;

    private Long notificationId;

    protected FailEventJpaEntity() {
    }

    private FailEventJpaEntity(final Long notificationId) {
        this.notificationId = notificationId;
    }
}
