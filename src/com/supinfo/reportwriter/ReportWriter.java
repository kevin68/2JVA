package com.supinfo.reportwriter;

import java.util.List;

public class ReportWriter
{
    private List<Contract> contracts;

    public ReportWriter(List<Contract> contracts)
    {
        this.contracts = contracts;
    }

    public String generateReport(boolean webVersion)
    {
        String result = "GreatReport\n-------------------\n\n";
        int counter = 0;
        for(Contract w : this.contracts)
        {

            if(counter % (webVersion ? 2 : 3) == 0 && counter != 0)
            {
                if(webVersion)
                {
                    result += "          Consume more, and you will so much more happy! \n\n";
                }
                else
                {
                    result += "          page " + ((counter - (counter % 3)) / 3) + "\n\n";
                }
            }
            result += w.stringValue() + "\n";
            counter++;
        }
        if(webVersion)
        {
            result += "          Consume more, and you will so much more happy! \n\n";
        }
        else
        {
            result += "          page " + ((counter - (counter % 3)) / 3 + 1) + "\n\n";
        }
        return result;
    }
}
