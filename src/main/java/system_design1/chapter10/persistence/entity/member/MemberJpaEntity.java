package system_design1.chapter10.persistence.entity.member;

import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Table(name = "member")
@Entity
public class MemberJpaEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    private String email;

    private int phoneNumber;

    private LocalDateTime createdArt;

    protected MemberJpaEntity() {
    }

    private MemberJpaEntity(final String email, final int phoneNumber, final LocalDateTime createdArt) {
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.createdArt = createdArt;
    }
}