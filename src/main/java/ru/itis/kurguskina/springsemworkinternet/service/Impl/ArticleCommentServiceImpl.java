package ru.itis.kurguskina.springsemworkinternet.service.Impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.itis.kurguskina.springsemworkinternet.dto.ArticleCommentDto;
import ru.itis.kurguskina.springsemworkinternet.dto.ArticleCommentForm;
import ru.itis.kurguskina.springsemworkinternet.models.Article;
import ru.itis.kurguskina.springsemworkinternet.models.ArticleComment;
import ru.itis.kurguskina.springsemworkinternet.models.User;
import ru.itis.kurguskina.springsemworkinternet.repositories.ArticleCommentRepository;
import ru.itis.kurguskina.springsemworkinternet.repositories.ArticleRepository;
import ru.itis.kurguskina.springsemworkinternet.repositories.UserRepository;
import ru.itis.kurguskina.springsemworkinternet.service.ArticleCommentService;

import java.util.List;

import static ru.itis.kurguskina.springsemworkinternet.dto.ArticleCommentDto.fromModelList;


@RequiredArgsConstructor
@Service
public class ArticleCommentServiceImpl implements ArticleCommentService {
    private final ArticleCommentRepository articleCommentRepository;
    private final ArticleRepository articleRepository;
    private final UserRepository userRepository;

    @Override
    public void save(ArticleCommentForm form, Long articleId, Long userId) {
        Article article = articleRepository.getById(articleId);
        User user = userRepository.getById(userId);


        ArticleComment articleComment = ArticleComment.builder()
                .text(form.getText())
                .user(user)
                .article(article)
                .build();

        articleCommentRepository.save(articleComment);
    }

    @Override
    public List<ArticleCommentDto> getAllByArticleId(Long articleId) {
        List<ArticleComment> articleComments = articleCommentRepository.getArticleCommentsByArticleId(articleId);

        return fromModelList(articleComments);
    }
}
