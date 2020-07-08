package com.company;


import java.io.Serializable;

/**
 * Класс Person (Тип поля screenwriter класса Movie)
 */
public class Person implements Serializable {
    private static final long serialVersionUID = 6L;
    private String name; //Поле не может быть null, Строка не может быть пустой
    private String passportID; //Длина строки не должна быть больше 26, Длина строки должна быть не меньше 9, Поле может быть null
    private Color eyeColor; //Поле не может быть null
    private Color hairColor; //Поле может быть null
    public Person(String person){
        String person_divided[] = person.split(";");
        this.name=person_divided[0];
        this.passportID=person_divided[1];
        this.eyeColor=Color.valueOf(person_divided[2]);
        if (person_divided[3]!=null){
            this.hairColor = Color.valueOf(person_divided[3]);
        }
    }
    public Person(String name, String passportID, Color eyeColor, Color hairColor){

        this.name=name;
        this.passportID=passportID;
        this.eyeColor=eyeColor;
        if (hairColor!=null){
            this.hairColor = hairColor;
        }
    }
    public String stringToBeWritten(){
        return  this.name+";"+
                this.passportID+";"+
                this.eyeColor+";"+
                this.hairColor;


    }
    @Override
    public String toString(){
        return "Имя сценариста: "+this.name+"\n"+
                "id сценариста: "+this.passportID+"\n"+
                "Цвет глаз сценариста: "+this.eyeColor+"\n"+
                "Цвет волос сценариста: "+this.hairColor;
    }

}



