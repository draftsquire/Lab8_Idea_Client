package com.company;


import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import java.net.URL;
import java.util.ResourceBundle;

public class AuthBlockController implements Initializable {
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
    @FXML public void callAuth(){
        System.out.println("Авторизация");
    }
    @FXML public void callReg(){
        System.out.println("Регистрация");
    }
}
