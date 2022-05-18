package ru.itis.kurguskina.springsemworkinternet.service;


import ru.itis.kurguskina.springsemworkinternet.dto.ArticleDto;
import ru.itis.kurguskina.springsemworkinternet.dto.ArticleForm;

import java.util.List;
import java.util.Optional;

public interface ArticleService {
    Optional<ArticleDto> addArticle(ArticleDto articleDto, Long userId);
    void save(ArticleForm form, Long userId);
    List<ArticleDto> getAllArticles();
    void deleteArticle(Long articleId);
    List<ArticleDto> searchArticleByTitle(String title);
    ArticleDto getArticleById(Long articleId);
//    ArticleDto save(Article article);
}
