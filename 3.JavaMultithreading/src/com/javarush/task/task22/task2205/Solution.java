package com.javarush.task.task22.task2205;

/* 
МНЕ нравится курс JavaRush
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(String.format(getFormattedString(), "JavaRush", "курс", "мне", "нравится"));
        //должен быть вывод
        //"МНЕ нравится курс JavaRush"
    String s = "Bender";
    StringBuilder s2 = new StringBuilder(s);
    s2.replace (3, 6, "_DE_"); //будет "Ben_DE_r"
    System.out.println(s2);
    }
    public static String getFormattedString() {
        return  "%3$S %4$s %2$s %1$s";
    }
}
