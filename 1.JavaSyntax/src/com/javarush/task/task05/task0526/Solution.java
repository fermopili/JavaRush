package com.javarush.task.task05.task0526;

/* 
Мужчина и женщина
*/

public class Solution {
    public static void main(String[] args) {
        Man man1=new Man("man1",23,"addres1");
        Man man2=new Man("man2",23,"addres2");

        Woman woman1=new Woman("Woman1",23,"addres1");
        Woman woman2=new Woman("Woman2",23,"addres2");

        System.out.println(man1.name+"  "+man1.age+"  " + man1.address);
        System.out.println(man2.name+"  "+man2.age+"  " + man2.address);

        System.out.println(woman1.name+"  "+woman1.age+"  " + woman1.address);
        System.out.println(woman2.name+"  "+woman2.age+"  " + woman2.address);

    }
public static class Man{
    public String name;
    public int age;
    public String address;
        public Man(String name,int age,String address)
        {
            this.name=name;
            this.age=age;
            this.address=address;
        }
}
    public static class Woman{
        public String name;
        public int age;
        public String address;
        public Woman(String name,int age,String address)
        {
            this.name=name;
            this.age=age;
            this.address=address;
        }
    }
}
