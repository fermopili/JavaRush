package com.javarush.task.task18.task1818;

/* 
Два в одном
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws IOException
        {
        BufferedReader   reader = new BufferedReader (new InputStreamReader (System.in));
        String           name1  = reader.readLine ( );
        String           name2  = reader.readLine ( );
        String           name3  = reader.readLine ( );
     //   name1="c:/1.txt";
     //   name2="c:/2.txt";
     //   name3="c:/3.txt";
        FileOutputStream f1     = new FileOutputStream (name1);
        FileInputStream  f2     = new FileInputStream (name2);
        FileInputStream  f3     = new FileInputStream (name3);
        byte[]           b      = new byte[3];
        while (f2.available ( ) > 0)
            {
                int c = f2.read (b);
                f1.write (b, 0, c);
            }
        while (f3.available ( ) > 0)
            {
                int c = f3.read (b);
                f1.write (b, 0, c);

            }
        f1.close ( );
        f2.close ( );
        f3.close ( );
        reader.close ( );

        }
  //  double result = new BigDecimal((double) spaceCount / (double) charCount*100).setScale(2, RoundingMode.HALF_UP).doubleValue();

}
