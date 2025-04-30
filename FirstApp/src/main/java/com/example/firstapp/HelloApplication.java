package com.example.firstapp;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        StackPane pane = new StackPane();
        pane.getChildren().add(new Button("Ok"));
        Scene scene = new Scene(pane, 200, 50);
        stage.setTitle("Button in a pane");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}