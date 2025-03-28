package com.apiblogManager.Blog_Manager.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "article_id")
    @JsonBackReference
    private Article article;


    @Column(name = "created_at")
    private LocalDateTime createdAt = LocalDateTime.now();
    /**
     * Sets the createdAt timestamp to the current date and time before the entity is persisted.
     * This method is automatically called by the JPA provider when the entity is being persisted.
     */
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public Article getArticle() {
        return article;
    }
}
