package com.supinfo.example.threads;

public class Launch
{
    public static void main(String[] args)
    {
        MyThread t1 = new MyThread("Thread 1");
        MyThread t2 = new MyThread("Thread 2");
        MyThread t3 = new MyThread("Thread 3");
        Thread t4 = new Thread(new MyRunnable(), "Runable 1");
        
        try
        {
            Thread.sleep((long)(Math.random() * 1000));
        }
        catch(InterruptedException e2)
        {
            e2.printStackTrace();
        }
        
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        
        try
        {
            Thread.sleep(1000);
        }
        catch(InterruptedException e1)
        {
            e1.printStackTrace();
        }
        t4.interrupt();
        
        try
        {
            Thread.sleep(2000);
        }
        catch(InterruptedException e)
        {
            e.printStackTrace();
        }
        t2.interrupt();
    }
}
