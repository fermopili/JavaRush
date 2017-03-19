package com.javarush.task.task12.task1218;

/* 
Fly, Move, Eat для классов Dog, Car, Duck, Airplane
*/

public class Solution
{
    public static void main(String[] args)
        {

        }

    public interface Fly
    {
        public void fly();
    }

    public interface Move
    {
        public void move();
    }

    public interface Eat
    {
        public void eat();
    }

    public class Dog implements Eat, Move
    {
        public void move()
            {
            }

        public void eat()
            {
            }

    }

    public class Duck implements Eat, Move, Fly
    {
        public void move()
            {
            }

        public void eat()
            {
            }

        public void fly()
            {
            }

    }

    public class Car implements Move
    {
        public void move()
            {
            }

    }

    public class Airplane implements Move, Fly

    {  public void move()
        {
        }

        public void fly()
            {
            }
    }
}
