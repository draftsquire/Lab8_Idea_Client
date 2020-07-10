package com.company;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.DatagramSocket;
import java.net.SocketAddress;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.Stack;

class UpdatedClientSession {
    InputReader reader;
    private static Scanner scanner;
    //Stack<Scanner> readers = new Stack<>();
    //Scanner reader;
    private boolean authorised = false;
    private User sessionUser;
    String command;
    String argument;

    UpdatedClientSession() {
    }
    void setSessionUser(User sessionUser){
        this.sessionUser = sessionUser;
        this.authorised = true;
    }
    User getSessionUser(){
        return this.sessionUser;
    }
    Query ReadingCommands(String commandIncoming) {
        Query query = null;
        try {
            command = commandIncoming; //reader.read();

            if (command.equals("exit")) {
                query = new Query(command);
                System.out.println("До свидания.");
            } else if (command.equals("help")){
                query = new Query(command);
            }
            else if(command.equals("info") ||
                    command.equals("show") ||
                    command.equals("clear") ||
                    command.equals("print_descending") ||
                    command.equals("print_field_descending_oscars_count")) {
                if (!authorised) {throw new NotAuthorizedException();}
                query = new Query(command, sessionUser);
            } else if (command.equals("remove_key") ||
                    command.equals("remove_greater_key")) {
                if (!authorised) {throw new NotAuthorizedException();}
                try {
                    Main.showKeySetWindow(ResourceBundle.getBundle("KeySetSceneBundle"));
                    query = new Query(command, Validator.currentArgument, sessionUser);
                } catch (IOException e){
                    e.printStackTrace();
                    query = new Query("get_names");
                }
            } else if (command.equals("count_less_than_oscars_count")) {
                if (!authorised) {throw new NotAuthorizedException();}
                try {
                    Main.showNumberSetWindow();
                    query = new Query(command,Long.parseLong(Validator.currentArgument));
                } catch(Exception e){
                    e.printStackTrace();
                    query = new Query("get_names");
                }
            } else if (command.equals("insert") ||
                    command.equals("remove_greater")) {
                if (!authorised) {throw new NotAuthorizedException();}
                try {
                    Main.showMovieSetWindow(ResourceBundle.getBundle("MovieSetSceneBundle"));
                    query = new Query(command, Validator.currentMovie.getName(),Validator.currentMovie, sessionUser);
                } catch (IOException e){
                    query = new Query("get_names");
                }
            } else if (command.equals("replace_if_lower")) {
                if (!authorised) {throw new NotAuthorizedException();}
                try {
                    Main.showMovieSetWindow(ResourceBundle.getBundle("MovieSetSceneBundle"));
                    query = new Query(command, Validator.currentMovie.getName(),Validator.currentMovie, sessionUser);
                } catch (IOException e){
                    query = new Query("get_names");
                }
            } else if (command.equals("update")) {
                if (!authorised) {throw new NotAuthorizedException();}
                try {
                    Main.showMovieSetWindow(ResourceBundle.getBundle("MovieSetSceneBundle"));
                    query = new Query(command, Validator.currentMovie.getName(), Validator.currentMovie,sessionUser);
                } catch (Exception e){
                    e.printStackTrace();
                    query = new Query("get_names");
                }
            }

            else if (command.equals("aut") || command.equals("reg")) {
                if (command.equals("aut")) {
                    setSessionUser(Validator.AUTHORIZATION());

                }
                if (command.equals("reg")) {
                    setSessionUser(Validator.REGISTRATION());

                }
                System.out.println("Current usersList :"+Validator.GetUsers().toString());
                query = new Query("update_userslist", Validator.GetUsers());
                //запрос должен содержать обновлённую коллекцию юзеров: query = new Query();
            } else {
                //UnknownCommand
                System.out.println("Команда " + command + " не была распознана.");
                return ReadingCommands(command);
            }
        } catch (NotAuthorizedException e){
            e.printStackTrace();
            query = new Query("get_names");
        }
        return query;
    }
}