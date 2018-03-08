package com.supinfo.gameoflife;

import java.security.InvalidParameterException;

public class World
{
    private Cell[][] world, nextworld;
    private int generation;
    private int nbColumns, nbRows;

    public World(int nbColumns, int nbRows) throws InvalidParameterException
    {
        // Si les paramètres ne sont pas valides on lance une exception
        if(nbColumns < 1 || nbRows < 1)
        {
            throw new InvalidParameterException("Le nombre de colonnes et de lignes doivent êtres supérieur à 1");
        }
        // On attribue les valeurs locales aux attributs d'objet
        this.nbColumns = nbColumns;
        this.nbRows = nbRows;
        // On créer une nouvelle instance d'un tableau de Cell à deux dimensions
        this.world = new Cell[nbRows][nbColumns];
        this.nextworld = new Cell[nbRows][nbColumns];
        // On boucle sur toutes les cases du tableau
        for(int i = 0; i < nbRows; i++)
        {
            for(int j = 0; j < nbColumns; j++)
            {
                // On remplit le tableau aléatoirement

                // this.world[i][j] = Math.random() > 0.5 ? new AliveCell() : new DeadCell();
                // La ligne du dessus est équivalante aux lignes du dessous
                if(Math.random() > 0.8)
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
        // On attribue les valeurs locales aux attributs d'objet
        this.nbRows = cells.length;
        if(this.nbRows != 0)
        {
            this.nbColumns = cells[0].length;
        }
        this.world = cells;
        this.nextworld = cells;
    }

    public int getNumberOfCellAlive()
    {
        int cellsAlive = 0;
        for(int i = 0; i < nbRows; i++)
        {
            for(int j = 0; j < nbColumns; j++)
            {
                if(this.world[i][j].isAlive())
                {
                    cellsAlive ++ ;
                }

            }
        }
        return cellsAlive;
    }

    public Cell[][] getCells()
    {
        return world;
    }

    public void clear()
    {
        this.generation = 0;
        for(int i = 0; i < nbRows; i++)
        {
            for(int j = 0; j < nbColumns; j++)
            {
                this.world[i][j] = new DeadCell();
            }
        }
    }

    public int getGeneration()
    {
        return generation;
    }

    /**
     * Génère la prochaine génération
     */
    public void newGeneration()
    {
        // On incrémente la génération
        generation++;
        // On boucle sur toute les cases du tableau
        for(int i = 0; i < this.nbRows; i++)
        {
            for(int j = 0; j < this.nbColumns; j++)
            {
                int nbNeighbours = 0;
                // On boucle sur tout les voisins de la cellule
                /*
                 * for(int k = -1; k < 2; k++)
                 * {
                 * for(int l = -1; l < 2; l++)
                 * {
                 * // On vérifie que l'on ne sort pas du tableau (lignes)
                 * if(i + k > 0 && i + k < this.nbRows - 1)
                 * {
                 * // On vérifie que l'on ne sort pas du tableau (colonnes)
                 * if(j + l > 0 && j + l < this.nbColumns - 1)
                 * {
                 * // On vérifie que l'on est pas sur la cellule actuelle
                 * if(!(i + k == 0 && j + l == 0))
                 * {
                 * // Si le voisin est vivant
                 * if(this.world[i + k][j + l].isAlive())
                 * {
                 * // On incrémente le nombre de voisin
                 * nbNeighbours++;
                 * }
                 * }
                 * }
                 * }
                 * }
                 * }
                 */
                // Alternative avec vérification de chaque voisin

                if(i > 0)
                {
                    if(this.world[i - 1][j].isAlive())
                    {
                        nbNeighbours++;
                    }
                    if(j > 0)
                    {
                        if(this.world[i - 1][j - 1].isAlive())
                        {
                            nbNeighbours++;
                        }
                    }
                    if(j < this.nbColumns - 1)
                    {
                        if(this.world[i - 1][j + 1].isAlive())
                        {
                            nbNeighbours++;
                        }
                    }
                }
                if(i < this.nbRows - 1)
                {
                    if(this.world[i + 1][j].isAlive())
                    {
                        nbNeighbours++;
                    }
                    if(j > 0)
                    {
                        if(this.world[i + 1][j - 1].isAlive())
                        {
                            nbNeighbours++;
                        }
                    }
                    if(j < this.nbColumns - 1)
                    {
                        if(this.world[i + 1][j + 1].isAlive())
                        {
                            nbNeighbours++;
                        }
                    }
                }
                if(j > 0)
                {
                    if(this.world[i][j - 1].isAlive())
                    {
                        nbNeighbours++;
                    }
                }
                if(j < this.nbColumns - 1)
                {
                    if(this.world[i][j + 1].isAlive())
                    {
                        nbNeighbours++;
                    }
                }

                // On change la valeur de la case avec celle de la prochaine génération
                this.nextworld[i][j] = this.world[i][j].newGeneration(nbNeighbours);
            }
        }
        for(int i = 0; i < this.nbRows; i++)
        {
            for(int j = 0; j < this.nbColumns; j++)
            {
                this.world[i][j] = this.nextworld[i][j];
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
