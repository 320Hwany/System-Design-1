package system_design1.chapter8.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Table(name = "url")
@Entity
public class UrlJpaEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "url_id")
    private Long id;

    private String longUrl;

    private String shortUrl;

    protected UrlJpaEntity() {
    }

    private UrlJpaEntity(final String longUrl, final String shortUrl) {
        this.longUrl = longUrl;
        this.shortUrl = shortUrl;
    }

    public static UrlJpaEntity of(final String longUrl, final String shortUrl) {
        return new UrlJpaEntity(longUrl, shortUrl);
    }
}
