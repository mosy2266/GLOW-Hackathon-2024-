package Hackathon.Chuck_Je.controller.festival;

import Hackathon.Chuck_Je.domain.Festival;
import Hackathon.Chuck_Je.dto.festival.FestivalResponse;
import Hackathon.Chuck_Je.service.FestivalService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class FestivalApiController {
    private final FestivalService festivalService;

    //축제 목록
    @GetMapping("/api/festival")
    public ResponseEntity<List<FestivalResponse>> findAllFestivals() {
        List<FestivalResponse> festivals = festivalService.findAll()
                .stream()
                .map(FestivalResponse::new)
                .toList();

        return ResponseEntity.ok()
                .body(festivals);
    }

    //축제 조회
    @GetMapping("/api/festival/{id}")
    public ResponseEntity<FestivalResponse> findFestival(@PathVariable long id) {
        Festival festival = festivalService.findById(id);

        return ResponseEntity.ok()
                .body(new FestivalResponse(festival));
    }
}
