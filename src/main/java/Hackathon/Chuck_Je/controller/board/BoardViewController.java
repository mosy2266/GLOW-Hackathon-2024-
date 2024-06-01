package Hackathon.Chuck_Je.controller.board;

import Hackathon.Chuck_Je.domain.Article;
import Hackathon.Chuck_Je.dto.board.ArticleListViewResponse;
import Hackathon.Chuck_Je.dto.board.ArticleViewResponse;
import Hackathon.Chuck_Je.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

//게시판 뷰 컨트롤러
@RequiredArgsConstructor
@Controller //이거 RestController 써야 하나?
public class BoardViewController {
    private final BoardService boardService;

    //글 목록
    @GetMapping("/articles") //URL 바꿔야 함
    public String getArticles(Model model) {
        List<ArticleListViewResponse> articles = boardService.findAll().stream()
                .map(ArticleListViewResponse::new)
                .toList();
        model.addAttribute("articles", articles); //게시판 글 리스트 저장

        return "articleList"; //articleList.html 반환 -> 나중에 바꿔야 함
    }

    /* 조회 및 작성(수정) 기능에서 @PathVariable, @RequestParam의 경우 intelliJ로 빌드하면
    * 파라미터 이름을 명시해줘야 함.. 안 그러면 에러뜸.. 근데 @RequestParam은 어케 적어야 되노
    * @RequestParam(name="id", required=false)가 아닌가??
    * 그래서 그냥 설정(Build, Execution, Deployment -> Compiler -> Java Compiler)에서 -parameters 추가
    * 또는 gradle로 빌드.....
    */

    //글 조회
    @GetMapping("/articles/{id}")
    public String getArticle(@PathVariable Long id, Model model) {
        Article article = boardService.findById(id);
        model.addAttribute("article", new ArticleViewResponse(article));

        return "article"; //article.html 반환 -> 나중에 바꿔야 함
    }

    //글 작성 및 수정
    @GetMapping("/new-article")
    public String newArticle(@RequestParam(required = false) Long id, Model model) {
        if (id == null) {
            model.addAttribute("article", new ArticleViewResponse());
        } else {
            Article article = boardService.findById(id);
            model.addAttribute("article", new ArticleViewResponse(article));
        }

        //id가 없으면 글 생성, id가 있으면 글 수정
        return "newArticle"; //newArticle.html 반환 -> 나중에 바꿔야 함
    }
}
