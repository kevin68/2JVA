package com.supinfo.binaryconverter.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerLauncher
{
    public static void main(String[] args)
    {
        try(ServerSocket serversock = new ServerSocket(12345, 10))
        {
            System.out.println("Serveur démarré");
            while(true)
            {
                Socket socket = serversock.accept();
                Thread t = new Thread(new BinaryConverterService(socket));
                t.start();
            }
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}