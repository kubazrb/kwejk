package pl.edu.wat.pze.kwejk.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.edu.wat.pze.kwejk.model.Article;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {
}
