package com.example.sh.morningtext.javaText;

public class MyException extends Exception{

    String message;
    int id;
    public MyException(String message,int id){
        this.message = message;
        this.id = id;
    }

}
