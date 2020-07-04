package com.company;

public class AccessDeniedException extends Exception
{
    @Override
    public void printStackTrace() {
        System.err.println("У Вас нет прав для выполнения этой команды!");
    }
}
