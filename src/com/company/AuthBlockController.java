package com.company;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;

public class AuthBlockController implements Initializable {
    boolean isEverythingCorrect = false;
    static String login;
    static String password;
    private Stage dialogStage;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
    @FXML
    private Button submitButton;

    @FXML
    private Button submitReg;
    @FXML
    private Button submitAuth;

    @FXML
    private PasswordField passwordField;

    @FXML
    private TextField loginField;

    @FXML
    private Label labelLogin, labelPassword;
    @FXML public void callAuth(){
        System.out.println("Authorization");
        dialogStage.close();
        //Main.callReadingCommands("aut");
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AutField.fxml"));
            Parent base = loader.load();
            Stage authStage = new Stage();
            authStage.setScene(new Scene(base));
            authStage.show();
        }catch (IOException e){     }

    }
    @FXML public void callReg(){
        System.out.println("Registration");
        dialogStage.close();
        //Main.callReadingCommands("reg");
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("RegField.fxml"));
            Parent base = loader.load();
            Stage regStage = new Stage();
            regStage.setScene(new Scene(base));
            regStage.show();
        }catch (IOException e){     }
    }
    @FXML public void submitAut(){
        login = loginField.getText();
        password = passwordField.getText();
        HashMap<String, String> users = Validator.GetUsers();
        if (users.containsKey(login)){
            if (users.get(login).equals(SHA256.getHash(password))){
                Main.callReadingCommands("aut");
                //dialogStage.close();
                try {
                    Stage stage = (Stage) submitAuth.getScene().getWindow();
                    stage.close();
                     Main.showMainWindow();
                } catch (Exception e){
                    System.out.println("BIG OOF");
                    e.printStackTrace();
                }

            }
            else {
                passwordField.setStyle("-fx-text-inner-color: red;");
            }
        }
        else {
            loginField.setStyle("-fx-text-inner-color: red;");
        }
        /*if (User.checkLoginGUI(login) && !users.containsKey(login)){
            isEverythingCorrect = true;
        }
        else{
            passwordField.setStyle("-fx-text-inner-color: red;");
            isEverythingCorrect = false;
        }
        if (!User.checkPasswordGUI(password)) {
            loginField.setStyle("-fx-text-inner-color: red;");
            isEverythingCorrect = false;
        }
        if (isEverythingCorrect){
            Main.callReadingCommands("aut");
        }*/
    }

    @FXML public void submitReg(){
        login = loginField.getText();
        password = passwordField.getText();
        HashMap<String, String> users = Validator.GetUsers();
        if (User.checkLoginGUI(login) && !users.containsKey(login)){
            isEverythingCorrect = true;
        }
        else{
            loginField.setStyle("-fx-text-inner-color: red;");
            isEverythingCorrect = false;
        }
        if (!User.checkPasswordGUI(password)) {
            passwordField.setStyle("-fx-text-inner-color: red;");
            isEverythingCorrect = false;
        }
        if (isEverythingCorrect){
            Stage stage = (Stage) submitReg.getScene().getWindow();
            stage.close();
            Main.callReadingCommands("reg");
            //dialogStage.close();
            try {
              //  Main.showMainWindow();
            } catch (Exception e){
                System.out.println("BIG OOF");
                e.printStackTrace();
            }
        }
    }

//====================================  не FXML методы


    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    public static String getLogin(){
        return login;
    }
    public static String getPassword(){
        return password;
    }
}
