package com.company;


import java.io.Serializable;

public enum MovieGenre implements Serializable {  //enum №1
    ACTION("Экшн"),
    DRAMA("Драмма"),
    THRILLER("Триллер"),
    HORROR("Хоррор"),
    SCIENCE_FICTION("Научная фантастика");
    String genreName;
    MovieGenre(String name){
        genreName = name;
    }
    @Override
    public String toString() {
        return genreName;
    }

    private static final long serialVersionUID = 4L;
}