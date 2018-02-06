package com.supinfo.gameoflife;

public class Launcher
{
    public static void main(String[] args)
    {
        World w = new World(100, 100);

        System.out.println(w);
        for(int i = 0; i < 1000; i++)
        //for(;;)
        //while(true)
        {
            w.newGeneration();
            System.out.println(w);
            try
            {
                Thread.sleep(3000);
            }
            catch(InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }
}