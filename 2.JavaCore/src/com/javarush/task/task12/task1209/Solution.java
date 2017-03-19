package com.javarush.task.task12.task1209;

/* 
Три метода возвращают минимальное из двух переданных в него чисел
*/

public class Solution
{
    public static void main(String[] args)
        {

        }

    public static int min(int v1, int v2)
        {
        if (v1 < v2)
            return v1;
        return v2;
        }

    public static long min(long v1, long v2)
        {
        if (v1 < v2)
            return v1;
        return v2;
        }

    public static double min(double v1, double v2)
        {
        if (v1 < v2)
            return v1;
        return v2;
        }
    //Напишите тут ваши методы
}
