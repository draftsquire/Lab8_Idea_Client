package com.company;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.DatagramSocket;
import java.net.SocketAddress;
import java.sql.ResultSet;
import java.util.Scanner;
import java.util.Stack;

class ClientSession {
    InputReader reader;
    private static Scanner scanner;
    //Stack<Scanner> readers = new Stack<>();
    //Scanner reader;
    private boolean authorised = false;
    private User sessionUser;
    String command;
    String argument;
    int space;

    ClientSession() {
        reader = new InputReader();
        scanner = new Scanner(System.in);
        //Greetings
        System.out.println("Добрый день и добро пожаловать в менеджер фильмов.");
    }
    void setSessionUser(User sessionUser){
        this.sessionUser = sessionUser;
        this.authorised = true;
    }

    Query ReadingCommands(String commandIncoming) {
        Query query = null;
        try {
            //if (reader.ConsoleInputCheck()) {
            //    //InputInvitation
             //   System.out.println("Введите вашу команду:");
           // }
            command = commandIncoming; //reader.read();
            space = command.indexOf(" ");
            if (space != -1) {
                argument = command.substring(space + 1);
                command = command.substring(0, space);
            }
            if (command.equals("exit")) {
                query = new Query(command);
                //Exit
                System.out.println("До свидания.");
                //System.exit(0);
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
                query = new Query(command, argument,sessionUser);
            } else if (command.equals("count_less_than_oscars_count")) {
                if (!authorised) {throw new NotAuthorizedException();}
                query = new Query(command, Validator.LongArg(argument));
            } else if (command.equals("insert") ||
                    command.equals("remove_greater")) {
                if (!authorised) {throw new NotAuthorizedException();}
                Validator.isAboutToSetAMovie = true;
                query = new Query(command, Validator.StringArg(argument, true), new MovieMaker().MovieFactory(reader),sessionUser);
            } else if (command.equals("replace_if_lower")) {
                if (!authorised) {throw new NotAuthorizedException();}
                Validator.isAboutToSetAMovie = true;
                query = new Query(command, Validator.StringArg(argument, false), new MovieMaker().MovieFactory(reader),sessionUser);
            } else if (command.equals("update")) {
                if (!authorised) {throw new NotAuthorizedException();}
                query = new Query(command, Validator.IntArg(argument), new MovieMaker().MovieFactory(reader),sessionUser);
            }
        /* if (command.equals("remove_greater")){
            query = new Query(command, Validator.StringArg(argument), new MovieMaker().MovieFactory(reader));
        }*/
            else if (command.equals("execute_script")) {
                if (!authorised) {throw new NotAuthorizedException();}
                try {
                    reader.push(new Scanner(new FileReader(argument)));
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                return ReadingCommands(command);
            } else if (command.equals("aut") || command.equals("reg")) {
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