package com.javarush.task.task12.task1233;

/* 
Задача по алгоритмам
*/

public class Solution
{
    public static void main(String[] args) throws Exception
        {
        int[] data = new int[]{1, 2, 3, 5, -2, -8, 0, 77, 5, 5};

        Pair<Integer, Integer> result = getMinimumAndIndex(data);

        System.out.println("Minimum is " + result.x);
        System.out.println("Index of minimum element is " + result.y);
        }

    public static Pair<Integer, Integer> getMinimumAndIndex(int[] array)
        {
        if (array == null || array.length == 0)
            {
                return new Pair<Integer, Integer>(null, null);
            }

        //напишите тут ваш код
        int index = 0;
        int value = array[0];
        for (int i = 1; i < array.length; i++)
            {
                if (value > array[i])
                    {
                        index = i;
                        value = array[i];
                    }
            }
        return new Pair<Integer, Integer>(value, index);
        }


    public static class Pair<X, Y>
    {
        public X x;
        public Y y;

        public Pair(X x, Y y)
            {
            this.x = x;
            this.y = y;
            }
    }
}
