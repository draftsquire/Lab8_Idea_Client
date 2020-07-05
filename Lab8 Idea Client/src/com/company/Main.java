package com.company;

import java.io.*;
import java.net.*;
import java.sql.SQLOutput;
import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;


public class Main extends Application {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ClientSession session = new ClientSession();
        Application.launch();
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
        primaryStage.setTitle("JavaFX application");
        InputStream iconStream = getClass().getResourceAsStream("GX.jpg");
        Image image = new Image(iconStream);
        primaryStage.getIcons().add(image);
        primaryStage.setWidth(500);
        primaryStage.setHeight(400);
        primaryStage.show();
    }
}
