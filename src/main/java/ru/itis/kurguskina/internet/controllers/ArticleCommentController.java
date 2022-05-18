package ru.itis.kurguskina.internet.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.itis.kurguskina.internet.dto.ArticleCommentForm;
import ru.itis.kurguskina.internet.models.User;
import ru.itis.kurguskina.internet.security.details.AccountUserDetails;
import ru.itis.kurguskina.internet.service.ArticleCommentService;
import ru.itis.kurguskina.internet.service.ArticleService;

@Controller
@RequiredArgsConstructor
public class ArticleCommentController {
    private final ArticleCommentService articleCommentService;
    private final ArticleService articleService;

    @PostMapping("/createComment/{articleId}")
    public String addComment(@PathVariable("articleId") Long articleId, ArticleCommentForm form, Authentication authentication){
        User user = ((AccountUserDetails) authentication.getPrincipal()).getUser();
        articleCommentService.save(form, articleId, user.getId());
        return "redirect:/articles/{articleId}";
    }
}