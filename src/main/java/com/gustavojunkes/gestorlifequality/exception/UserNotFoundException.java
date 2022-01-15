package com.gustavojunkes.gestorlifequality.exception;


public class UserNotFoundException extends RuntimeException{

    public UserNotFoundException(String message){
        super(message);
    }

}
