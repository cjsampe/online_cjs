package com.online.online.exception;

public class ProductNotFoundException extends Exception {
    public ProductNotFoundException(String message){
        super(message);
    }


    /** Constructor vacio **/
    public ProductNotFoundException(){
        super();
    }


}
