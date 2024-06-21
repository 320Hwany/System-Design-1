package system_design1.chapter8.dto;

public record UrlResponse(
        String shortUrl
) {

    public static UrlResponse from(final String shortUrl) {
        return new UrlResponse(shortUrl);
    }
}
