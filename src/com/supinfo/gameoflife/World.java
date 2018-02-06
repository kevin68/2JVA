package com.supinfo.gameoflife;

public class World
{
    private Cell[][] world;
    private int generation;
    private int nbColumns, nbRows;

    public World(int nbColumns, int nbRows)
    {
        this.nbColumns = nbColumns;
        this.nbRows = nbRows;
        this.world = new Cell[nbRows][nbColumns];
        for(int i = 0; i < nbRows; i++)
        {
            for(int j = 0; j < nbColumns; j++)
            {
                // this.world[i][j] = Math.random() > 0.5 ? new AliveCell() : new DeadCell();
                // La ligne du dessus est équivalante aux lignes du dessous
                if(Math.random() > 0.5)
                {
                    this.world[i][j] = new AliveCell();
                }
                else
                {
                    this.world[i][j] = new DeadCell();
                }
            }
        }
    }

    public World(Cell[][] cells)
    {
        this.nbRows = cells.length;
        if(this.nbRows != 0)
        {
            this.nbColumns = cells[0].length;
        }
        this.world = cells;
    }

    public void newGeneration()
    {
        generation++;
        for(int i = 0; i < this.nbRows; i++)
        {
            for(int j = 0; j < this.nbColumns; j++)
            {
                int nbNeighbours = 0;
                for(int k = -1; k < 2; k++)
                {
                    for(int l = -1; l < 2; l++)
                    {
                        if(i + k > 0 && i + k < this.nbRows - 1)
                        {
                            if(j + l > 0 && j + l < this.nbColumns - 1)
                            {
                                if(!(i + k == 0 && j + l == 0))
                                {
                                    if(this.world[i + k][j + l].isAlive())
                                    {
                                        nbNeighbours++;
                                    }
                                }
                            }
                        }
                    }
                }
                /*
                 * if(i > 0)
                 * {
                 * if(this.world[i-1][j].isAlive())
                 * {
                 * nbNeighbours++;
                 * }
                 * if(j > 0)
                 * {
                 * if(this.world[i-1][j-1].isAlive())
                 * {
                 * nbNeighbours++;
                 * }
                 * }
                 * if(j < this.nbColumns-1)
                 * {
                 * if(this.world[i-1][j+1].isAlive())
                 * {
                 * nbNeighbours++;
                 * }
                 * }
                 * }
                 * if(i < this.nbRows-1)
                 * {
                 * if(this.world[i+1][j].isAlive())
                 * {
                 * nbNeighbours++;
                 * }
                 * if(j > 0)
                 * {
                 * if(this.world[i+1][j-1].isAlive())
                 * {
                 * nbNeighbours++;
                 * }
                 * }
                 * if(j < this.nbColumns-1)
                 * {
                 * if(this.world[i+1][j+1].isAlive())
                 * {
                 * nbNeighbours++;
                 * }
                 * }
                 * }
                 * if(j > 0)
                 * {
                 * if(this.world[i][j-1].isAlive())
                 * {
                 * nbNeighbours++;
                 * }
                 * }
                 * if(j < this.nbColumns-1)
                 * {
                 * if(this.world[i][j+1].isAlive())
                 * {
                 * nbNeighbours++;
                 * }
                 * }
                 */
                this.world[i][j] = this.world[i][j].newGeneration(nbNeighbours);
            }
        }
    }

    @Override
    public String toString()
    {
        String result = "Generation: " + generation + "\n";
        for(int i = 0; i < this.nbRows; i++)
        {
            for(int j = 0; j < this.nbColumns; j++)
            {
                result += this.world[i][j].getAsString() + " ";
            }
            result += "\n";
        }

        return result;
    }
}
