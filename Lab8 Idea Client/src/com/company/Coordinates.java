package com.company;

import java.io.Serializable;

public class Coordinates implements Serializable {
    private static final long serialVersionUID = 3L;
    private Integer x; //Поле не может быть null
    private double y;
    public int get_x(){return this.x;}
    public double get_y(){return this.y;}

    public Coordinates(String coordinates){
        String coordinates_divided[] = coordinates.split("; ");
        this.x=Integer.parseInt(coordinates_divided[0]);
        this.y=Double.parseDouble(coordinates_divided[1]);
    }
    public String showCoordinates(){
        return "Coordinates: x="+this.x+" y="+this.y ;
    }
    public String stringToBeWritten(){
        return this.x+"','"+this.y;
    }
}