package Hackathon.Chuck_Je.dto.inquire;

import Hackathon.Chuck_Je.domain.Inquire;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@NoArgsConstructor
@Getter
public class InquireViewResponse {
    private Long id;
    private String title;
    private String content;
    private String createdAt = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm"));

    public InquireViewResponse(Inquire inquire) {
        this.id = inquire.getId();
        this.title = inquire.getTitle();
        this.content = inquire.getContent();
        this.createdAt = inquire.getCreatedAt();
    }
}
