package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Парсер реквестов
*/

public class Solution
{
    public static void main(String[] args) throws IOException
        {
        //add your code here
        BufferedReader    reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list    = new ArrayList<>();
        ArrayList<String> val    = new ArrayList<>();
        String            str;
        try
            {
                str = reader.readLine();

            }
        catch (IOException e)
            {
                e.printStackTrace();
                reader.close();
                return;
            }

        str= str.substring(str.indexOf('?')+1);
        String[] strArray = str.split("&");
        for(String s : strArray){
            if(s.contains("obj=")) {
                list.add(s.substring(s.indexOf('=') + 1));  //скопировал все значения obj в отдельный лист
            }
        }
        for(int i=0; i<strArray.length; i++){
            if(strArray[i].contains("=")) {
                strArray[i] = strArray[i].substring(0, strArray[i].indexOf('='));   //отрезал все, что перед "=" в параметрах
            }
        }

        for(int i=0; i<strArray.length-1; i++)                            //распечатал через пробел
            System.out.print(strArray[i]+" ");
        System.out.println(strArray[strArray.length-1]);
        if(!list.isEmpty()) {                               //если был встречен obj...
            for (String s : list) {
                try{
                    alert(Double.parseDouble(s));           //...то парсю и передаю в alert(double value)....
                }
                catch(Exception e){alert(s);}           //если не парсится, то передаю строкой
            }
        }
        reader.close();
        }

    public static void alert(double value)
        {
        System.out.println("double " + value);
        }

    public static void alert(String value)
        {
        System.out.println("String " + value);
        }
}
