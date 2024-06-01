package Hackathon.Chuck_Je.repository;

import Hackathon.Chuck_Je.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepository extends JpaRepository<Article, Long> {
}
