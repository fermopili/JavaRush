package com.javarush.task.task23.task2307;

/* 
Как выбрать нужное?
*/
public class Solution
{
    public static final String TEST = "tests";

    public static class TEST
    {
        @Override
        public String toString()
            {
            return "tests class";
            }
    }

    static Object obj;

    public static void main(String[] args)
        {
        obj = new Solution.TEST();
        System.out.println (obj);
        }
}
