package system_design1.chapter8.application;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import system_design1.chapter8.dto.UrlResponse;
import system_design1.chapter8.persistence.entity.UrlJpaEntity;
import system_design1.chapter8.persistence.repository.UrlRepository;

import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

@Transactional
@SpringBootTest
class UrlServiceTest {

    @Autowired
    private UrlService urlService;

    @Autowired
    private UrlRepository urlRepository;

    @DisplayName("원래 url로 단축 url을 찾는다.")
    @Test
    void getShortUrl() {
        // given
        String longUrl = "http://www.google.com";
        String shortUrl = "abc1234";

        UrlJpaEntity urlJpaEntity = UrlJpaEntity.of(longUrl, shortUrl);
        urlRepository.save(urlJpaEntity);

        // when
        UrlResponse urlResponse = urlService.getShortUrl(longUrl);

        // then
        assertThat(urlResponse.shortUrl()).isEqualTo(shortUrl);
    }

    @DisplayName("입력 받은 url과 쌍을 이루는 단축 url을 저장한다.")
    @Test
    void shortenUrl() {
        // given
        String longUrl = "http://www.google.com";

        // when
        urlService.shortenUrl(longUrl);

        // then
        Optional<UrlJpaEntity> optionalUrlJpaEntity = urlRepository.findByLongUrl(longUrl);
        assertThat(urlRepository.count()).isEqualTo(1);
        assertThat(optionalUrlJpaEntity).isNotNull();
    }
}