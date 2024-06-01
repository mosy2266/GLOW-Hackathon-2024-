package Hackathon.Chuck_Je.dto.board;

import Hackathon.Chuck_Je.domain.Article;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

//글 작성을 위한 dto, 일단 이미지 업로드 기능은 X, 텍스트만..
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class AddArticleRequest {
    private String title;
    private String content;

    public Article toEntity() {
        return Article.builder()
                .title(title)
                .content(content)
                .build();
    }
}
