package com.javarush.task.task33.task3309;

import javax.xml.bind.annotation.*;

/**
 * Created by Administrator on 12.05.2017.
 */

@XmlRootElement
public  class Cat
{   @XmlElement(name="name")
String name = "Murka";
    @XmlElement(name="age")
int age = 5;
    @XmlElement(name="weight")
int weight = 4;
}

/*
@XmlRootElement(name = "Emp")
@XmlType(propOrder = {"name", "age", "role", "gender"})
public class Cat
{

    private int id;

    private String gender;

    private int    age;
    private String name;
    private String role;
    private String password;

    @XmlTransient
    public String getPassword()
        {
        return password;
        }
    public void setPassword(String password)
        {
        this.password = password;
        }
    @XmlAttribute
    public int getId()
        {
        return id;
        }
    public void setId(int id)
        {
        this.id = id;
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

    @XmlElement(name = "gen")
    public String getGender()
        {
        return gender;
        }
    public void setGender(String gender)
        {
        this.gender = gender;
        }
    public String getRole()
        {
        return role;
        }
    public void setRole(String role)
        {
        this.role = role;
        }
    @Override
    public String toString()
        {
        return "ID = " + id + " NAME=" + name + " AGE=" + age + " GENDER=" + gender + " ROLE=" +
                role + " PASSWORD=" + password;
        }

}
*/