package com.supinfo.jfxdemo.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class MainController
{
    @FXML
    private Button btn;

    @FXML
    public void btnclicked(ActionEvent event)
    {
        System.out.println("Clicked");
    }
}
