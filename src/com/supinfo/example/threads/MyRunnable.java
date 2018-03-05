package com.supinfo.example.threads;

public class MyRunnable implements Runnable
{
    @Override
    public void run()
    {
        while(true)
        {
            System.out.println("Je suis un runnable");
            try
            {
                Thread.sleep(100);
            }
            catch(InterruptedException e)
            {
                System.out.println("nonnnnnnnn!");
                return;
            }
        }
    }
}