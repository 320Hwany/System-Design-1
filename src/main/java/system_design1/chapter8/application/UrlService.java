package system_design1.chapter8.application;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import system_design1.chapter8.domain.UrlCreator;
import system_design1.chapter8.dto.ShortUrlResponse;
import system_design1.chapter8.persistence.entity.UrlJpaEntity;
import system_design1.chapter8.persistence.repository.UrlRepository;

@Service
public class UrlService {

    private final UrlRepository urlRepository;

    public UrlService(final UrlRepository urlRepository) {
        this.urlRepository = urlRepository;
    }

    @Transactional(readOnly = true)
    public String getLongUrl(final String shortUrl) {
        UrlJpaEntity urlJpaEntity = urlRepository.findByShortUrl(shortUrl)
                .orElseThrow(IllegalAccessError::new);

        return urlJpaEntity.getLongUrl();
    }

    @Transactional
    public ShortUrlResponse shortenUrl(final String longUrl) {
        String shortUrl = UrlCreator.createShortUrl();
        validateExistUrl(shortUrl);

        UrlJpaEntity urlJpaEntity = UrlJpaEntity.of(longUrl, shortUrl);
        urlRepository.save(urlJpaEntity);

        return ShortUrlResponse.from(shortUrl);
    }

    private void validateExistUrl(final String shortUrl) {
        if (urlRepository.existsByShortUrl(shortUrl)) {
            throw new IllegalStateException();
        }
    }
}
