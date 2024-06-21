package system_design1.chapter8.presentation;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import system_design1.chapter8.application.UrlService;
import system_design1.chapter8.dto.UrlRequest;
import system_design1.chapter8.dto.ShortUrlResponse;

@RestController
public class UrlController {

    private final UrlService urlService;

    public UrlController(final UrlService urlService) {
        this.urlService = urlService;
    }

    @GetMapping("/short-url")
    public ResponseEntity<Void> redirect(@RequestParam final String shortUrl) {
        String longUrl = urlService.getLongUrl(shortUrl);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(UriComponentsBuilder.fromUriString(longUrl).build().toUri());
        return new ResponseEntity<>(headers, HttpStatus.MOVED_PERMANENTLY);
    }

    @PostMapping("/short-url")
    public ShortUrlResponse shortenUrl(@RequestBody final UrlRequest request) {
        return urlService.shortenUrl(request.longUrl());
    }
}
