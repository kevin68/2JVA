package com.supinfo.example.threads;

public class MyThread extends Thread
{
    public MyThread(String name)
    {
        super(name);
    }
    
    @Override
    public void run()
    {
        for(int i = 0 ; i < 30; i++)
        {
            System.out.println(getName() + " " + i);
            
            try
            {
                Thread.sleep((long)(100 + Math.random()*1000));
            }
            catch(InterruptedException e)
            {
                System.out.println(getName() + " Interrupted at " + i);
                return;
            }
        }
    }
}