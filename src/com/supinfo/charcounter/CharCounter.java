package com.supinfo.charcounter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;

public class CharCounter
{
    public static void main(String[] args)
    {
        // Nouvelle Map avec des caratères en clé et un entier en valeur
        HashMap<Character, Integer> counter = new HashMap<>();

        FileReader reader = null;
        try
        {
            // Instanciation du FileReader avec le fichier
            reader = new FileReader(new File("D:\\Supinfo\\SCT\\2JVA\\Resources\\Sequence 1\\texte.txt"));
            // Variable pour la valeur du prochain caractère
            int val;
            // Tant que la lecture du prochain caractère ne retourne pas -1 (fin du fichier)
            while((val = reader.read()) != -1)
            {
                if(counter.containsKey((char)val))
                {
                    // On incrémente si on a déjà rencontrer ce caractère
                    counter.put((char)val, counter.get((char)val) + 1);
                }
                else
                {
                    // On ajoute un entrée à 1 sinon
                    counter.put((char)val, 1);
                }
            }

            // On affiche les valeurs de la Map
            for(Entry<Character, Integer> kv : counter.entrySet())
            {
                System.out.println(kv.getKey() + " (unicode " + unicode(kv.getKey()) + "): " + kv.getValue());
            }

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
            // On ferme le reader
            if(reader != null)
            {
                try
                {
                    reader.close();
                }
                catch(IOException e)
                {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * Donne le code unicode du caractère passé en paramètre
     */
    private static String unicode(char c)
    {
        return "\\u" + Integer.toHexString(c | 0x10000).substring(1);
    }
}
