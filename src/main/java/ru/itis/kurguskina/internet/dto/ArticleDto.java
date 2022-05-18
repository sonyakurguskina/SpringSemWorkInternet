package ru.itis.kurguskina.internet.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.kurguskina.internet.models.Article;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ArticleDto {

    private Long id;

    private LocalDate createdAt;

    @NotBlank
    @Size(min = 2, max = 20)
    private String title;

    @NotBlank
    @Size(min = 2, max = 2000)
    private String text;

    private Long userId;

    public static ArticleDto from(Article article) {
        return ArticleDto.builder()
                .id(article.getId())
                .createdAt(article.getCreatedAt())
                .title(article.getTitle())
                .text(article.getText())
                .userId(article.getUser().getId())
                .build();
    }

    public static List<ArticleDto> from(List<Article> articles) {
        return articles.stream().map(ArticleDto::from).collect(Collectors.toList());
    }


}
