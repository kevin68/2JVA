package com.supinfo.example;

public class Tiger extends CatLike implements Wild
{
    @Override
    public String chose()
    {
        return "Bonjour";
    }

    @Override
    public void shout()
    {
        System.out.println(chose());
    }

    @Override
    void chose2()
    {

    }
}