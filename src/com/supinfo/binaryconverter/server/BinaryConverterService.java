package com.supinfo.binaryconverter.server;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class BinaryConverterService implements Runnable
{
    private Socket sock;

    public BinaryConverterService(Socket sock)
    {
        this.sock = sock;
    }

    @Override
    public void run()
    {
        try
        {
            InputStream instream = this.sock.getInputStream();
            byte[] bytes = new byte[4096];
            instream.read(bytes);
            String strvalue = new String(bytes);
            try
            {
                int value = Integer.parseInt(strvalue.trim());
                String binarystr = Integer.toBinaryString(value);
                this.sock.getOutputStream().write(binarystr.getBytes());
            }
            catch(NumberFormatException ex)
            {
                this.sock.getOutputStream().write("Erreur".getBytes());
            }
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                this.sock.close();
            }
            catch(IOException e)
            {
                e.printStackTrace();
            }
        }
    }
}