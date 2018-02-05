package com.supinfo.fizzbuzz;

public class FizzBuzz
{
    public static void main(String[] args)
    {
        for(int i = 1; i <= 100; i++)
        {
            if(i % 10 == 0)
            {
                System.out.println();
            }
            if(i % 3 == 0 && i % 5 == 0)
            {
                System.out.print("fizzbuzz");
            }
            else if(i % 3 == 0)
            {
                System.out.print("fizz");
            }
            else if(i % 5 == 0)
            {
                System.out.print("buzz");
            }
            else
            {
                System.out.print(i);
            }
            System.out.print(" ");
        }
    }
}