package com.javarush.task.task30.task3006;

/* 
Swap по-новому
*/
public class Solution {
    public static void main(String[] args) {
        /* expected output
        x=4, y=5
        x=5, y=4
         */

        Pair pair = new Pair(4, 5);
        System.out.println(pair);
        pair.swap();
        System.out.println(pair);

    double inf = Double.POSITIVE_INFINITY;
    System.out.println(inf); // Бесконечность
    System.out.println(inf + 1); //Бесконечность+1 ==Бесконечность
    System.out.println(inf + 10); //Бесконечность+10 ==Бесконечность
    System.out.println(inf * -1); //равно «минус бесконечность»
  inf = Double.NEGATIVE_INFINITY;
  System.out.println((5/inf)*(5/inf)); // Бесконечность
    System.out.println(inf + 1); //Бесконечность+1 ==Бесконечность
    System.out.println(inf + 10); //Бесконечность+10 ==Бесконечность
    System.out.println((inf * -1)*0); //равно «минус бесконечность»
    }
}
