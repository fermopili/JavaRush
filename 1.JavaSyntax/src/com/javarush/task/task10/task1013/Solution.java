package com.javarush.task.task10.task1013;

/* 
Конструкторы класса Human
*/

public class Solution {
    public static void main(String[] args) {
    }

    public static class Human {
        // напишите тут ваши переменные и конструкторы
       private String s;
        private int i;
        private  double d;
        private  float f;
        private  boolean b;
        private   short sh;


        public   Human( String s)
        {
            this.s=s;
         }
        public   Human( String s,int i)
        {
            this.s=s;
            this.i=i;

        }
        public   Human( String s,int i,double d)
        {
            this.s=s;
            this.i=i;
            this.d=d;

        }
        public   Human( String s,int i,double d,float f)
        {
            this.s=s;
            this.i=i;
            this.d=d;
            this.f=f;

        }
        public   Human( String s,int i,double d,float f,  boolean b)
        {
            this.s=s;
            this.i=i;
            this.d=d;
            this.f=f;
            this.b=b;

        }
        public   Human( String s,int i,double d,float f,  boolean b,short sh)
        {
            this.s=s;
            this.i=i;
            this.d=d;
            this.f=f;
            this.b=b;
            this.sh=sh;
        }
        public   Human( String s,int i,double d,float f, short sh)
        {
            this.s=s;
            this.i=i;
            this.d=d;
            this.f=f;
            this.sh=sh;
        }
        public   Human( String s,int i,double d,  boolean b,short sh)
        {
            this.s=s;
            this.i=i;
            this.d=d;
            this.b=b;
            this.sh=sh;
        }
        public   Human( String s,int i,float f,  boolean b,short sh)
        {
            this.s=s;
            this.i=i;
            this.f=f;
            this.b=b;
            this.sh=sh;
        }
        public   Human( String s,double d,float f,  boolean b,short sh)
        {
            this.s=s;
            this.d=d;
            this.f=f;
            this.b=b;
            this.sh=sh;
        }





    }
}
