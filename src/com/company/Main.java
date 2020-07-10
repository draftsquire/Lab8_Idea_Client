package com.company;

import java.io.*;
import java.net.*;
import java.util.LinkedHashMap;
import java.util.ResourceBundle;


import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;


public class Main extends Application {
    private Stage primaryStage;
    static UpdatedClientSession session = new UpdatedClientSession();
    static Reply currentReply;
    static LinkedHashMap<String, Movie> movieList;
    static Parent base;
    static MainSceneController mainSceneController;
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //ResourceBundle bundle = ResourceBundle.getBundle("Messages", Locale.US);
        //System.out.println("Message in "+Locale.US +": "+bundle.getString("message"));

        SocketAddress a = new InetSocketAddress(InetAddress.getByName("localhost"), 4445);
        DatagramSocket s = new DatagramSocket();
        byte[] b = Converter.convertToBytes(new Query("get_names"));
        DatagramPacket out = new DatagramPacket(b, b.length, a);
        s.send(out);
        byte[] recieved = new byte[8192];
        DatagramPacket in = new DatagramPacket(recieved, recieved.length);
        s.receive(in);
        Reply reply = (Reply) Converter.convertFromBytes(recieved);
        //Validator.SetNames(reply.getKeys());
        Validator.SetUsers(reply.getUsers());

        Application.launch();

    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        this.primaryStage = primaryStage;
        primaryStage.setTitle("Lab8_Client");
       // InputStream iconStream = getClass().getResourceAsStream("GX.jpg");
        //Image image = new Image(iconStream);
       // primaryStage.getIcons().add(image);
        showAuthWindow(true);





        //Media sound = new Media(new File("Work.mp3").toURI().toString());
       // MediaPlayer mediaPlayer = new MediaPlayer(sound);
        //mediaPlayer.play();

    }
    public static void showAuthWindow(boolean isEntering) throws IOException {
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("AuthBlock.fxml"));
        loader.setResources(ResourceBundle.getBundle("AuthBlockBundle"));
        Parent base = loader.load();
        AuthBlockController enterUserController = loader.getController();
        Stage dialogStage = new Stage();
        AuthBlockController.setIsEntering(isEntering);
        dialogStage.setScene(new Scene(base));
        dialogStage.setMinWidth(350);
        dialogStage.setMinHeight(250);
        dialogStage.setMaxWidth(350);
        dialogStage.setMaxHeight(250);
        dialogStage.setTitle("Authorization");
        enterUserController.setDialogStage(dialogStage);
        dialogStage.showAndWait();


    }
    public static void showMainWindow() throws IOException{

        Stage mainStage = new Stage();
        mainStage.setScene(new Scene(base));
        mainStage.setTitle("ClientApp");
        mainStage.showAndWait();

    }
    public static void setupMainWindow() throws IOException {
        FXMLLoader mainLoader = new FXMLLoader(Main.class.getResource("MainScene.fxml"));

         base = mainLoader.load();
         mainSceneController = mainLoader.getController();
    }
    public static void callReadingCommands(String commandIncoming){
       try {

           Query query = session.ReadingCommands(commandIncoming);
           SocketAddress a = new InetSocketAddress(InetAddress.getByName("localhost"), 4445);
           DatagramSocket s = new DatagramSocket();
           if (query.getCommand().equals("exit")) {
               System.exit(666);
           }
           byte[] b = Converter.convertToBytes(query);
           DatagramPacket out = new DatagramPacket(b, b.length, a);
           s.send(out);
           byte[] recieved = new byte[8192];
           DatagramPacket in = new DatagramPacket(recieved, recieved.length);
           s.receive(in);
           Reply reply = (Reply) Converter.convertFromBytes(recieved);
           //Validator.SetNames(reply.getKeys());
           Validator.SetUsers(reply.getUsers());
           //System.out.println("Reply:\n " + reply.getStringOutput());
           currentReply= reply;
           movieList = reply.getMovies();
           MainSceneController.setMovieList(movieList);

       } catch (IOException e){
           e.printStackTrace();
       } catch (ClassNotFoundException j){
           j.printStackTrace();
       }
    }

    public static void showMovieSetWindow() throws IOException {
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("MovieSetScene.fxml"));
        Parent base = loader.load();
        MovieSetSceneController movieSetSceneController = loader.getController();
        Stage dialogStage = new Stage();
        dialogStage.setScene(new Scene(base));
        dialogStage.setTitle("MovieCreation");
        dialogStage.showAndWait();
    }
    public static void showKeySetWindow() throws IOException {
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("KeySetScene.fxml"));
        Parent base = loader.load();
        KeySetSceneController keySetSceneController = loader.getController();
        Stage dialogStage = new Stage();
        dialogStage.setScene(new Scene(base));
        dialogStage.setTitle("MovieCreation");
        dialogStage.showAndWait();
    }
    public static void showNumberSetWindow() throws IOException{
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("NumberSetScene.fxml"));
        Parent base = loader.load();
        NumberSetSceneController numberSetSceneController = loader.getController();
        Stage dialogStage = new Stage();
        dialogStage.setScene(new Scene(base));
        dialogStage.setTitle("NumberSet");
        dialogStage.showAndWait();

    }
    public static Reply  getCurrentReply(){
        return currentReply;
    }

    }
