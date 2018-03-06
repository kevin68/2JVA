package com.supinfo.jfxdemo;

import java.io.File;
import java.net.URI;
import java.util.Observable;

import javafx.animation.Interpolator;
import javafx.animation.ParallelTransition;
import javafx.animation.RotateTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.Transition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.chart.Axis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart.Data;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Main extends Application
{
    @Override
    public void start(Stage primaryStage)
    {
        try
        {
            BorderPane root = new BorderPane();
            Scene scene = new Scene(root, 400, 400);
            scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

            VBox box = new VBox(20);
            box.setAlignment(Pos.CENTER);

            TextField field = new TextField("Bonjour");

            Label text = new Label("Bonjour");
            text.textProperty().bind(field.textProperty());

            Button btn = new Button("Clic moi!");
            btn.getStyleClass().add("btntest");
            btn.setOnAction((event) -> {
                RotateTransition rt = new RotateTransition(Duration.millis(500), btn);
                rt.setFromAngle(0);
                rt.setToAngle(360);
                RotateTransition rt2 = new RotateTransition(Duration.millis(500), text);
                rt2.setFromAngle(360);
                rt2.setToAngle(0);
                ParallelTransition pt = new ParallelTransition(rt, rt2);
                TranslateTransition tt = new TranslateTransition(Duration.millis(200), btn);
                tt.setFromX(0);
                tt.setToX(200);
                SequentialTransition sq = new SequentialTransition(pt, tt);
                sq.play();
            });

            LineChart<Number, Number> chart = new LineChart<>(new NumberAxis(), new NumberAxis());
            Series<Number, Number> ser = new Series<>();
            ser.getData().add(new Data<Number, Number>(0, 10));
            ser.getData().add(new Data<Number, Number>(1, 5));
            ser.getData().add(new Data<Number, Number>(2, 3));
            ser.getData().add(new Data<Number, Number>(3, 0));
            chart.getData().add(ser);
            Series<Number, Number> ser2 = new Series<>();
            ser2.getData().add(new Data<Number, Number>(0, 15));
            ser2.getData().add(new Data<Number, Number>(1, 1));
            ser2.getData().add(new Data<Number, Number>(2, 6));
            ser2.getData().add(new Data<Number, Number>(3, 4));
            chart.getData().add(ser2);

            WebView web = new WebView();
            WebEngine engine = web.getEngine();
            engine.load("https://www.google.com");

            box.getChildren().addAll(field, text, btn, chart, web);

            root.setCenter(box);

            primaryStage.setTitle("JFX demo");
            primaryStage.setScene(scene);
            primaryStage.show();

            RotateTransition rt = new RotateTransition(Duration.seconds(30), web);
            rt.setCycleCount(Transition.INDEFINITE);
            rt.setInterpolator(Interpolator.LINEAR);
            rt.setFromAngle(0);
            rt.setToAngle(360);
            rt.play();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
