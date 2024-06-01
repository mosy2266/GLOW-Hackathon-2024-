package Hackathon.Chuck_Je.controller.board;

import Hackathon.Chuck_Je.domain.Article;
import Hackathon.Chuck_Je.dto.board.AddArticleRequest;
import Hackathon.Chuck_Je.dto.board.ArticleResponse;
import Hackathon.Chuck_Je.dto.board.UpdateArticleRequest;
import Hackathon.Chuck_Je.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class BoardApiController {

    private final BoardService boardService;

    //글 작성
    @PostMapping("/api/articles")
    public ResponseEntity<Article> addArticle(@RequestBody AddArticleRequest request) {
        Article savedArticle = boardService.save(request);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(savedArticle);
    }

    //글 목록 조회
    @GetMapping("/api/articles")
    public ResponseEntity<List<ArticleResponse>> findAllArticles() {
        List<ArticleResponse> articles = boardService.findAll()
                .stream()
                .map(ArticleResponse::new)
                .toList();

        return ResponseEntity.ok()
                .body(articles);
    }

    //글 조회
    @GetMapping("/api/articles/{id}")
    public ResponseEntity<ArticleResponse> findArticle(@PathVariable long id) {
        Article article = boardService.findById(id);

        return ResponseEntity.ok()
                .body(new ArticleResponse(article));
    }

    //글 수정
    @PutMapping("/api/articles/{id}")
    public ResponseEntity<Article> updateArticle(@PathVariable long id, @RequestBody UpdateArticleRequest request) {
        Article updatedArticle = boardService.update(id, request);

        return ResponseEntity.ok()
                .body(updatedArticle);
    }
}
