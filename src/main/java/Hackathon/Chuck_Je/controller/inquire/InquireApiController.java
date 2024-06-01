package Hackathon.Chuck_Je.controller.inquire;

import Hackathon.Chuck_Je.domain.Inquire;
import Hackathon.Chuck_Je.dto.inquire.AddInquireRequest;
import Hackathon.Chuck_Je.dto.inquire.InquireResponse;
import Hackathon.Chuck_Je.dto.inquire.UpdateInquireRequest;
import Hackathon.Chuck_Je.service.InquireService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class InquireApiController {
    private final InquireService inquireService;

    //문의 글 작성
    @PostMapping("/api/inquires")
    public ResponseEntity<Inquire> addInquire(@RequestBody AddInquireRequest request) {
        Inquire savedInquire = inquireService.save(request);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(savedInquire);
    }

    //문의 목록 조회
    @GetMapping("/api/inquires")
    public ResponseEntity<List<InquireResponse>> findAllInquires() {
        List<InquireResponse> inquires = inquireService.findAll()
                .stream()
                .map(InquireResponse::new)
                .toList();

        return ResponseEntity.ok()
                .body(inquires);
    }

    //문의 글 조회
    @GetMapping("/api/inquires/{id}")
    public ResponseEntity<InquireResponse> findInquire(@PathVariable long id) {
        Inquire inquire = inquireService.findById(id);

        return ResponseEntity.ok()
                .body(new InquireResponse(inquire));
    }

    //문의 글 수정
    @PutMapping("/api/inquires/{id}")
    public ResponseEntity<Inquire> updateInquire(@PathVariable long id, @RequestBody UpdateInquireRequest request) {
        Inquire updatedInquire = inquireService.update(id, request);

        return ResponseEntity.ok()
                .body(updatedInquire);
    }
}
