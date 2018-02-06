package com.supinfo.collections;

import java.util.Comparator;

public class StringComparator implements Comparator<String>
{
    @Override
    public int compare(String str0, String str1)
    {
        return str0.compareTo(str1);
    }
}