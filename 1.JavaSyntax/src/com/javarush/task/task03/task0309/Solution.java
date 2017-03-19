package com.javarush.task.task03.task0309;

/* 
Сумма 10 чисел
*/

public class Solution {
    public static void main(String[] args) {
        String[] str = {"Мама", "Мыла", "Раму"}; //напишите тут ваш код
        for (int k = 0; k < 3; k++)
        {  String s=str[k];
            str[0]=str[k];
            str[k]=s;
            for (int i = 0; i < 3; i++)
            {
                System.out.print(str[i]);
                for (int j = 0; j < 3; j++)
                {
                    if (i != j)
                        System.out.print(str[j]);
                }
                System.out.println();
            }
            s=str[0];
            str[k]=str[0];
            str[0]=s;
        }

    }
}
