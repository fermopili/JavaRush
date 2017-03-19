package com.javarush.task.task07.task0724;

/* 
Семейная перепись
*/

public class Solution {
    public static void main(String[] args) {
        Human d1=new Human("d1",true,55);
        Human d2=new Human("d2",true,55);
        Human b1=new Human("b1",false,55);
        Human b2=new Human("b2",false,55);
        Human f=new Human("father",true,34,d1,b1);
        Human m=new Human("mother",true,30,d2,b2);
        Human c1=new Human("son",true,11,f,m);
        Human c2=new Human("son",true,10,f,m);
        Human c3=new Human("dougther",false,3,f,m);


        System.out.println( d1.toString());
        System.out.println( d2.toString());
        System.out.println( b1.toString());
        System.out.println( b1.toString());
        System.out.println( b2.toString());
        System.out.println( f.toString());
        System.out.println( m.toString());
        System.out.println( c1.toString());
        System.out.println( c2.toString());
        System.out.println( c3.toString());

    }

    public static class Human {
        public String name;
        public boolean sex;
        public int age;
        Human father;
        Human mother;
        Human(String name, boolean sex, int age)
        {
            this.name =name;
            this.sex =sex;
            this.age=age;
            this.father=null;
            this.mother=null;
        }
        public Human(String name,boolean sex,int age, Human father,Human mother)
        {
            this.name =name;
            this.sex =sex;
            this.age=age;
            this.father=father;
            this.mother=mother;
        }
        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null)
                text += ", отец: " + this.father.name;

            if (this.mother != null)
                text += ", мать: " + this.mother.name;

            return text;
        }
    }
}






















