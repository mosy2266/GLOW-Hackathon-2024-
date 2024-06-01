package Hackathon.Chuck_Je.dto.notice;

import Hackathon.Chuck_Je.domain.Notice;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
public class NoticeViewResponse {
    private Long id;
    private String title;
    private String content;
    private LocalDateTime createdAt;

    public NoticeViewResponse(Notice notice) {
        this.id = notice.getId();
        this.title = notice.getTitle();
        this.content = notice.getContent();
        this.createdAt = notice.getCreatedAt();
    }
}
