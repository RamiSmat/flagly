package com.flagly.api.project.exceptions;

public class ProjectNotFoundException extends RuntimeException{
    public ProjectNotFoundException(Long id){
        super("Could not find project with id: " + id);
    }
}
