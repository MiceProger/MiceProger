package com.michael.MyVocabulary.excepion;

public class UserAlreadyExistException extends RuntimeException{

    public static final String ErrorMessage = "User with that name already exist" ;

    public UserAlreadyExistException(){
        super(ErrorMessage);
    }



}
