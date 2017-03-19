package com.javarush.task.task08.task0820;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/* 
Множество всех животных
*/

public class Solution {
    public static class Cat{}
    public static class Dog {}
    public static void main(String[] args) {
        Set<Cat> cats = createCats();
        Set<Dog> dogs = createDogs();

        Set<Object> pets = join(cats, dogs);

        removeCats(pets, cats);
        printPets(pets);
    }

    public static Set<Cat> createCats() {
        HashSet<Cat> result = new HashSet<Cat>();
        result.add(new Cat());
        result.add(new Cat());
        result.add(new Cat());
        result.add(new Cat());
        //напишите тут ваш код

        return result;
    }

    public static Set<Dog> createDogs() {
        HashSet<Dog> result = new HashSet<Dog>();
        //напишите тут ваш код
        result.add(new Dog());
        result.add(new Dog());
        result.add(new Dog());
        return result;
    }

    public static Set<Object> join(Set<Cat> cats, Set<Dog> dogs) {
        //напишите тут ваш код
        Set<Object> jo= new HashSet<>();
        for(Cat c:cats)
            jo.add(c);
        for(Dog d:dogs)
            jo.add(d);
        return jo;
    }

    public static void removeCats(Set<Object> pets, Set<Cat> cats) {
      for(Cat c: cats)
      {
          pets.remove(c);
      }
    }

    public static void printPets(Set<Object> pets) {

        //напишите тут ваш код
        for(Object c:pets)
            System.out.println(c.toString());
    }

    //напишите тут ваш код
}
