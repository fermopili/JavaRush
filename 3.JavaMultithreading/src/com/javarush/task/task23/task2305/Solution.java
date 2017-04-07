package com.javarush.task.task23.task2305;

/* 
Inner
*/
public class Solution
{
    public InnerClass[] innerClasses = new InnerClass[2];

    public class InnerClass
    {
    }
    public static Solution[] getTwoSolutions()
        {
        Solution solution=new Solution ();
        Solution[] array=new Solution[2];
        array[0]=new Solution ();

        array[0].innerClasses[0]=solution.new InnerClass();
        array[0].innerClasses[1]=solution.new InnerClass();

        array[1]=new Solution ();
        array[1].innerClasses[0]=solution.new InnerClass();
        array[1].innerClasses[1]=solution.new InnerClass();

        return array;
        }

    public static void main(String[] args)
        {

        }
}
