package system_design1.chapter8.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import system_design1.chapter8.persistence.entity.UrlJpaEntity;

public interface UrlRepository extends JpaRepository<UrlJpaEntity, Long> {

    boolean existsByShortUrl(final String shortUrl);
}
