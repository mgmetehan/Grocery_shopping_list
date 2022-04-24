package com.Dona.Grocery_Shopping_list.exception;

public class productAlreadyExistsException extends RuntimeException {
    public productAlreadyExistsException(String msg) {
        super(msg);
    }
}
