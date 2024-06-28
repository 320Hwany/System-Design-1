package system_design1.chapter8.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.UUID;

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

    @DisplayName("숫자를 base62 방식으로 인코딩한다.")
    @Test
    void encode() {
        // given
        long number1 = 0;
        long number2 = 10;
        long number3 = 61;
        long number4 = 62;

        // when
        String encode1 = UrlCreator.encode(number1);
        String encode2 = UrlCreator.encode(number2);
        String encode3 = UrlCreator.encode(number3);
        String encode4 = UrlCreator.encode(number4);

        // then
        assertThat(encode1).isEqualTo("0");
        assertThat(encode2).isEqualTo("A");
        assertThat(encode3).isEqualTo("z");
        assertThat(encode4).isEqualTo("10");
    }

    @Test
    void base62CreateTest() {
        LocalDateTime startDateTime = LocalDateTime.now();

        for (int i = 0; i < 100000; i++) {
            String shortUrl = UrlCreator.createShortUrl();
        }

        String shortUrl = UrlCreator.createShortUrl();
        System.out.println(shortUrl);

        LocalDateTime endDateTime = LocalDateTime.now();
        Duration duration = Duration.between(startDateTime, endDateTime);
        System.out.println(duration.toMillis());
    }

    @Test
    void UUIDCreateTest() {
        LocalDateTime startDateTime = LocalDateTime.now();

        for (int i = 0; i < 100000; i++) {
            UUID uuid = UUID.randomUUID();
        }

        UUID uuid = UUID.randomUUID();
        System.out.println(uuid);

        LocalDateTime endDateTime = LocalDateTime.now();
        Duration duration = Duration.between(startDateTime, endDateTime);
        System.out.println(duration.toMillis());
    }

    @Test
    void bothCreateTest() {
        LocalDateTime startDateTime1 = LocalDateTime.now();

        for (int i = 0; i < 100000; i++) {
            String shortUrl = UrlCreator.createShortUrl();
        }

        LocalDateTime endDateTime1 = LocalDateTime.now();
        long millis1 = Duration.between(startDateTime1, endDateTime1).toMillis();


        LocalDateTime startDateTime2 = LocalDateTime.now();

        for (int i = 0; i < 100000; i++) {
            UUID uuid = UUID.randomUUID();
        }

        LocalDateTime endDateTime2 = LocalDateTime.now();
        long millis2 = Duration.between(startDateTime2, endDateTime2).toMillis();

        System.out.println((double) millis2 / millis1);
    }
}