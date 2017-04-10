package com.javarush.task.task29.task2909.human;

/**
 * Created by Administrator on 09.04.2017.
 */
public class Soldier extends Human
{
    public Soldier(String name, int age)//, int numberOfStudents)
        {
         super(name,age);
        }
    @Override
    public void live()
        {
        fight ( );
        }
    public void fight()
        {
        }
}
