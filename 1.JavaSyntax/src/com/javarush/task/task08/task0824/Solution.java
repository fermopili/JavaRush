package com.javarush.task.task08.task0824;

/* 
Собираем семейство
*/

import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        //------------------------------------------
        ArrayList<Human> children=new ArrayList<>();
        Human c1=new Human("child1",true,5); children.add(c1);
        Human c2=new Human("child2",false,6);children.add(c2);
        Human c3=new Human("child3",true,7);children.add(c3);

        Human f= new Human("father",true,44,children);
        Human m= new Human("mother",false,43,children);
        ArrayList<Human> children2=new ArrayList<>();
        children2.add(f);
        Human d1= new Human("ded1",true,67,children2);
        Human b1= new Human("baba1",false,57,children2);
        ArrayList<Human> children3=new ArrayList<>();
        children3.add(m);
        Human d2= new Human("ded2",true,66,children3);
        Human b2= new Human("baba2",false,55,children3);
        ArrayList<Human> human=new ArrayList<>();
        human.add(d1);
        human.add(b1);
        human.add(d2);
        human.add(b2);
        human.add(f);
        human.add(m);
        human.add(c1);
        human.add(c2);
        human.add(c3);
        for(Human h: human)
           System.out.println(h.toString());
        //------------------------------------------
    }
    public static class Human {
        //напишите тут ваш код
//============================
        String name;
        boolean sex;
        int age;
        ArrayList<Human> children;
        public Human(String name, boolean sex, int age) {
            this.name=name;
            this.sex=sex;
            this.age=age;
            this.children=new ArrayList<>();
        }
        public Human(String name, boolean sex, int age, ArrayList<Human> children) {
            this.name=name;
            this.sex=sex;
            this.age=age;
            this.children=children;
        }
        //========================
        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0) {
                text += ", дети: " + this.children.get(0).name;

                for (int i = 1; i < childCount; i++) {
                    Human child = this.children.get(i);
                    text += ", " + child.name;
                }
            }
            return text;
        }
    }

}


