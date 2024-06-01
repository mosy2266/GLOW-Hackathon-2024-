package Hackathon.Chuck_Je.service;

import Hackathon.Chuck_Je.domain.Notice;
import Hackathon.Chuck_Je.repository.NoticeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class NoticeService {
    private final NoticeRepository noticeRepository;

    //공지 조회 API
    public Notice findById(long id) {
        return noticeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found: " + id));
    }

    //공지 목록 조회 API
    public List<Notice> findAll() {
        return noticeRepository.findAll();
    }
}
