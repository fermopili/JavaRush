package com.javarush.task.task12.task1214;

/* 
Класс Cow от Animal
*/

public class Solution
{
    public static void main(String[] args)
        {

        }

    public static abstract class Animal
    {
        public abstract String getName();
    }

    public static class Cow extends Animal
    {
        private String name;

        public void setName(String name)
            {
            this.name = name;
            }

        public String getName()
            {
            return "name";
            }

        ;
    }

}
