package com.company;

import java.io.File;
import java.io.Serializable;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.HashMap;

class Query implements Serializable{
    private static final long serialVersionUID = 1L;
    //Поля и их Getы
    String command;
    String getCommand(){
        return command;
    }
    Long LongArg;
    Long getLongArg(){
        return LongArg;
    }
    int IntArg;
    int getIntArg(){
        return IntArg;
    }
    String StringArg;
    String getStringArg() {return StringArg;}
    Movie MovieArg;
    Movie getMovie(){
        return this.MovieArg;
    }
    File file;
    File getFile(){return this.file;}
    //7th lab update
    User user;
    User getUser(){
        return this.user;
    }
    HashMap<String, String> usersList;
    HashMap<String, String> getUsersList(){
        return this.usersList;
    }



    //Конструкторы
    Query(String command){
        this.command = command;
    }
    Query(String command, Long LongArg){
        this.command = command;
        this.LongArg = LongArg;
    }
    Query(String command, int IntArg, /*7th lab update*/User currentUser){
        this.command = command;
        this.IntArg = IntArg;
        /*7th lab update*/ this.user = currentUser;
    }
    Query(String command, Movie MovieArg,  /*7th lab update*/User currentUser){
        this.command = command;
        this.MovieArg = MovieArg;
        /*7th lab update*/ this.user = currentUser;
    }
    Query(String command, int IntArg, Movie MovieArg, /*7th lab update*/ User currentUser){
        this.command = command;
        this.IntArg = IntArg;
        this.MovieArg = MovieArg;
        /*7th lab update*/ this.user = currentUser;
    }
    Query(String command,String StringArg, /*7th lab update*/ User currentUser){
        this.command = command;
        this.StringArg = StringArg;
        /*7th lab update*/ this.user = currentUser;
    }
    Query(String command,String StringArg, Movie MovieArg,  /*7th lab update*/User currentUser){
        this.command = command;
        this.StringArg = StringArg;
        this.MovieArg = MovieArg;
        /*7th lab update*/ this.user = currentUser;
    }
    //7th lab update
    Query(String command, HashMap<String,String> users){
        this.command = command;
        this.usersList = users;
    }
    Query(String command, File file){
        this.command = command;
        this.file = file;
    }
    Query(String command,User currentUser){
        this.command = command;
        this.user = currentUser;
    }




    @Override
    public String toString() {
        return "Query{" +
                "command='" + command + '\'' +
                ", LongArg=" + LongArg +
                ", IntArg=" + IntArg +
                ", MovieArg=" + MovieArg +
                ", StringArg=" + StringArg +
                '}';
    }
}
