package ru.itis.kurguskina.springsemworkinternet.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.kurguskina.springsemworkinternet.models.Article;
import ru.itis.kurguskina.springsemworkinternet.models.ArticleComment;
import ru.itis.kurguskina.springsemworkinternet.models.User;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ArticleCommentDto {
    private Long id;
    private String text;
    private User user;
    private Article article;

    public static ArticleCommentDto fromModel(ArticleComment articleComment){
        return ArticleCommentDto.builder()
                .id(articleComment.getId())
                .text(articleComment.getText())
                .user(articleComment.getUser())
                .article(articleComment.getArticle())
                .build();
    }

    public static List<ArticleCommentDto> fromModelList(List<ArticleComment> articleComments){
        return articleComments.stream().map(ArticleCommentDto::fromModel)
                .collect(Collectors.toList());
    }
}