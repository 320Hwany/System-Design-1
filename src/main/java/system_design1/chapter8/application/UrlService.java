package system_design1.chapter8.application;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import system_design1.chapter8.domain.UrlCreator;
import system_design1.chapter8.dto.UrlResponse;
import system_design1.chapter8.persistence.entity.UrlJpaEntity;
import system_design1.chapter8.persistence.repository.UrlRepository;

@Service
public class UrlService {

    private final UrlRepository urlRepository;

    public UrlService(final UrlRepository urlRepository) {
        this.urlRepository = urlRepository;
    }

    @Transactional(readOnly = true)
    public UrlResponse getShortUrl(final String longUrl) {
        UrlJpaEntity urlJpaEntity = urlRepository.findByLongUrl(longUrl)
                .orElseThrow(IllegalArgumentException::new);

        return UrlResponse.from(urlJpaEntity.getShortUrl());
    }

    @Transactional
    public void shortenUrl(final String longUrl) {
        String shortUrl = UrlCreator.createShortUrl();
        validateExistUrl(shortUrl);

        UrlJpaEntity urlJpaEntity = UrlJpaEntity.of(longUrl, shortUrl);
        urlRepository.save(urlJpaEntity);
    }

    private void validateExistUrl(final String shortUrl) {
        if (urlRepository.existsByShortUrl(shortUrl)) {
            throw new IllegalStateException();
        }
    }
}
