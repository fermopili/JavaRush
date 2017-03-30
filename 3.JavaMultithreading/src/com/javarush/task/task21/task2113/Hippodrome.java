package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 30.03.2017.
 */
public class Hippodrome
{
    static Hippodrome game;
    public Hippodrome()
        {    }
    public Hippodrome(List<Horse> horses)
        {
        this.horses = horses;
        }

    public List<Horse> getHorses()
        {
        return horses;
        }

    private static List<Horse> horses = new ArrayList<> ( );


    static public void main(String[] args) throws InterruptedException
        {
        game = new Hippodrome ( );
        game.horses.add (new Horse ("HORSE1", 3, 0));
        game.horses.add (new Horse ("HORSE2", 3, 0));
        game.horses.add (new Horse ("HORSE3", 3, 0));
        try
            {
                game.run ( );
            }
        catch (InterruptedException e)
            {
                e.printStackTrace ( );
            }
         game.printWinner ( );
        }

    public void run() throws InterruptedException
        {
        for (int i = 1; i <= 100; i++)
            {
                move ( );
                print ( );
                Thread.sleep (200);
            }
        }

    public void move()
        {
        for (Horse horse : horses)
            {
                horse.move ( );
            }
        }

    public void print()
        {
        for (Horse horse : horses)
            {
                horse.print ( );
            }
        for (int i = 0; i < 10; i++) System.out.println ( );
        }

    public Horse getWinner()
        {
        double d = 0;
        Horse  h = null;
        for (Horse horse : horses)
            {
                if (horse.getDistance ( ) > d)
                    h = horse;
            }
        return h;
        }

    public void printWinner()
        {
        System.out.println ("Winner is " +getWinner ().getName ()+"!");
        }
}
