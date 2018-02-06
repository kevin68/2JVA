package com.supinfo.gameoflife;

public class AliveCell implements Cell
{
    boolean newBorn = true;
    
    @Override
    public Cell newGeneration(int nbNeighbours)
    {
        newBorn = false;
        if(nbNeighbours < 2 || nbNeighbours > 3)
        {
            return new DeadCell();
        }
        return this;
    }

    @Override
    public String getAsString()
    {
        return newBorn ? "0" : "+";
    }

    @Override
    public boolean isAlive()
    {
        return true;
    }
}