package com.supinfo.philosophers;

public class Philosopher extends Thread
{
    public Philosopher(String name)
    {
        super(name);
    }

    @Override
    public void run()
    {
        while(!isInterrupted())
        {
            System.out.println(getName() + " is thinking");
            try
            {
                Thread.sleep((long)(Math.random() * 10000));
            }
            catch(InterruptedException e)
            {
                System.out.println(getName() + " died while thinking");
                return;
            }
            System.out.println(getName() + " is eating");
            try
            {
                Thread.sleep((long)(Math.random() * 10000));
            }
            catch(InterruptedException e)
            {
                System.out.println(getName() + " died while eating");
                return;
            }
        }
    }

}
