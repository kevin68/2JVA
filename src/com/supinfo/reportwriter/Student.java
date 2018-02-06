package com.supinfo.reportwriter;

public class Student extends Worker
{
    private String school;
    
    public Student(String firstname, String lastname, String school)
    {
        this.firstname = firstname;
        this.lastname = lastname;
        this.school = school;
    }

    @Override
    public String displayInfos()
    {
        return this.school;
    }
}
