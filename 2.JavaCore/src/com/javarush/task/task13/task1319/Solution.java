package com.javarush.task.task13.task1319;

import java.io.*;
import java.util.Scanner;

/* 
Запись в файл с консоли
*/

public class Solution
{
    public static void main(String[] args) throws IOException
        {
        // напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
       // BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String      name = reader.readLine();
        BufferedWriter writer = new BufferedWriter(new FileWriter(name));
        while (true)
            {
                String str = reader.readLine();
                writer.write(str);
                writer.write("\n");
                if (str.equals("exit"))
                    break;
            }
        reader.close();
        writer.close();
        }
}
