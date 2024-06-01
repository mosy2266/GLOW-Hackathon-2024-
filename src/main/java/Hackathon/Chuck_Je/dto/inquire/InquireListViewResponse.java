package Hackathon.Chuck_Je.dto.inquire;

import Hackathon.Chuck_Je.domain.Inquire;
import lombok.Getter;

@Getter
public class InquireListViewResponse {
    private final Long id;
    private final String title;
    private final String content;
    private final String createdAt;

    public InquireListViewResponse(Inquire inquire) {
        this.id = inquire.getId();
        this.title = inquire.getTitle();
        this.content = inquire.getContent();
        this.createdAt = inquire.getCreatedAt();
    }
}
