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

    public static Color getColor(String color){
        switch (color){
            case "Зелёный":
                return Color.GREEN;
            case "Чёрный":
                return  Color.BLACK;
            case "Голубой":
                return Color.BLUE;
            case "Жёлтый":
                return Color.YELLOW;
            case "Оранжевый":
                return Color.ORANGE;
            case "Белый":
                return Color.WHITE;
            case "Коричневый":
                return Color.BROWN;
            default:
                return Color.GREEN;
        }
    }

    private static final long serialVersionUID = 7L;
}

