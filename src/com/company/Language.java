package com.company;

import java.util.Locale;
import java.util.ResourceBundle;

public class Language {
    public static Locale ChosenLocale;

    public static void setChosenLocale(Locale chosenLocale) {
        ChosenLocale = chosenLocale;
    }
    public static String getLocalizedText(String prop){
        ResourceBundle bundle = ResourceBundle.getBundle("ClientBundle", ChosenLocale);
        return bundle.getString(prop);
    }
}
