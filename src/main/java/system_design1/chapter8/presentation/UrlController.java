package system_design1.chapter8.presentation;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import system_design1.chapter8.application.UrlService;
import system_design1.chapter8.dto.UrlRequest;

@RestController
public class UrlController {

    private final UrlService urlService;

    public UrlController(final UrlService urlService) {
        this.urlService = urlService;
    }

    @PostMapping("/shorten")
    public void shortenUrl(@RequestBody final UrlRequest request) {
        urlService.shortenUrl(request.longUrl());
    }
}
