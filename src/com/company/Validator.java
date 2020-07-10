package com.company;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import org.w3c.dom.ls.LSOutput;

import javax.crypto.spec.PSource;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.*;

class Validator implements ActionListener {
    static private Scanner scanner = new Scanner(System.in);
    //static HashSet<String> names = new HashSet<>();
    static HashMap<String,String > users = new HashMap<String,String >();
    static boolean isAboutToSetAMovie = false;
    static String LastName;
    static Movie currentMovie;
    static String currentArgument;
    static int IntArg(String intArg){
        try{
            return Integer.parseInt(intArg);
        }
        catch (NumberFormatException e){
            System.out.print("Аргумент " + intArg + " не был распознан. Введите его ещё раз: ");
            return IntArg(scanner.nextLine());
        }
    }
    static Long LongArg(String longArg){
        try{
            return Long.parseLong(longArg);
        }
        catch (NumberFormatException e){
            System.out.print("Аргумент " + longArg + " не был распознан. Введите его ещё раз: ");
            return LongArg(scanner.nextLine());
        }
    }
    /*static void SetNames (){
        names.clear();
        names.addAll(Main.movieList.keySet());
    }*/

    static void SetUsers (HashMap<String,String > usersList){
        if (usersList != null) {
            for (Map.Entry<String, String> user : usersList.entrySet()
            ) {
                users.put(user.getKey(), user.getValue());
            }
        }
    }
    static HashMap<String,String > GetUsers (){
        return users;
    }
    static String chooseAUTHOREG (String arg){
        try {
            if (arg.toLowerCase().equals("aut")) {

                return "aut";
            }
            if (arg.toLowerCase().equals("reg")) {

                return "reg";
            } else {
                System.out.println("Вы можете выбрать только варианты 'aut' и 'reg'!");
                return Validator.chooseAUTHOREG(scanner.nextLine());
            }
        }catch (Exception e){
            System.out.println("EXCEPTION");
            System.out.println("Вы можете выбрать только варианты 'aut' и 'reg'!");
            return Validator.chooseAUTHOREG(scanner.nextLine());
        }

    }

    //Авторизация
    static User AUTHORIZATION(){
        /*System.out.println("Авторизация");
        System.out.println("Введите имя пользователя.");

        //login
        String authorizedUsername;
        do {
            authorizedUsername = scanner.nextLine();
            if(!users.containsKey(authorizedUsername)) {System.out.println("Пользователя с таким именем нет в базе!");}
        }while (!users.containsKey(authorizedUsername));
        //password
        System.out.println("Введите пароль.");
        String authorizedPassword = null;
        do {
            authorizedPassword = scanner.nextLine();
            if(!users.get(authorizedUsername).equals(SHA256.getHash(authorizedPassword)) ) {System.out.println("Неверный пароль! Повторите ввод:");}
        }while (!users.get(authorizedUsername).equals(SHA256.getHash(authorizedPassword)));*/
        User authorizedUser = new User(AutFieldController.getLogin(),AutFieldController.getPassword(), false);
        System.out.println("Вы успешно авторизовались как "+ authorizedUser.username);
        return authorizedUser;
}


    //Регистрация
    static User REGISTRATION(){
        /*System.out.println("Регистрация");
        System.out.println("Введите имя пользователя."+"\n"
                +"Имя пользователя должно состоять из 3-10 латинских букв и цифр от 0 до 9."+"\n"
                +"Имя пользователя не должно содержать специальных символов.");

        //login
        String newUsername = null;
        do {
            newUsername = User.checkUsername(scanner.nextLine());
            if(users.containsKey(newUsername)) {
                System.out.println("Пользователь с таким именем уже есть в базе!");}
        }while (users.containsKey(newUsername));
        //password
        System.out.println("Введите пароль."+"\n"
                +"Пароль должен состоять из 5-10 латинских букв и цифр от 0 до 9."+"\n"
                +"Пароль не должен содержать специальных символов.");
        String newPassword = User.checkPassword(scanner.nextLine());*/
        User createdUser = new User(RegFieldController.getLogin(), RegFieldController.getPassword(),false);
        users.put(createdUser.username, createdUser.password);
        System.out.println("Вы успешно зарегистрировались как "+ createdUser.username);
        return createdUser;
        }


    static String StringArg(String stringArg, boolean toValidate){
        LastName = stringArg;
        if(!toValidate){
            return stringArg;
        }
        else{
            if(!Main.movieList.keySet().contains(stringArg)){
                return stringArg;
            }
            else {
                System.out.println("Имя " + stringArg + " уже занято. Введите другое: ");
                return StringArg(scanner.nextLine(), toValidate);
            }
        }
    }


    //For FXML
    static boolean checkName(String name){
        try{
            if (Main.movieList.keySet().contains(name)){return false;}
            else {return true;}
        }catch (Exception e){
            return false;
        }
            }
    static boolean checkCoordinateX(String coordinateX){
        try{
            Integer coordinate = Integer.parseInt(coordinateX);
            return true;
        }catch (Exception e){
            return false;
        }
    }
    static boolean checkCoordinateY(String coordinateY){
        try{
            Double coordinate = Double.parseDouble(coordinateY);
            return true;
        }catch (Exception e){
            return false;
        }
    }
    static boolean checkOscarsCount(String oscarsCount){
        try{
            Long count = Long.parseLong(oscarsCount);
            if (count>0) {
                return true;
            }else {return false;}
        }catch (Exception e){
            return false;
        }
    }
    static boolean checkGoldenPalmCount(String goldenPalmCount){
        try{
            Integer count = Integer.parseInt(goldenPalmCount);
            if (count>0) {
                System.out.println("right");
                return true;
            }else {
                System.out.println("wrong");
                return false;}
        }catch (Exception e){
            return false;
        }
    }
    static boolean checkScreenwriterName(String name){
        try{
            String screenwriterName = name;
            return true;
        }catch (Exception e){
            return false;
        }
    }
    static boolean checkScreenwriterId(String passportID){
        try{
            if(passportID.length() >= 9 && passportID.length() <= 26){
                return true;

            }else {return false;}

        }catch (Exception e){
            return false;
        }
    }

    static void setCurrentMovie(Movie movie){
        currentMovie = movie;
    }
    static void setCurrentArgument(String argument) {currentArgument=argument;}

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}

