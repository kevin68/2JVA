package com.supinfo.jfxdemo;

import com.supinfo.jfxdemo.controller.MainController;
import com.supinfo.jva.supplay.Constants;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainFxml extends Application
{
    public static void main(String[] args)
    {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        MainController controller = new MainController();

        FXMLLoader loader = new FXMLLoader(Main.class.getResource("view/MainView.fxml"));
        loader.setController(controller);
        Scene scene = new Scene(loader.load());
        scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

        primaryStage.setScene(scene);
        primaryStage.setTitle("FXML Demo");
        primaryStage.show();
    }
}
