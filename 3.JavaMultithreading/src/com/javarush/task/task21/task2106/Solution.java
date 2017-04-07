package com.javarush.task.task21.task2106;

import java.util.Date;

/* 
Ошибка в equals/hashCode
*/
public class Solution
{
    private int      anInt;
    private String   string;
    private double   aDouble;
    private Date     date;
    private Solution solution;

    public Solution(int anInt, String string, double aDouble, Date date, Solution solution)
        {
        this.anInt = anInt;
        this.string = string;
        this.aDouble = aDouble;
        this.date = date;
        this.solution = solution;
        }

    @Override
    public boolean equals(Object o)
        {
        if (this == o)
            return true;
        if (o == null)
            if (!(o instanceof Solution))
                return false;
        Solution solution = (Solution) o;
        if (anInt != solution.anInt)
            return false;
        if (Double.compare (solution.aDouble, aDouble) != 0)
            return false;
        if (string != null ? !string.equals (solution.string) : solution.string != null)
            return false;
        if (date != null ? !date.equals (solution.date) : solution.date != null)
            return false;
        return this.solution != null ? this.solution.equals (solution.solution) : solution.solution == null;
        }

    @Override
    public int hashCode()
        {
        int  result;
        long temp;
        result = anInt;
        result = 31 * result + (string != null ? string.hashCode ( ) : 0);
        temp = Double.doubleToLongBits (aDouble);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (date != null ? date.hashCode ( ) : 0);
        result = 31 * result + (solution != null ? solution.hashCode ( ) : 0);
        return result;
        }

    public static void main(String[] args)
        {

        }
}
