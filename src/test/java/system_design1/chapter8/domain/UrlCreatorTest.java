package system_design1.chapter8.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class UrlCreatorTest {

    @DisplayName("base62 기반으로 7자리 문자열을 생성한다.")
    @Test
    void createShortUrl() {
        // when
        String shortUrl = UrlCreator.createShortUrl();

        // then
        assertThat(shortUrl.length()).isEqualTo(7);
    }

    @DisplayName("영어 대소문자와 숫자만을 포함한다.")
    @Test
    void includeEnglishAndNumber() {
        // when
        String shortUrl = UrlCreator.createShortUrl();
        char[] charArray = shortUrl.toCharArray();

        // then
        for (char c : charArray) {
            assertThat(Character.isLetterOrDigit(c)).isTrue();
        }
    }
}