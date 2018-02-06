package com.supinfo.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class Main
{
    public static void main(String[] args)
    {
        ArrayList<String> colors = new ArrayList<>();
        colors.add("Blue");
        colors.add("Green");
        colors.add("Yellow");
        colors.add("Red");
        colors.add("Pink");
        
        Iterator<String> iterator = colors.iterator();
        while(iterator.hasNext())
        {
            System.out.println(iterator.next());
        }
        
        colors.sort(new StringComparator());
        
        Collections.reverse(colors);
        System.out.println();
        for(String s: colors)
        {
            System.out.println(s);
        }
    }
}
