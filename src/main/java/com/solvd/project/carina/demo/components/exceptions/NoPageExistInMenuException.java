package com.solvd.project.carina.demo.components.exceptions;

public class NoPageExistInMenuException extends RuntimeException {

    public NoPageExistInMenuException(String message) {
        super(message);
    }
}
