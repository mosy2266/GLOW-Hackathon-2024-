package Hackathon.Chuck_Je.dto.board;

import Hackathon.Chuck_Je.domain.Article;
import lombok.Getter;

import java.time.LocalDateTime;

//글 목록 조회를 위한 dto
@Getter
public class ArticleResponse {
    private final Long id;
    private final String title;
    private final String content;
    private final LocalDateTime createdAt;

    public ArticleResponse(Article article) {
        this.id = article.getId();
        this.title = article.getTitle();
        this.content = article.getContent();
        this.createdAt = article.getCreatedAt();
    }
}
