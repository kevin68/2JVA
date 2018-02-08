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
        //Initialisation des fichiers
        File image = new File("bitmap.bmp");
        File result = new File("bitmap_new.bmp");
        //Nouveau buffer
        byte[] buffer = new byte[90000];
        //Variable pour stocker la longueur lue
        int length = 0;
        //Nos input/output streams
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try
        {
            //Instanciation du FileInputStream avec le fichier que l'on souhaite lire
            fis = new FileInputStream(image);
            //On lit le fichier (dans ce cas dans sa totalité) et on retourne la longueur
            length = fis.read(buffer);

            //On modifie tout les bytes après le header de 138 bytes
            for(int i = 138; i < length; i++)
            {
                buffer[i] = (byte)((buffer[i] + 150) / 2);
            }
            
            //On supprime le fichier de la nouvelle image s'il existe
            if(result.exists())
            {
                result.delete();
            }
            //On créer un nouveau fichier
            result.createNewFile();
            //Instanciation du FileOutputStream avec le fichier dans lequel on souhaite écrire
            fos = new FileOutputStream(result);
            //On écrit avec la longueur récupérée plus haut
            fos.write(buffer, 0, length);
            //On force l'écriture et on vide le buffer
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
            //Fermeture des Streams
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
