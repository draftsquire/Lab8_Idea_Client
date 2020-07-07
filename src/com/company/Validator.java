package com.company;

import org.w3c.dom.ls.LSOutput;

import javax.crypto.spec.PSource;
import java.util.*;

class Validator {
    static private Scanner scanner = new Scanner(System.in);
    static HashSet<String> names = new HashSet<>();
    static HashMap<String,String > users = new HashMap<String,String >();
    static boolean isAboutToSetAMovie = false;
    static String LastName;
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
    static void SetNames (HashSet<String> _names){
        names.clear();
        names.addAll(_names);
    }
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
        System.out.println("Авторизация");
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
        }while (!users.get(authorizedUsername).equals(SHA256.getHash(authorizedPassword)));
        User authorizedUser = new User(authorizedUsername,authorizedPassword, false);
        System.out.println("Вы успешно авторизовались как "+ authorizedUser.username);
        return authorizedUser;
}


    //Регистрация
    static User REGISTRATION(){
        System.out.println("Регистрация");
        System.out.println("Введите имя пользователя."+"\n"
                +"Имя пользователя должно состоять из 3-10 латинских букв и цифр от 0 до 9."+"\n"
                +"Имя пользователя не должно содержать специальных символов.");


        //login
        String newUsername = null;
        do {
            newUsername = User.checkUsername(scanner.nextLine());
            if(users.containsKey(newUsername)) {System.out.println("Пользователь с таким именем уже есть в базе!");}
        }while (users.containsKey(newUsername));
        //password
        System.out.println("Введите пароль."+"\n"
                +"Пароль должен состоять из 5-10 латинских букв и цифр от 0 до 9."+"\n"
                +"Пароль не должен содержать специальных символов.");
        String newPassword = User.checkPassword(scanner.nextLine());
        User createdUser = new User(newUsername,newPassword,false);
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
            if(!names.contains(stringArg)){
                return stringArg;
            }
            else {
                System.out.println("Имя " + stringArg + " уже занято. Введите другое: ");
                return StringArg(scanner.nextLine(), toValidate);
            }
        }
    }
}

