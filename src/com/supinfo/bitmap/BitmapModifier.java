package com.supinfo.bitmap;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class BitmapModifier
{
    public static void main(String[] args)
    {
        File image = new File("bitmap.bmp");
        File result = new File("bitmap_new.bmp");
        byte[] buffer = new byte[90000];
        int length = 0;
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try
        {
            fis = new FileInputStream(image);
            length = fis.read(buffer);

            for(int i = 138; i < length; i++)
            {
                buffer[i] = (byte)((buffer[i] + 150) / 2);
            }

            if(result.exists())
            {
                result.delete();
            }
            result.createNewFile();
            fos = new FileOutputStream(result);
            fos.write(buffer, 0, length);
            fos.flush();
        }
        catch(FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            if(fis != null)
            {
                try
                {
                    fis.close();
                }
                catch(IOException e)
                {
                    e.printStackTrace();
                }
            }
            if(fos != null)
            {
                try
                {
                    fos.close();
                }
                catch(IOException e)
                {
                    e.printStackTrace();
                }
            }
        }
    }
}
