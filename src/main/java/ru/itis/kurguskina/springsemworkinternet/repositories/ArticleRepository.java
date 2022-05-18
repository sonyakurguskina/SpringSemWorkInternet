package ru.itis.kurguskina.springsemworkinternet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import ru.itis.kurguskina.springsemworkinternet.models.Article;


import java.util.List;

public interface ArticleRepository extends JpaRepository<Article, Long> {
    List<Article> findAllByTitleLike(String title);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "delete from users where id = :id",  nativeQuery = true)
    void deleteArticlebyId(@Param("id") Long id);
}
