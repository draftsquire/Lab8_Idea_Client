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

    public static MovieGenre getMovieGenre(String genre){
        switch (genre){
            case "Экшн":
                return MovieGenre.ACTION;
            case "Драмма":;
                return MovieGenre.DRAMA;
            case "Триллер":
                return MovieGenre.THRILLER;
            case "Хоррор":
                return MovieGenre.HORROR;
            case "Научная фантастика":
                return MovieGenre.SCIENCE_FICTION;
            default:
                return MovieGenre.ACTION;
        }
    }
    private static final long serialVersionUID = 4L;
}