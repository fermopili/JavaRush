package com.javarush.task.task13.task1315;

/* 
Dog, Cat и Mouse
*/

public class Solution {
    public static void main(String[] args) {

    }
    //может двигаться
    public interface Movable {
        void move();
    }

    //может быть съеден
    public interface Eatable {
        void eaten();
    }

    //может кого-нибудь съесть
    public interface Eat {
        void eat();
    }

    public class Dog implements Movable,Eat
    {
        public  void move(){};
        public void eat(){};

    }
    public class Cat implements Movable,Eat,Eatable
    {
        public  void move(){};
        public void eat(){};
        public void eaten(){};
    }
    public class Mouse implements Movable,Eatable{
        public  void move(){};
        public void eaten(){};
    }

}