package Hackathon.Chuck_Je.service;

import Hackathon.Chuck_Je.domain.Festival;
import Hackathon.Chuck_Je.repository.FestivalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class FestivalService {
    private final FestivalRepository festivalRepository;

    //축제 조회 API
    public Festival findById(long id) {
        return festivalRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found: " + id));
    }

    //축제 목록 조회 API
    public List<Festival> findAll() {
        return festivalRepository.findAll();
    }
}
