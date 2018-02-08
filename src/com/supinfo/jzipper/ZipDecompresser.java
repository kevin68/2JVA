package com.supinfo.jzipper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class ZipDecompresser
{
    public static void decompress(File file)
    {
        //Déclaration des variables
        FileOutputStream fos = null;
        ZipEntry ze = null;
        byte[] buffer = new byte[2048];

        try(FileInputStream fis = new FileInputStream(file); ZipInputStream zis = new ZipInputStream(fis);)
        {
            //On boucle sur les ZipEntry (fichiers compressés dans l'archive)
            while((ze = zis.getNextEntry()) != null)
            {
                try
                {
                    //Pour chaque ZipEntry on écrit les donnés dans un nouveau FileOutputStream
                    fos = new FileOutputStream("./" + ze.getName());
                    while(zis.read(buffer) != -1)
                    {
                        fos.write(buffer);
                    }
                    fos.flush();
                }
                catch(IOException ioex)
                {
                    System.out.println(ioex);
                    System.out.println("Cannot write file " + ze.getName());
                }
                finally 
                {
                    //On oublis pas de close le FileOutputStream comme il sera redéfini au prochain passage de boucle
                    fos.close();
                }
            }

        }
        catch(FileNotFoundException fnfe)
        {
            System.out.println("Achive not found");
        }
        catch(IOException ioe)
        {
            ioe.printStackTrace();
            System.out.println("Cannot read archive");
        }
        finally
        {
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
