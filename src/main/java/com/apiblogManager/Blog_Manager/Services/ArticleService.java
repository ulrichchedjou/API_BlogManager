package com.apiblogManager.Blog_Manager.Services;

import com.apiblogManager.Blog_Manager.DTOs.ArticleRequest;
import com.apiblogManager.Blog_Manager.exceptions.ResourceNotFoundException;
import com.apiblogManager.Blog_Manager.models.Article;
import com.apiblogManager.Blog_Manager.repositories.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
public class ArticleService {
    private final ArticleRepository articleRepository;

    @Autowired
    public ArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    public Article createArticle(ArticleRequest request) {
        Article article = new Article();
        article.setTitle(request.getTitle());
        article.setContent(request.getContent());
        article.setPublicationDate(LocalDateTime.now());
        return articleRepository.save(article);
    }

    @Transactional(readOnly = true)
    public List<Article> getAllArticles() {
        return articleRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Article getArticleById(Long id) {
        return articleRepository.findByIdWithComments(id)
                .orElseThrow(() -> new ResourceNotFoundException("Article not found!"));
    }

    public Article updateArticle(Long id, ArticleRequest request) {
        Article article = getArticleById(id);
        article.setTitle(request.getTitle());
        article.setContent(request.getContent());
        article.setPublicationDate(LocalDateTime.now());
        return articleRepository.save(article);
    }

    public void deleteArticle(Long id) {
        articleRepository.deleteById(id);
    }
}
