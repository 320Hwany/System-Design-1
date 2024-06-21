package system_design1.chapter8.presentation;

import org.springframework.web.bind.annotation.*;
import system_design1.chapter8.application.UrlService;
import system_design1.chapter8.dto.UrlRequest;
import system_design1.chapter8.dto.UrlResponse;

@RestController
public class UrlController {

    private final UrlService urlService;

    public UrlController(final UrlService urlService) {
        this.urlService = urlService;
    }

    @GetMapping("/short-url")
    public UrlResponse getShortUrl(@RequestParam final String longUrl) {
        return urlService.getShortUrl(longUrl);
    }

    @PostMapping("/short-url")
    public void shortenUrl(@RequestBody final UrlRequest request) {
        urlService.shortenUrl(request.longUrl());
    }
}
