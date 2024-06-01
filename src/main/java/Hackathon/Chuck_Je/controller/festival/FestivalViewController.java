package Hackathon.Chuck_Je.controller.festival;

import Hackathon.Chuck_Je.domain.Festival;
import Hackathon.Chuck_Je.dto.festival.FestivalListViewResponse;
import Hackathon.Chuck_Je.dto.festival.FestivalViewResponse;
import Hackathon.Chuck_Je.service.FestivalService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

//축제 뷰 컨트롤러
@RequiredArgsConstructor
@Controller
public class FestivalViewController {
    private final FestivalService festivalService;

    //축제 목록
    @GetMapping("/festival")
    public String getFestivals(Model model) {
        List<FestivalListViewResponse> festivals = festivalService.findAll().stream()
                .map(FestivalListViewResponse::new)
                .toList();
        model.addAttribute("festivals", festivals);

        return "festivalList";
    }

    //축제 조회
    @GetMapping("/festival/{id}")
    public String getFestival(@PathVariable Long id, Model model) {
        Festival festival = festivalService.findById(id);
        model.addAttribute("festival", new FestivalViewResponse(festival));

        return "festival";
    }
}
