package com.supinfo.philosophers;

public class DiningTable
{
    Fork f1 = new Fork();
    Fork f2 = new Fork();
    Fork f3 = new Fork();
    Fork f4 = new Fork();
    Fork f5 = new Fork();
    
    Philosopher sartre = new Philosopher("Sartre", f1, f2);
    Philosopher descartes = new Philosopher("Descartes", f2, f3);
    Philosopher platon = new Philosopher("Platon", f3, f4);
    Philosopher aristote = new Philosopher("Aristote", f4, f5);
    Philosopher epictete = new Philosopher("Epictète", f1, f5);
    
    public DiningTable()
    {
        sartre.start();
        descartes.start();
        platon.start();
        aristote.start();
        epictete.start();
    }
}
