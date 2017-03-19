package com.javarush.task.task04.task0422;

/* 
18+
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s1 = reader.readLine();
        int i =Integer.parseInt(reader.readLine());
        if(i<18)
            System.out.print("Подрасти еще");

    }
}
