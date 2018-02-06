package com.supinfo.reportwriter;

import java.util.ArrayList;

public class Main
{
    public static void main(String[] args)
    {
        ArrayList<Contract> workers = new ArrayList<>();
        workers.add(new Student("Bruce", "Lee", "Shaolin School"));
        workers.add(new Employee("Gates" , "Bill", 1000, 20));
        workers.add(new SubContractor("Barak", "Obama", 59));
        workers.add(new Student("Rizzo", "John", "BlackBelt University"));
        workers.add(new Volounteer("John", "Doe"));
        
        ReportWriter rwriter = new ReportWriter(workers);
        String report = rwriter.generateReport(true);
        System.out.println(report);
    }
}