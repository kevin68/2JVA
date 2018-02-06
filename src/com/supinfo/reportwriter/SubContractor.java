package com.supinfo.reportwriter;

public class SubContractor extends Worker
{
    private int cost;
    
    public SubContractor(String firstname, String lastname, int cost)
    {
        super(firstname, lastname);
        this.cost = cost;
    }
    
    @Override
    public String displayInfos()
    {
        return "€" + this.cost + "/day";
    }
}
