package com.javarush.task.task05.task0510;

/* 
Кошкоинициация
*/

public class Cat {


    String name;
    int weight;
    int age;
    String color;
    String address;
    public void initialize(String name) {
        this.name = name;
        this.weight=5;
        this.age=3;
        this.color="RED";

    }
    public void initialize(String name, int weight,int age) {
        this.name = name;
        this.weight=weight;
        this.age=age;
        this.color="RED";

    }
    public void initialize(String name,int age) {
        this.name = name;
        this.weight=5;
        this.age=age;
        this.color="RED";

    }
    public void initialize(int weight,String color) {
        this.name = null;
        this.weight=weight;
        this.age=3;
        this.color=color;

    }
    public void initialize(int weight,String color,String address) {

        this.weight=weight;
        this.age=3;
        this.color=color;
        this.address=address;
    }

    public static void main(String[] args) {

    }
}
