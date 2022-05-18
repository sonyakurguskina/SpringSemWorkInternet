package ru.itis.kurguskina.internet.service;

import ru.itis.kurguskina.internet.dto.ArticleCommentDto;
import ru.itis.kurguskina.internet.dto.ArticleCommentForm;

import java.util.List;

public interface ArticleCommentService {
    void save(ArticleCommentForm form, Long articleId, Long userId);
    List<ArticleCommentDto> getAllByArticleId(Long articleId);
}