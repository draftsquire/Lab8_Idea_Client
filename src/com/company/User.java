package com.company;

import java.io.Serializable;
import java.util.Scanner;
import java.util.regex.Pattern;

public class User implements Serializable {
    private static final long serialVersionUID = 41L;
    public String username;
    public String password;

    public User(String username, String password, boolean isHashed){

        if(isHashed){
            this.username=username;
            this.password=password;
        }else {
            this.username=username;
            this.password=SHA256.getHash(password);
        }

    }

    public static String checkUsername(String username){

        Pattern p = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
        boolean usernameCheck = p.matcher(username).find();
        Scanner scanner = new Scanner(System.in);
        while (username.length()<2 || username.length()>10 || usernameCheck==true){
            System.out.println("Имя пользователя должно быть больше 2 и меньше 10 символов в длину"+"\n"
                    +"и не содержать никаких символов кроме букв латинского алфавита и цифр!"+"\n"
                    +"Повторите ввод имени пользователя: ");
            username = scanner.nextLine();
            usernameCheck = p.matcher(username).find();
        }
        return username;
    }

    public static String checkPassword(String password){

        Pattern p = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
        boolean passwordCheck = p.matcher(password).find();
        Scanner scanner = new Scanner(System.in);
        while (password.length()<5 || password.length()>10 || passwordCheck==true){
            System.out.println("Пароль быть больше 5 и меньше 10 символов в длину"+"\n"
                    +"и не содержать никаких символов кроме букв латинского алфавита и цифр!"+"\n"
                    +"Повторите ввод пароля: ");
            password = scanner.nextLine();
            passwordCheck = p.matcher(password).find();
        }
        return password;
    }
}
