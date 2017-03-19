package com.javarush.task.task03.task0303;

/* 
Обмен валют
*/

public class Solution {
    public static void main(String[] args) {
       System.out.println(convertEurToUsd(100,1.0232423));
        System.out.println(convertEurToUsd(200,1.0124324));
    }

    public static double convertEurToUsd(int eur, double course) {
        return (eur *course );
    }
}
