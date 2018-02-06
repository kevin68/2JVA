package com.supinfo.arraysorter;

import java.util.Random;

public class Sorter
{
    static int[] bubbleSort(int[] array)
    {
        int[] result = array.clone();
        for(int i = result.length-1; i >= 0; i--)
        {
             for(int j = 0; j <= i-1; j++)
             {
                 if(result[j+1] < result[j])
                 {
                     int temp = result[j];
                     result[j] = result[j+1];
                     result[j+1] = temp;
                 }
             }
        }
        return result;
    }
    
    static int[] selectionSort(int[] array)
    {
        int[] result = array.clone();
        for(int i = 0; i < result.length; i++)
        {
            int min = i;
            for(int j = i+1; j < result.length; j++)
            {
                if(result[j] < result[min])
                {
                    min = j;
                }
            }
            if(i != min)
            {
                int temp = result[i];
                result[i] = result[min];
                result[min] = temp;
            }
        }
        return result;
    }
    
    static int[] insertionSort(int[] array)
    {
        int[] result = array.clone();
        for(int i = 1; i < result.length; i++)
        {
            int x = result[i];
            int j = i;
            while(j > 0 && result[j-1] > x)
            {
                result[j] = result[j-1];
                j = j-1;
            }
            result[j] = x;
        }
        return result;
    }
    
    static void displayArray(int[] array)
    {
        for(int i : array)
        {
            System.out.print(i + " ");
        }
        System.out.println();
    }
    
    public static void main(String[] args)
    {
        int[] values = new int[10];
        for(int i = 0; i < values.length; i++)
        {
            values[i] = (int)(Math.random()*100);
        }
        
        System.out.println("Unsorted:");
        displayArray(values);
        
        System.out.println("Bubble sort:");
        displayArray(bubbleSort(values));
        
        System.out.println("Selection sort:");
        displayArray(selectionSort(values));
        
        System.out.println("Insertion sort:");
        displayArray(insertionSort(values));
    }
}
