package com.javarush.task.task11.task1101;

/* 
Лошадь и пегас
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException
        {

    FileInputStream inputStream = new FileInputStream("c:\\2");
    long            sum         = 0;
    int f=inputStream.available();
    while (f> 0) //пока остались непрочитанные байты
        {
            int data = inputStream.read(); //прочитать очередной байт
            sum += data; //добавить его к общей сумме
            System.out.println("+data=\'"+(char)data+"\'    - "+f);
            f=inputStream.available();

        }

        FileInputStream outputtStream = new FileInputStream("c:\\2");

    inputStream.close(); // закрываем поток

    System.out.println("sum="+sum); //выводим сумму на экран.

    }

    public class Horse {

    }

    public class Pegas extends Horse {

    }
}
