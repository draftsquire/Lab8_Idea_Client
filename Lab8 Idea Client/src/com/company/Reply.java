package com.company;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

class Reply implements Serializable{
    private static final long serialVersionUID = 8L;
    ArrayList<String> output;
    Reply(ArrayList<String> output){
        this.output = output;
    }
    String stringOutput;
    HashSet<String> keys;
    HashMap<String,String > users;

    Reply (String stringOutput, HashSet<String> keys, HashMap<String,String> users){
        this.stringOutput=stringOutput;
        this.keys = keys;
        this.users = users;
    }
    public String getStringOutput() {
        return this.stringOutput;
    }
    public HashSet<String> getKeys(){return this.keys;}
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