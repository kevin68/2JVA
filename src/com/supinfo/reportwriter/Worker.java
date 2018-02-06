package com.supinfo.reportwriter;

public abstract class Worker
{
    protected String firstname;
    protected String lastname;
    
    public abstract String displayInfos();
    
    public String fullname()
    {
        return lastname + firstname;
    }
}
