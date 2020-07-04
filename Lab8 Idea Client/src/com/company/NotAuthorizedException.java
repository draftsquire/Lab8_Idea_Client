package com.company;

public class NotAuthorizedException extends Exception {
    @Override
    public void printStackTrace() {
        System.err.println("Недоступно для неавторизованных пользователей!");
    }
}
