package com.apiblogManager.Blog_Manager.Services;

import com.apiblogManager.Blog_Manager.DTOs.CommentRequest;
import com.apiblogManager.Blog_Manager.models.Article;
import com.apiblogManager.Blog_Manager.models.Comment;
import com.apiblogManager.Blog_Manager.repositories.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    private final CommentRepository commentRepository;
    private final ArticleService articleService;

    @Autowired
    public CommentService(CommentRepository commentRepository, ArticleService articleService) {
        this.commentRepository = commentRepository;
        this.articleService = articleService;
    }

    public Comment addComment(Long articleId, CommentRequest request) {
        Article article = articleService.getArticleById(articleId);
        Comment comment = new Comment();
        comment.setContent(request.getContent());
        comment.setArticle(article);
        return commentRepository.save(comment);
    }

    public List<Comment> getCommentsByArticleId(Long articleId) {
        return commentRepository.findByArticleId(articleId);
    }
}
