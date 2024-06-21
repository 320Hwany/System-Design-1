package system_design1.chapter8.application;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import system_design1.chapter8.persistence.repository.UrlRepository;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
class UrlServiceTest {

    @Autowired
    private UrlService urlService;

    @Autowired
    private UrlRepository urlRepository;

    @DisplayName("입력 받은 url과 쌍을 이루는 단축 url을 저장한다.")
    @Test
    void shortenUrl() {
        // given
        String longUrl = "http://www.google.com";

        // when
        urlService.shortenUrl(longUrl);

        // then
        assertThat(urlRepository.count()).isEqualTo(1);
    }
}