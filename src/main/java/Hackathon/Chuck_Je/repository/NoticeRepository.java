package Hackathon.Chuck_Je.repository;

import Hackathon.Chuck_Je.domain.Notice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoticeRepository extends JpaRepository<Notice, Long> {
}
