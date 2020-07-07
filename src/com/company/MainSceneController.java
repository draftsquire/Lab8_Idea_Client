package com.company;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;

import javax.swing.text.TableView;
import java.net.URL;
import java.util.ResourceBundle;

public class MainSceneController implements Initializable {
    @FXML
    TableView tableView;
    @FXML
    ChoiceBox commandsChoice;
    @FXML
    ChoiceBox languageChoice;

    @FXML
    public void executeCommand(){

    }
    @FXML
    public void changeLanguage(){

    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void callExit(ActionEvent actionEvent) {
        System.out.println("Command called: "+ "exit");
        Main.callReadingCommands("exit");

    }

    public void callPrintFieldDescendingOscarsCount(ActionEvent actionEvent) {
        System.out.println("Command called: "+ "print_field_descending_oscars_count");
        Main.callReadingCommands("print_field_descending_oscars_count");
    }

    public void callAuth(ActionEvent actionEvent) {
        System.out.println("Command called: "+ "auth");
        Main.callReadingCommands("auth");
    }

    public void callInfo(ActionEvent actionEvent) {
        System.out.println("Command called: "+ "info");
        Main.callReadingCommands("info");
    }

    public void callShow(ActionEvent actionEvent) {
        System.out.println("Command called: "+ "show");
        Main.callReadingCommands("show");
    }

    public void callInsert(ActionEvent actionEvent) {
        System.out.println("Command called: "+ "insert");
        Main.callReadingCommands("insert");
    }

    public void callRemoveKey(ActionEvent actionEvent) {
        System.out.println("Command called: "+ "");
        Main.callReadingCommands("remove_key");
    }

    public void callClear(ActionEvent actionEvent) {
        System.out.println("Command called: "+ "clear");
        Main.callReadingCommands("clear");
    }

    public void callExecuteScript(ActionEvent actionEvent) {
        System.out.println("Command called: "+ "execute_script");
        Main.callReadingCommands("execute_script");
    }

    public void callRemoveGreater(ActionEvent actionEvent) {
        System.out.println("Command called: "+ "remove_greater");
        Main.callReadingCommands("remove_greater");
    }

    public void callReplaceIfLower(ActionEvent actionEvent) {
        System.out.println("Command called: "+ "replace_if_lower");
        Main.callReadingCommands("replace_if_lower");
    }

    public void callRemoveGreaterKey(ActionEvent actionEvent) {
        System.out.println("Command called: "+ "remove_greater_key");
        Main.callReadingCommands("remove_greater_key");
    }

    public void callCountLessThanOscarsCount(ActionEvent actionEvent) {
        System.out.println("Command called: "+ "count_less_than_oscars_count");
        Main.callReadingCommands("count_less_than_oscars_count");
    }

    public void callPrintDescending(ActionEvent actionEvent) {
        System.out.println("Command called: "+ "print_descending");
        Main.callReadingCommands("print_descending");
    }
}
