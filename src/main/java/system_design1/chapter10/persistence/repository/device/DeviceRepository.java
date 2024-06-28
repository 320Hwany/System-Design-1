package system_design1.chapter10.persistence.repository.device;

import org.springframework.data.jpa.repository.JpaRepository;
import system_design1.chapter10.persistence.entity.device.DeviceJpaEntity;

public interface DeviceRepository extends JpaRepository<DeviceJpaEntity, Long> {
}
