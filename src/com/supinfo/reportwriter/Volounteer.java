package com.supinfo.reportwriter;

public class Volounteer extends Worker
{
    public Volounteer(String firstname, String lastname)
    {
        super(firstname, lastname);
    }
    
    @Override
    public String displayInfos()
    {
        return "Life is beautiful";
    }

}
