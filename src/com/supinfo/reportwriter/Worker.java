package com.supinfo.reportwriter;

public abstract class Worker
{
    protected String firstname;
    protected String lastname;

    public Worker(String firstname, String lastname)
    {
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public abstract String displayInfos();

    public String fullname()
    {
        return lastname + " " + firstname;
    }
}
