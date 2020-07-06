package com.company;

import java.io.*;
import java.net.*;
import java.sql.SQLOutput;
import java.util.Locale;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

//We're working on different branch now
public class Main extends Application {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //ResourceBundle bundle = ResourceBundle.getBundle("Messages", Locale.US);
        //System.out.println("Message in "+Locale.US +": "+bundle.getString("message"));
        ClientSession session = new ClientSession();
        SocketAddress a = new InetSocketAddress(InetAddress.getByName("localhost"), 4445);
        DatagramSocket s = new DatagramSocket();
        byte[] b = Converter.convertToBytes(new Query("get_names"));
        DatagramPacket out = new DatagramPacket(b, b.length, a);
        s.send(out);
        byte[] recieved = new byte[8192];
        DatagramPacket in = new DatagramPacket(recieved, recieved.length);
        s.receive(in);
        Reply reply = (Reply) Converter.convertFromBytes(recieved);
        Validator.SetNames(reply.getKeys());
        Validator.SetUsers(reply.getUsers());
        Application.launch();
        while (true) {
            Query query = session.ReadingCommands();
            if (query.getCommand().equals("exit")) {
                System.exit(666);
            }
            b = Converter.convertToBytes(query);
            out = new DatagramPacket(b, b.length, a);
            s.send(out);
            recieved = new byte[8192];
            in = new DatagramPacket(recieved, recieved.length);
            s.receive(in);
            reply = (Reply) Converter.convertFromBytes(recieved);
            Validator.SetNames(reply.getKeys());
            Validator.SetUsers(reply.getUsers());
            System.out.println("\n "+ reply.getStringOutput());
        }
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Менеджер фильмов");
        Group group = new Group();       // корневой узел
        Scene scene = new Scene(group);
        InputStream iconStream = getClass().getResourceAsStream("GX.jpg");
        Image image = new Image(iconStream);
        primaryStage.getIcons().add(image);
        Parent content = FXMLLoader.load(getClass().getResource("AuthBlock.fxml"));
        BorderPane root = new BorderPane();
        root.setCenter(content);
        group.getChildren().add(root);
        primaryStage.setScene(scene);
        primaryStage.show();
        Media sound = new Media(new File("Work.mp3").toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.play();

    }
}
