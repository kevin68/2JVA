package com.supinfo.philosophers;

public class Launch
{
    public static void main(String[] args)
    {
        Philosopher sartre = new Philosopher("Sartre");
        Philosopher descartes = new Philosopher("Descartes");
        Philosopher platon = new Philosopher("Platon");
        Philosopher aristote = new Philosopher("Aristote");
        Philosopher epictete = new Philosopher("Epictète");

        sartre.start();
        descartes.start();
        platon.start();
        aristote.start();
        epictete.start();
    }
}
