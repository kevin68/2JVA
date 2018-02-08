package com.supinfo.jzipper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipCompresser
{
    public static void compress(File archive, File... files)
    {
        //Si l'archive existe déjà on la supprime
        if(archive.exists())
        {
            archive.delete();
        }
        
        //Définition des variables
        FileInputStream fis = null;
        ZipEntry ze = null;
        byte[] data = new byte[2048];
        
        try(FileOutputStream fos = new FileOutputStream(archive); ZipOutputStream zipos = new ZipOutputStream(fos))
        {
            //On boucle sur les fichiers
            for(File f : files)
            {
                try
                {
                    //On copie les donnés lues avec le FileInputStream dans le ZipOutputStream après avoir ajouter la ZipEntry
                    fis = new FileInputStream(f);
                    ze = new ZipEntry(f.getName());
                    zipos.putNextEntry(ze);
                    while(fis.read(data) != -1)
                    {
                        zipos.write(data);
                    }
                }
                catch(FileNotFoundException fnfe)
                {
                    System.out.println("File " + f.getAbsolutePath() + " does not exist");
                }
                catch(IOException ioe)
                {
                    System.out.println("Cannot read " + f.getAbsolutePath());
                    ioe.printStackTrace();
                }
                finally 
                {
                    //On oublis pas de close le FileInputStream car il sera redéfinis au prochain passage dans la boucle
                    fis.close();
                }
            }
            zipos.flush();
        }
        catch(IOException e)
        {
            System.out.println("Cannot write " + archive.getAbsolutePath());
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
        }
    }
}
