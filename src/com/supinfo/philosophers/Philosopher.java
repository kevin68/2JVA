package com.supinfo.philosophers;

public class Philosopher extends Thread
{
    private Fork leftFork, rightFork;
    
    public Philosopher(String name, Fork leftfork, Fork rightfork)
    {
        super(name);
        this.leftFork = leftfork;
        this.rightFork = rightfork;
    }

    @Override
    public void run()
    {
        while(!isInterrupted())
        {
            System.out.println(getName() + " is thinking");
            try
            {
                Thread.sleep((long)(Math.random() * 1000));
            }
            catch(InterruptedException e)
            {
                System.out.println(getName() + " died while thinking");
                return;
            }
            System.out.println(getName() + " is hungry");
            synchronized(leftFork)
            {
                synchronized(rightFork)
                {
                    System.out.println(getName() + " is eating");
                    try
                    {
                        Thread.sleep((long)(Math.random() * 1000));
                    }
                    catch(InterruptedException e)
                    {
                        System.out.println(getName() + " died while eating");
                        return;
                    }
                }
            }
        }
    }

}
