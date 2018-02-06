package com.supinfo.example;

import java.util.Scanner;

public class Test
{

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        System.out.println(str);
        try
        {
            int i = Integer.parseInt(str);
            System.out.println(i);
        }
        catch(Throwable e)
        {
            System.out.println("Ce n'est pas un nombre");
        }
        finally 
        {
            scanner.close();
        }
    }

}
