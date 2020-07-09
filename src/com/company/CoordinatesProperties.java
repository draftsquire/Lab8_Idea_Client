package com.company;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class CoordinatesProperties {
    private IntegerProperty x; //Поле не может быть null
    private DoubleProperty y;
    public IntegerProperty get_x(){return this.x;}
    public DoubleProperty get_y(){return this.y;}

    /*public Coordinates(String coordinates){
        String coordinates_divided[] = coordinates.split("; ");
        this.x=Integer.parseInt(coordinates_divided[0]);
        this.y=Double.parseDouble(coordinates_divided[1]);
    }*/
    public CoordinatesProperties(Coordinates coordinates) {
        this.x = new SimpleIntegerProperty(coordinates.get_x());
        this.y = new SimpleDoubleProperty(coordinates.get_y());
    }
    public Coordinates getCoordinates(){
        return new Coordinates(x.get(), y.get());
    }
    public String showCoordinates(){
        return "Coordinates: x="+this.x+" y="+this.y ;
    }
    public String stringToBeWritten(){
        return this.x+"','"+this.y;
    }
}
