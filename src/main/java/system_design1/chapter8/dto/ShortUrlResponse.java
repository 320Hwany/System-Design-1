package system_design1.chapter8.dto;

public record ShortUrlResponse(
        String shortUrl
) {

    public static ShortUrlResponse from(final String shortUrl) {
        return new ShortUrlResponse(shortUrl);
    }
}
