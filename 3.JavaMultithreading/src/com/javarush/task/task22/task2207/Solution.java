package com.javarush.task.task22.task2207;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* 
Обращенные слова
*/
public class Solution
{
    public static List<Pair> result = new LinkedList<> ( );

    public static void main(String[] args) throws IOException
        {
        BufferedReader reader = new BufferedReader (new InputStreamReader (System.in));
        String         nameF  = reader.readLine ( );
      //  nameF = "c:/1";
        BufferedReader readerF = new BufferedReader (new FileReader (nameF));
        ArrayList<String>    words     = new ArrayList<> ();
        while (readerF.ready ( ))
            {
                String   str  = readerF.readLine ( );
                String[] strA = str.split (" ");
                for (int i = 0; i < strA.length; i++)
                    if (strA[i].length ( ) != 0)
                        words.add (strA[i]);
            }
        String[]         strA = new String[words.size ( )];
        Iterator<String> is   = words.iterator ( );
        int              ii   = 0;
     //   System.out.println (words);
        while (is.hasNext ( ))
                strA[ii++] = is.next ( );
        for (int i = 0; i < strA.length; i++)
            {
                if (strA[i] == null)
                    continue;
                for (int j = i + 1; j < strA.length; j++)
                    {
                        if (strA[j] == null)
                            continue;
                     //  StringBuffer sbf = new StringBuffer (strA[j]);
                        StringBuilder sbf = new StringBuilder (strA[j]);

                        if (strA[i].equals (sbf.reverse ( ).toString ( )))
                            {
                                Pair pp = new Pair ( );
                                pp.first = strA[i];
                                pp.second = strA[j];
                                for (int k = j+1; k < strA.length; k++)
                                    { if (strA[k] == null)
                                        continue;
                                        if((strA[k].equals (strA[i]))||(strA[k].equals (strA[j])))
                                           strA[k] = null;
                                    }
                                result.add (pp);
                                break;
                            }
                    }
            }
   //     System.out.println (result);
        reader.close ();
        readerF.close ();
        }
    public static class Pair
    {
        String first;
        String second;

        @Override
        public boolean equals(Object o)
            {
            if (this == o) return true;
            if (o == null || getClass ( ) != o.getClass ( )) return false;

            Pair pair = (Pair) o;

            if (first != null ? !first.equals (pair.first) : pair.first != null) return false;
            return second != null ? second.equals (pair.second) : pair.second == null;

            }

        @Override
        public int hashCode()
            {
            int result = first != null ? first.hashCode ( ) : 0;
            result = 31 * result + (second != null ? second.hashCode ( ) : 0);
            return result;
            }

        @Override
        public String toString()
            {
            return first == null && second == null ? "" :
                    first == null && second != null ? second :
                            second == null && first != null ? first :
                                    first.compareTo (second) < 0 ? first + " " + second : second + " " + first;

            }
    }

}
