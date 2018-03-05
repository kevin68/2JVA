package com.supinfo.binaryconverter.client;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.Scanner;

public class CreateLauncher
{
    public static void main(String[] args)
    {
        System.out.println("Entrez un nombre");
        Scanner sc = new Scanner(System.in);
        String value = sc.nextLine();
        sc.close();
        try(Socket sock = new Socket("localhost", 12345))
        {
            sock.getOutputStream().write(value.getBytes());
            InputStream instream = sock.getInputStream();
            byte[] buffer = new byte[8192];
            instream.read(buffer);
            String strval = new String(buffer);
            System.out.println("Votre nombre en binaire: " + strval);
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}
