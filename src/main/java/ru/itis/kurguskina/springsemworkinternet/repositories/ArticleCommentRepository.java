package ru.itis.kurguskina.springsemworkinternet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.itis.kurguskina.springsemworkinternet.models.ArticleComment;

import java.util.List;

@Repository
public interface ArticleCommentRepository extends JpaRepository<ArticleComment, Long> {
    @Query(value = "select from article_comment where article_id in " +
            "(select id from article where article.user_id = :user_id)",
            nativeQuery = true)
    List<ArticleComment> getArticleCommentByUserId(@Param("user_id") Long userId);


    List<ArticleComment> getArticleCommentsByArticleId(Long articleId);
}