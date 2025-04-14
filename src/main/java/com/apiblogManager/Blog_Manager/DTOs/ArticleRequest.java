package com.apiblogManager.Blog_Manager.DTOs;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;


public class ArticleRequest {
    @NotBlank
    private String title;
    @NotBlank
    private String content;

    //@NotNull
    //@CreatedDate
    //@Column(name = "created_at", columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    //private LocalDateTime publicationDate;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    //public LocalDateTime getPublicationDate() {
    //    return publicationDate;
    //}

    //public void setPublicationDate(LocalDateTime publicationDate) {
    //    this.publicationDate = publicationDate;
    //}
}
