package com.javarush.task.task07.task0716;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Р или Л
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bis = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<String> list = new ArrayList<String>();
        list.add("роза"); //0
        list.add("qwqwq"); //1
        list.add("лира"); //2
         list.add("лоза"); //1
        list.add("erer"); //1
        list = fix(list);

        for (String s : list) {
            System.out.println(s);
        }
    }

    public static ArrayList<String> fix(ArrayList<String> list) {
        ArrayList<String> res=new ArrayList();
        for (String s :   list)
        {
            if(s.contains("л")&&s.contains("р"))
            { res.add(s); continue;}
            if(s.contains("л"))
            { res.add(s); res.add(s);
                continue;
            }

            if(s.contains("р"))
                continue;
            res.add(s);
        }
        return res;
    }
}