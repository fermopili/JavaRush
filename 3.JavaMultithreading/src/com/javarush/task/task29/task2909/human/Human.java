package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Human implements Alive
{
    private        List<Human> children = new ArrayList<> ( );
    private static int         nextId   = 0;
    private   int    id;
    protected int    age;
    protected String name;
    protected Size   size;

    public class Size
    {
        public int height;
        public int weight;
    }
    private BloodGroup bloodGroup;

    public void setBloodGroup(BloodGroup bloodGroup)
        {
       this. bloodGroup=bloodGroup;

        }
    public BloodGroup getBloodGroup()
        {
        return bloodGroup;
        }

    public Human(String name, int age)//, int numberOfStudents)
    {
    this.name = name;
    this.age = age;
    }

    public int getAge()
        {
        return age;
        }

    public void setAge(int age)
        {
        this.age = age;
        }

    public String getName()
        {
        return name;
        }

    public void setName(String name)
        {
        this.name = name;
        }

    public int getId()
        {
        return id;
        }

    //  public void setId(int id)        {        this.id = id;        }

    public void printSize()
        {
        System.out.println ("Рост: " + size.height + " Вес: " + size.weight);
        }

    public List<Human> getChildren()
        {
        return Collections.unmodifiableList (children);
        }

    public void addChild(Human child)
        {
        children.add (child);
        }

    public void removeChild(Human child)
        {
        for (int i = 0; i < children.size ( ); i++)
            if (children.get (i).equals (child))
                {
                    children.remove (i);
                    break;
                }
        }

    @Override
    public void live()
        {
        }

    public void printData()
        {
        System.out.println (getPosition ( ) + ": " + name);
        }

    public String getPosition()
        {
        return "Человек";
        }

}