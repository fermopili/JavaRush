package com.javarush.task.task30.task3013;

/* 
Набираем код
*/

public class Solution
{
    public static void main(String[] args)
        {
        Solution solution = new Solution ( );
        int      number   = Integer.MAX_VALUE - 133;
        number=0b101_0001_1101;
        System.out.println (Integer.toString (number, 2));

        String result = Integer.toString (solution.resetLowerBits (number), 2);
        System.out.println (result);
        }

    public int resetLowerBits(int number)
        {
    /*    int copyValue = number;
        int pos       = 0;
        while (copyValue != 1)
            {
                copyValue >>=1;
                pos ++;
            }
        copyValue<<=pos;
        //напишите тут ваш код
        return copyValue;
        */
        number |= number >> 1;  // решение без переменных заимствовано
        number |= number >> 2;
        number |= number >> 4;
        number |= number >> 8;
        number |= number >> 8;
        number |= number >> 8;

        return number &~ (number >> 1);
        }
}