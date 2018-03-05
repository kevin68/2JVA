package com.supinfo.jar;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JOptionPane;

public class JWSDemo
{
    public static void main(String[] args)
    {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE d MMMM y k:m:s");
        JOptionPane.showMessageDialog(null, LocalDateTime.now().format(formatter));
    }
}
