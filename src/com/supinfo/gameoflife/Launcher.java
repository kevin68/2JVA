package com.supinfo.gameoflife;

import java.util.Scanner;

public class Launcher
{
    public static void main(String[] args)
    {
        // Nouvelle instance du Scanner pour lire ce qui est écrit dans la console
        Scanner scanner = new Scanner(System.in);
        // Initialisation des variables à 0
        int columns = 0, rows = 0;
        // Boucle tant que l'utilisateur n'entre pas de nombre
        while(true)
        {
            System.out.println("Nombre de colonnes:");
            // On récupère la prochaine ligne
            String line = scanner.nextLine();
            try
            {
                // On essaie de la convertire en nombre
                columns = Integer.parseInt(line);
                // Si cela fonctionne on sort de la boucle
                break;
            }
            catch(NumberFormatException ex)
            {
                // Si ce n'est pas un nombre on écrit le message et on reprend la boucle
                System.out.println("Ce n'est pas un nombre!");
            }
        }

        while(true)
        {
            System.out.println("Nombre de lignes:");
            // On récupère la prochaine ligne
            String line = scanner.nextLine();
            try
            {
                // On essaie de la convertire en nombre
                rows = Integer.parseInt(line);
                // Si cela fonctionne on sort de la boucle
                break;
            }
            catch(NumberFormatException ex)
            {
                // Si ce n'est pas un nombre on écrit le message et on reprend la boucle
                System.out.println("Ce n'est pas un nombre!");
            }
        }
        
        //Nous n'avons plus besoin du Scanner
        scanner.close();

        //Nouvelle instance de World avec les paramètres donnés
        World w = new World(columns, rows);
        
        //On affiche la première génération
        System.out.println(w);
        
        for(int i = 0; i < 1000; i++)
        // for(;;)
        // while(true)
        {
            //On passe à la prochaine génération
            w.newGeneration();
            //On affiche le monde
            System.out.println(w);
            try
            {
                //On attend 3 secondes
                Thread.sleep(3000);
            }
            catch(InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }
}