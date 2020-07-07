package com.company;

public class AccessDeniedException extends Exception
{
    @Override
    public void printStackTrace() {
        System.err.println(Language.getLocalizedText("AccessDenied"));
    }
}
