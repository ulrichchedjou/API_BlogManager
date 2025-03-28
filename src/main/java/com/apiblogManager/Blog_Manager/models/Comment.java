package com.apiblogManager.Blog_Manager.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String content;
    private LocalDateTime createdAt;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "article_id")
    private Article article;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }

    // Explicit setter for article to ensure it's available
    public void setArticle(Article article) {
        this.article = article;
    }

    // Explicit setter for content to ensure it's available
    public void setContent(String content) {
        this.content = content;
    }

    // Explicit getter for content to ensure it's available
    public String getContent() {
        return content;
    }
}
