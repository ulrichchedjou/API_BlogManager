package com.apiblogManager.Blog_Manager.repositories;

import com.apiblogManager.Blog_Manager.models.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {

}
