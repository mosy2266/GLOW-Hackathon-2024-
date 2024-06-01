package Hackathon.Chuck_Je.dto.notice;

import Hackathon.Chuck_Je.domain.Notice;
import lombok.Getter;

@Getter
public class NoticeListViewResponse {
    private final Long id;
    private final String title;
    private final String content;

    public NoticeListViewResponse(Notice notice) {
        this.id = notice.getId();
        this.title = notice.getTitle();
        this.content = notice.getContent();
    }
}
