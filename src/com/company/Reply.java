package com.company;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;

class Reply implements Serializable{
    private static final long serialVersionUID = 8L;
    ArrayList<String> output;
    Reply(ArrayList<String> output){
        this.output = output;
    }
    String stringOutput;
    LinkedHashMap<String, Movie> movies;
    HashMap<String,String > users;

    Reply (String stringOutput, LinkedHashMap<String, Movie> movies, HashMap<String,String> users){
        this.stringOutput=stringOutput;
        this.movies = movies;
        this.users = users;
    }
    public String getStringOutput() {
        return this.stringOutput;
    }
    public LinkedHashMap<String, Movie> getMovies(){return this.movies;}
    public HashMap<String,String > getUsers(){return this.users;}

    @Override
    public String toString() {
        String ret = "";
        for (String str : output){
            ret += str + "\n";
        }
        return ret;
    }
}