package Hackathon.Chuck_Je.service;

import Hackathon.Chuck_Je.domain.Inquire;
import Hackathon.Chuck_Je.dto.inquire.AddInquireRequest;
import Hackathon.Chuck_Je.dto.inquire.UpdateInquireRequest;
import Hackathon.Chuck_Je.repository.InquireRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class InquireService {
    private final InquireRepository inquireRepository;

    //문의 글 추가 API
    public Inquire save(AddInquireRequest request) {
        return inquireRepository.save(request.toEntity());
    }

    //문의 글 목록 조회 API
    public List<Inquire> findAll() {
        return inquireRepository.findAll();
    }

    //문의 글 조회 API
    public Inquire findById(Long id) {
        return inquireRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found: " + id));
    }

    //문의 글 수정 API
    @Transactional
    public Inquire update(long id, UpdateInquireRequest request) {
        Inquire inquire = inquireRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found: " + id));

        inquire.update(request.getTitle(), request.getContent());

        return inquire;
    }
}
