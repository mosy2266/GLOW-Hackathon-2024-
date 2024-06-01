package Hackathon.Chuck_Je.controller.notice;

import Hackathon.Chuck_Je.domain.Notice;
import Hackathon.Chuck_Je.dto.notice.NoticeResponse;
import Hackathon.Chuck_Je.service.NoticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class NoticeApiController {
    private final NoticeService noticeService;

    //공지 목록
    @GetMapping("/api/notice")
    public ResponseEntity<List<NoticeResponse>> findAllNotices() {
        List<NoticeResponse> notices = noticeService.findAll()
                .stream()
                .map(NoticeResponse::new)
                .toList();

        return ResponseEntity.ok()
                .body(notices);
    }

    //공지 조회
    @GetMapping("/api/notice/{id}")
    public ResponseEntity<NoticeResponse> findNotice(@PathVariable long id) {
        Notice notice = noticeService.findById(id);

        return ResponseEntity.ok()
                .body(new NoticeResponse(notice));
    }
}
