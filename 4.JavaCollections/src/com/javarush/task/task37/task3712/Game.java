package com.javarush.task.task37.task3712;

/**
 * Created by Administrator on 21.05.2017.
 */
public abstract class Game
{
    abstract public void prepareForTheGame();


    abstract public void playGame();

    abstract public void congratulateWinner();

    public void run()
        {
        prepareForTheGame ( );
        playGame ( );
        congratulateWinner ( );
        }

    ;

}
