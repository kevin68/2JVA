package com.supinfo.example;

public class Test
{

    public static void main(String[] args)
    {
        try
        {
            System.out.println("hello");
            return;
        }
        finally 
        {
            System.out.println("world");
        }
    }

}
