package system_design1.chapter8.application;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import system_design1.chapter8.dto.ShortUrlResponse;
import system_design1.chapter8.persistence.entity.UrlJpaEntity;
import system_design1.chapter8.persistence.repository.UrlRepository;

import static org.assertj.core.api.Assertions.*;

@Transactional
@SpringBootTest
class UrlServiceTest {

    @Autowired
    private UrlService urlService;

    @Autowired
    private UrlRepository urlRepository;

    @DisplayName("단축 url로 원래 url을 찾는다.")
    @Test
    void getLongUrl() {
        // given
        String longUrl = "http://www.google.com";
        String shortUrl = "abc1234";

        UrlJpaEntity urlJpaEntity = UrlJpaEntity.of(longUrl, shortUrl);
        urlRepository.save(urlJpaEntity);

        // when
        String findUrl = urlService.getLongUrl(shortUrl);

        // then
        assertThat(findUrl).isEqualTo(longUrl);
    }

    @DisplayName("입력 받은 url과 쌍을 이루는 단축 url을 저장한다.")
    @Test
    void shortenUrl() {
        // given
        String longUrl = "http://www.google.com";

        // when
        ShortUrlResponse shortUrlResponse = urlService.shortenUrl(longUrl);

        // then
        assertThat(urlRepository.count()).isEqualTo(1);
        assertThat(shortUrlResponse.shortUrl()).isNotNull();
    }
}