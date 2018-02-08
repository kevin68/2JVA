package com.supinfo.jzipper;

import java.io.File;

public class Launcher
{
    public static void main(String[] args)
    {
        boolean commandOk = false;
        switch(args.length)
        {
            case 0:
                break;
            case 1:
                //Affichage de l'aide
                if(args[0].equals("help"))
                {
                    commandOk = true;
                    System.out.println("Usage: jzipper [OPTION] [File...]");
                    System.out.println("Compress or decompress files");
                    System.out.println();
                    System.out.println("Options can be:");
                    System.out.println("        compress [ACHIVE NAME]      Compress files into the archive");
                    System.out.println("        decompress                  Decompress archive in current folder");
                }
                break;
            case 2:
                //Decompression
                if(args[0].equals("decompress"))
                {
                    commandOk = true;
                    ZipDecompresser.decompress(new File(args[1]));
                }
                break;
            default:
                //Compression
                if(args[0].equals("compress") && args.length >= 3)
                {
                    commandOk = true;
                    //On créer un tableau de File avec les paramètres (String)
                    File[] files = new File[args.length-2];
                    for(int i = 2 ; i < args.length; i++)
                    {
                        files[i-2] = new File(args[i]);
                    }
                    ZipCompresser.compress(new File(args[1]), files);
                }
                break;
        }
        
        if(!commandOk)
        {
            System.out.println("Commande invalide essayer 'help' pour voir l'aide");
            return;
        }
    }
}