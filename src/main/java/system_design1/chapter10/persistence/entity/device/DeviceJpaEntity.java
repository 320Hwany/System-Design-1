package system_design1.chapter10.persistence.entity.device;

import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Table(name = "device")
@Entity
public class DeviceJpaEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "device_id")
    private Long id;

    private Long memberId;

    private String deviceToken;

    private LocalDateTime lastLoggedInAt;

    protected DeviceJpaEntity() {
    }

    private DeviceJpaEntity(final Long memberId, final String deviceToken, final LocalDateTime lastLoggedInAt) {
        this.memberId = memberId;
        this.deviceToken = deviceToken;
        this.lastLoggedInAt = lastLoggedInAt;
    }
}
