package ru.itis.kurguskina.springsemworkinternet.service;

import ru.itis.kurguskina.springsemworkinternet.dto.ArticleCommentDto;
import ru.itis.kurguskina.springsemworkinternet.dto.ArticleCommentForm;

import java.util.List;

public interface ArticleCommentService {
    void save(ArticleCommentForm form, Long articleId, Long userId);
    List<ArticleCommentDto> getAllByArticleId(Long articleId);
}