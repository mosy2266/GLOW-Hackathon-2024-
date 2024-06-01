package Hackathon.Chuck_Je.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

//축제 게시글
@Table(name = "festival")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Festival {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "detail", nullable = false)
    private String detail;

    @Builder
    public Festival(String name, String detail) {
        this.name = name;
        this.detail = detail;
    }
}
