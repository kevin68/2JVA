package com.supinfo.gameoflife;

import javafx.animation.AnimationTimer;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.ToggleButton;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class GuiLauncher extends Application
{
    @Override
    public void start(Stage primaryStage) throws Exception
    {
        Canvas canvas = new Canvas(1000, 900);

        Label lgeneration = new Label("Generation");
        ToggleButton enablebtn = new ToggleButton("Run");
        enablebtn.selectedProperty().addListener((event, ol, ne) -> {
            if(!enablebtn.isSelected())
            {
                enablebtn.setText("Run");
            }
            else
            {
                enablebtn.setText("Stop");
            }
        });

        Slider slider = new Slider(0, 1000, 100);
        slider.setBlockIncrement(10);

        Button btn = new Button("Clear");

        HBox box = new HBox(20, enablebtn, slider, btn);
        box.setAlignment(Pos.CENTER);
        box.setPadding(new Insets(0, 0, 20, 0));

        BorderPane root = new BorderPane();
        root.setCenter(canvas);
        root.setBottom(box);
        root.setTop(lgeneration);
        Scene scene = new Scene(root, 1000, 1000);

        primaryStage.setTitle("Game Of Life");
        primaryStage.setScene(scene);
        primaryStage.show();

        World w = new World(30, 30);

        int wi = (int)(canvas.getWidth() / w.getCells().length);
        int he = (int)(canvas.getHeight() / w.getCells()[0].length);
        GraphicsContext ctx = canvas.getGraphicsContext2D();

        drawWorld(w, ctx, wi, he, lgeneration);

        new AnimationTimer()
        {
            long previous;

            @Override
            public void handle(long now)
            {
                if(now - previous > slider.getValue() * 1000000 && enablebtn.isSelected())
                {
                    if(w.getNumberOfCellAlive() > 0)
                    {
                        previous = now;
                        w.newGeneration();
                        drawWorld(w, ctx, wi, he, lgeneration);
                    }
                    else
                    {
                        enablebtn.setSelected(false);
                    }

                }
            }
        }.start();

        canvas.setOnMouseClicked((event) ->
        {
            int x = (int)(event.getX() / wi);
            int y = (int)(event.getY() / he);
            w.getCells()[x][y] = event.getButton() == MouseButton.PRIMARY ? new AliveCell() : new DeadCell();
            drawWorld(w, ctx, wi, he, lgeneration);
        });

        btn.setOnAction((event) ->
        {
            w.clear();
            drawWorld(w, ctx, wi, he, lgeneration);
        });
    }

    private static void drawWorld(World world, GraphicsContext ctx, int width, int height, Label label)
    {
        label.setText("Generation " + world.getGeneration());
        ctx.clearRect(0, 0, width * world.getCells().length, height * world.getCells()[0].length);
        for(int row = 0; row < world.getCells().length; row++)
        {
            for(int col = 0; col < world.getCells()[0].length; col++)
            {
                if(world.getCells()[row][col].isAlive())
                {
                    ctx.setFill(Color.GREEN);
                }
                else
                {
                    ctx.setFill(Color.WHITE);
                }
                ctx.fillRect(row * width, col * height, width, height);
            }
        }
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
