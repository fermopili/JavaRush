package com.javarush.task.task29.task2907;

import java.math.BigDecimal;

/* 
Этот странный BigDecimal
*/
public class Solution
{
    public static void main(String[] args)
        {
        System.out.println (getValue (1.10d, 1.20d));
        }

    public static BigDecimal getValue(double v1, double v2)
        {
        return new BigDecimal(v1+"").add(new BigDecimal(v2+""));
/*
        BigDecimal b1=new  BigDecimal ( v1);// работает но не проходит валидацию
        BigDecimal b2= new BigDecimal( v2);
        return  BigDecimal.valueOf (b1.doubleValue ()+ b2.doubleValue ());
      */
   //     return  BigDecimal.valueOf ( v1).add ( BigDecimal.valueOf (v2)); // работает но не проходит валидацию
        }
}