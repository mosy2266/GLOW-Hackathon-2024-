package Hackathon.Chuck_Je.service;

import Hackathon.Chuck_Je.domain.Article;
import Hackathon.Chuck_Je.dto.board.AddArticleRequest;
import Hackathon.Chuck_Je.dto.board.UpdateArticleRequest;
import Hackathon.Chuck_Je.repository.BoardRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BoardService {
    private final BoardRepository boardRepository;

    //게시판 글 추가 API
    public Article save(AddArticleRequest request) {
        return boardRepository.save(request.toEntity());
    }

    //게시판 글 목록 조회 API
    public List<Article> findAll() {
        return boardRepository.findAll();
    }

    //게시판 글 조회 API
    public Article findById(long id) {
        return boardRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found: " + id));
    }

    //게시판 글 수정 API
    @Transactional
    public Article update(long id, UpdateArticleRequest request) {
        Article article = boardRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found: " + id));

        article.update(request.getTitle(), request.getContent());

        return article;
    }
}
