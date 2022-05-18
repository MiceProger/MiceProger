package com.michael.MyVocabulary.excepion;

public class UserDoesNotExistException extends RuntimeException{

    public static final String ErrorMessage = "User with that name does not exist" ;

    public UserDoesNotExistException(){
        super(ErrorMessage);
    }

    
}
