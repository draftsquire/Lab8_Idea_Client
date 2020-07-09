package com.company;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class PersonProperties {
    private StringProperty name; //Поле не может быть null, Строка не может быть пустой
    private StringProperty passportID; //Длина строки не должна быть больше 26, Длина строки должна быть не меньше 9, Поле может быть null
    private ObjectProperty<Color> eyeColor; //Поле не может быть null
    private ObjectProperty<Color> hairColor; //Поле может быть null

    PersonProperties(Person person){
        name = new SimpleStringProperty(person.getName());
        passportID = new SimpleStringProperty(person.getPassportID());
        eyeColor = new SimpleObjectProperty<>(person.getEyeColor());
        hairColor = new SimpleObjectProperty<>(person.getHairColor());
    }

    public PersonProperties(String person){
        String person_divided[] = person.split(";");
        this.name=new SimpleStringProperty(person_divided[0]);
        this.passportID=new SimpleStringProperty(person_divided[1]);
        this.eyeColor=new SimpleObjectProperty<>(Color.valueOf(person_divided[2]));
        if (person_divided[3]!=null){
            this.hairColor =new SimpleObjectProperty<>(Color.valueOf(person_divided[3]));
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
    PersonProperties(String name, String passportID, Color eyeColor, Color hairColor){
        this.name = new SimpleStringProperty(name);
        this.passportID = new SimpleStringProperty(passportID);
        this.eyeColor= new SimpleObjectProperty<>(eyeColor);
        this.hairColor = new SimpleObjectProperty<>(hairColor);
    }

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public String getPassportID() {
        return passportID.get();
    }

    public StringProperty passportIDProperty() {
        return passportID;
    }

    public Color getEyeColor() {
        return eyeColor.get();
    }

    public ObjectProperty<Color> eyeColorProperty() {
        return eyeColor;
    }

    public Color getHairColor() {
        return hairColor.get();
    }

    public ObjectProperty<Color> hairColorProperty() {
        return hairColor;
    }
}
