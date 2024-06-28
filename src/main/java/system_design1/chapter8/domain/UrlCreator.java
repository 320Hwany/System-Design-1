package system_design1.chapter8.domain;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.zip.CRC32;

public enum UrlCreator {

    INSTANCE;

    private static final String BASE62 = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private static final int BASE62_LENGTH = 62;
    private static final int SHORT_URL_LENGTH = 21;
    private static final SecureRandom random = new SecureRandom();

    public static String createShortUrl() {
        char[] shortUrl = new char[SHORT_URL_LENGTH];
        for (int i = 0; i < SHORT_URL_LENGTH; i++) {
            shortUrl[i] = BASE62.charAt(random.nextInt(BASE62_LENGTH));
        }

        return String.valueOf(shortUrl);
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

    // CRC32 해시
    public static String CRC32Hash(final String url) {
        CRC32 crc32 = new CRC32();
        crc32.update(url.getBytes());
        long hashValue = crc32.getValue();

        return Long.toHexString(hashValue);
    }

    // MD5, SHA-1 해시
    private static String hash(final String url, final String hashAlgorithm) {
        try {
            StringBuilder sb = new StringBuilder();
            MessageDigest md = MessageDigest.getInstance(hashAlgorithm);
            md.update(url.getBytes());
            byte[] digest = md.digest();

            for (byte b : digest) {
                sb.append(String.format("%02x", b));
            }

            return sb.toString();

        } catch (NoSuchAlgorithmException e) {
            throw new IllegalArgumentException();
        }
    }
}
