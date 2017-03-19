package com.javarush.task.task05.task0517;

/* 
Конструируем котиков
*/
public class Cat {
    String name;
    int weight;
    int age;
    String color;
    String address;

    public Cat(String name) {
        this.name = name;
        this.weight = 3;
        this.age = 3;
        this.color="RED";
    }

    public Cat(String name, int weight, int age) {
        this.name = name;
        this.weight = weight;
        this.age = age;
        this.color="RED";
    }

    public Cat(String name, int age) {
        this.name = name;
        this.weight = 3;
        this.age = age;
        this.color="RED";
    }

    public Cat(int weight, String color) {

        this.weight = weight;
        this.age = 3;
        this.color = color;
    }

    public Cat(int weight, String color, String address) {

        this.weight = weight;
        this.age = 3;
        this.color = color;
        this.address = address;
    }

    public static void main(String[] args) {

    }
}
