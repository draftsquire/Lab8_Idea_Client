package com.company;


import java.io.Serializable;

public enum Color implements Serializable { //enum №3
    GREEN("Зелёный"),
    BLACK("Чёрный"),
    BLUE("Голубой"),
    YELLOW("Жёлтый"),
    ORANGE("Оранжевый"),
    WHITE("Белый"),
    BROWN("Коричневый");
    String colorName;
    Color (String name){
        colorName = name;
    }
    @Override
    public String toString() {
        return colorName;
    }

    private static final long serialVersionUID = 7L;
}

