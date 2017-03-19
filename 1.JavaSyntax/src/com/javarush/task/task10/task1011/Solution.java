package com.javarush.task.task10.task1011;

/* 
Большая зарплата
*/

public class Solution {
    public static void main(String[] args) {
        String s = "Я не хочу изучать Java, я хочу большую зарплату";
        int i = 0;
        while (i < 40) {
            if (s.charAt(0) != ' ') {
                System.out.println(s);
                s = s.substring(1);

            } else {
                s = s.substring(1);
                System.out.println(s);
                System.out.println(s);
                s = s.substring(1);
                i++;
            }
            i++;
        }
        //напишите тут ваш код
    }

}

