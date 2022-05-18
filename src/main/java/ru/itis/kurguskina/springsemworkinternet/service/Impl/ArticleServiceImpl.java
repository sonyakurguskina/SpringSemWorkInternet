package ru.itis.kurguskina.springsemworkinternet.service.Impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import ru.itis.kurguskina.springsemworkinternet.dto.ArticleDto;
import ru.itis.kurguskina.springsemworkinternet.dto.ArticleForm;
import ru.itis.kurguskina.springsemworkinternet.helper.exceptions.AccountNotExistsException;
import ru.itis.kurguskina.springsemworkinternet.models.Article;
import ru.itis.kurguskina.springsemworkinternet.models.User;
import ru.itis.kurguskina.springsemworkinternet.repositories.ArticleRepository;
import ru.itis.kurguskina.springsemworkinternet.repositories.UserRepository;
import ru.itis.kurguskina.springsemworkinternet.service.ArticleService;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static ru.itis.kurguskina.springsemworkinternet.dto.ArticleDto.from;


@Service
@RequiredArgsConstructor
@Log4j2
public class ArticleServiceImpl implements ArticleService {

    private final ArticleRepository articleRepository;

    private final UserRepository userRepository;

    @Override
    public Optional<ArticleDto> addArticle(ArticleDto articleDto, Long userId) {
        User user = userRepository.findById(userId).orElseThrow(AccountNotExistsException::new);
        Article newArticle = Article.builder()
                .title(articleDto.getTitle())
                .text(articleDto.getText())
                .createdAt(LocalDate.now())
                .user(user)
                .build();
        articleRepository.save(newArticle);

        user.getArticles().add(newArticle);
        return Optional.of(ArticleDto.from(newArticle));
       }

    @Override
    public void save(ArticleForm form, Long userId) {
        User user = userRepository.getById(userId);

        Article article = Article.builder()
                .title(form.getTitle())
                .text(form.getText())
                .user(user)
                .build();

        articleRepository.save(article);
    }

    @Override
    public void deleteArticle(Long articleId) {
        userRepository.deleteUser(articleId);
    }

    @Override
    public List<ArticleDto> searchArticleByTitle(String title) {
        return from(articleRepository.findAllByTitleLike('%' + title + '%'));
    }

    @Override
    public ArticleDto getArticleById(Long articleId) {
        return ArticleDto.from(articleRepository.findById(articleId).get());
    }


    @Override
    public List<ArticleDto> getAllArticles() {
        return from(articleRepository.findAll());
    }
}
