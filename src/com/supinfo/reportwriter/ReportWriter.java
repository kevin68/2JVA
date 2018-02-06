package com.supinfo.reportwriter;

import java.util.List;

public class ReportWriter
{
    private List<Worker> workers;
    
    public ReportWriter(List<Worker> workers)
    {
        this.workers = workers;
    }
    
    public String generateReport()
    {
        String result = "GreatReport\n-------------------\n\n";
        int counter = 0;
        for(Worker w : this.workers)
        {
         
            if(counter % 3 == 0 && counter != 0)
            {
                result += "          page " + ((counter-(counter%3))/3) + "\n\n";
            }
            result += w.fullname() + "\n";
            result += w.displayInfos() + "\n\n";
            counter ++;
        }
        result += "          page " + ((counter-(counter%3))/3+1) + "\n\n";
        return result;
    }
}
