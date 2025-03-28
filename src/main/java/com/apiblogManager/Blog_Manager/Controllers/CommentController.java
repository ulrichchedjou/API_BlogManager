package com.apiblogManager.Blog_Manager.Controllers;

import com.apiblogManager.Blog_Manager.DTOs.CommentRequest;
import com.apiblogManager.Blog_Manager.Services.CommentService;
import com.apiblogManager.Blog_Manager.models.Comment;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/articles/{articleId}/comments")
public class CommentController {
    private final CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping("/addComment")
    @Operation(summary = "Add a comment to an article")
    public ResponseEntity<Comment> addComment(@PathVariable Long articleId, @Valid @RequestBody CommentRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(commentService.addComment(articleId, request));
    }

    @GetMapping
    @Operation(summary = "Get comments by article ID")
    public ResponseEntity<List<Comment>> getCommentsByArticleId(@PathVariable Long articleId) {
        return ResponseEntity.ok(commentService.getCommentsByArticleId(articleId));
    }
}