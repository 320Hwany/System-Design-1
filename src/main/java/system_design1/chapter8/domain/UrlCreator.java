package system_design1.chapter8.domain;

import java.util.Random;

public enum UrlCreator {

    INSTANCE;

    private static final String BASE62 = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private static final int BASE62_LENGTH = 62;
    private static final int SHORT_URL_LENGTH = 7;
    private static final Random random = new Random();

    public static String createShortUrl() {
        StringBuilder shortUrl = new StringBuilder(SHORT_URL_LENGTH);
        for (int i = 0; i < SHORT_URL_LENGTH; i++) {
            shortUrl.append(BASE62.charAt(random.nextInt(BASE62_LENGTH)));
        }

        return shortUrl.toString();
    }

    // 유일한 숫자 -> base62 인코딩
    public static String encode(long number) {
        StringBuilder encodedString = new StringBuilder();

        if (number == 0) {
            return "0";
        }

        while (number > 0) {
            int remainder = (int) (number % BASE62_LENGTH);
            encodedString.append(BASE62.charAt(remainder));
            number /= BASE62_LENGTH;
        }

        return encodedString.reverse().toString();
    }
}
