package system_design1.chapter8.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import system_design1.chapter8.persistence.entity.UrlJpaEntity;

import java.util.Optional;

public interface UrlRepository extends JpaRepository<UrlJpaEntity, Long> {

    Optional<UrlJpaEntity> findByShortUrl(final String shortUrl);

    boolean existsByShortUrl(final String shortUrl);
}
