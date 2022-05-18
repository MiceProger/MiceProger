package com.michael.MyVocabulary.excepion;

public class PasswordIsIncorrectException extends RuntimeException{

    public static final String ErrorMessage = "Password is incorrect" ;

    public PasswordIsIncorrectException(){
        super(ErrorMessage);
    }
}
