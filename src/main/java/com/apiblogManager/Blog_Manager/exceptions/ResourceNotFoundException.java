package com.apiblogManager.Blog_Manager.exceptions;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String articleNotFound) {
        super("Article not found !" + articleNotFound);
    }
}
