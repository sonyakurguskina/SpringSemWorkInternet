package ru.itis.kurguskina.springsemworkinternet.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.itis.kurguskina.springsemworkinternet.dto.ArticleCommentDto;
import ru.itis.kurguskina.springsemworkinternet.dto.ArticleDto;
import ru.itis.kurguskina.springsemworkinternet.dto.ArticleForm;
import ru.itis.kurguskina.springsemworkinternet.models.User;
import ru.itis.kurguskina.springsemworkinternet.security.details.AccountUserDetails;
import ru.itis.kurguskina.springsemworkinternet.service.ArticleCommentService;
import ru.itis.kurguskina.springsemworkinternet.service.ArticleService;


import java.util.List;

@RequiredArgsConstructor
@Controller
public class ArticleController {

    private final ArticleService articleService;

    private final ArticleCommentService articleCommentService;


    @GetMapping("/articles")
    public String articles(Model model) {
        List<ArticleDto> articleList = articleService.getAllArticles();
        model.addAttribute("articles", articleList);
        return "articles";
    }


    @GetMapping("/search")
    public String getPostsSearchPage() {
        return "searchArticle";
    }


    @PostMapping("/articles/add")
    public String addArticle(ArticleForm form, Authentication authentication) {
        User user = ((AccountUserDetails) authentication.getPrincipal()).getUser();
        articleService.save(form, user.getId());
        return "redirect:/articles";
    }

    @GetMapping("/articles/{articleId}")
    public String CommentinArticle(@PathVariable("articleId") Long articleId, Model model) {
        ArticleDto articleDto = articleService.getArticleById(articleId);
        List<ArticleCommentDto> articleComments = articleCommentService.getAllByArticleId(articleDto.getId());
        model.addAttribute("article", articleDto);
        model.addAttribute("articleComments", articleComments);
        return "comments";
    }
}
