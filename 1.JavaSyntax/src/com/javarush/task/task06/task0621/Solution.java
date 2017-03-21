package com.javarush.task.task06.task0621;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Родственные связи кошек
*/

public class Solution
{
    public static void main(String[] args) throws IOException
        {
        BufferedReader reader = new BufferedReader (new InputStreamReader (System.in));

        String d    = reader.readLine ( );//"дедушка Вася";
        String b    = reader.readLine ( );//"бабушка Мурка";
        String p    = reader.readLine ( );//"папа Котофей";
        String m    = reader.readLine ( );//"мама Василиса";
        String s    = reader.readLine ( );//"сын Мурчик";
        String g    = reader.readLine ( );//"дочь Пушинка";
        Cat    catD = new Cat (d);
        Cat    catB = new Cat (b);
        Cat    catP = new Cat (p, catD, null);
        Cat    catM = new Cat (m, null, catB);
        Cat    catS = new Cat (s, catP, catM);
        Cat    catG = new Cat (g, catP, catM);
        System.out.println (catD);
        System.out.println (catB);
        System.out.println (catP);
        System.out.println (catM);
        System.out.println (catS);
        System.out.println (catG);
        }
    public static class Cat
    {
        private String name;
        private Cat    parentP;
        private Cat    parentM;

        Cat(String name)
            {
            this.name = name;
            }

        Cat(String name, Cat parentP, Cat parentM)
            {
            this.name = name;
            this.parentP = parentP;
            this.parentM = parentM;
            }

        @Override
        public String toString()
            {
            String ret = "Cat name is " + name;
            if (parentM == null)
                ret = ret + ", no mother ";
            else
                ret = ret + ", mother is " + parentM.name;
            if (parentP == null)
                ret = ret + ", no father ";
            else
                ret = ret + ", father is " + parentP.name;
            return ret;
            }
    }

}
