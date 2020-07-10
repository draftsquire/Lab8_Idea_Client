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
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;

public class AuthBlockController implements Initializable {


    private Stage dialogStage;
    static boolean isEntering;
    private ResourceBundle currentLanguageBundle;

    @Override
    //ClientSessionBundle
    public void initialize(URL location, ResourceBundle resources) {
            currentLanguageBundle=resources;
            invitationText.setText(FormattedString( currentLanguageBundle.getString("Auth")));
            autButton.setText(FormattedString( currentLanguageBundle.getString("Authorization")));
            regButton.setText(FormattedString( currentLanguageBundle.getString("Registration")));



    }


    @FXML
    private Button autButton;
    @FXML
    private Button regButton;
    @FXML
    private Text invitationText;




    public static void setIsEntering(boolean bool){
        isEntering = bool;
    }
    public static boolean getIsEntering(){
        return isEntering;
    }

    @FXML public void callAuth(){
        System.out.println("Authorization");
        dialogStage.close();
        //Main.callReadingCommands("aut");


        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AutField.fxml"));
            loader.setResources(currentLanguageBundle);
            Parent base = loader.load();
            Stage authStage = new Stage();
            authStage.setScene(new Scene(base));
            authStage.show();
            authStage.setTitle("Aut");
        }catch (IOException e){
            e.printStackTrace();
        }

    }
    @FXML public void callReg(){
        System.out.println("Registration");
        dialogStage.close();
        //Main.callReadingCommands("reg");
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("RegField.fxml"));
            loader.setResources(currentLanguageBundle);
            Parent base = loader.load();
            Stage regStage = new Stage();
            regStage.setScene(new Scene(base));
            regStage.setTitle("Reg");
            regStage.show();
        }catch (IOException e){     }
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




//====================================  не FXML методы


    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    String FormattedString(String str){
        try {
            return new String(str.getBytes("ISO-8859-1"), "UTF-8");
        }
        catch (UnsupportedEncodingException e){
            return "hemlo";
        }
    }

}
