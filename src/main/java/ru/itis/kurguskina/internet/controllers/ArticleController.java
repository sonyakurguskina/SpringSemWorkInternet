package ru.itis.kurguskina.internet.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.itis.kurguskina.internet.dto.ArticleCommentDto;
import ru.itis.kurguskina.internet.dto.ArticleDto;
import ru.itis.kurguskina.internet.dto.ArticleForm;
import ru.itis.kurguskina.internet.dto.UserDto;
import ru.itis.kurguskina.internet.models.User;
import ru.itis.kurguskina.internet.security.details.AccountUserDetails;
import ru.itis.kurguskina.internet.service.ArticleCommentService;
import ru.itis.kurguskina.internet.service.ArticleService;


import javax.servlet.http.HttpSession;
import javax.xml.ws.Response;
import java.util.List;
import java.util.Locale;

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
