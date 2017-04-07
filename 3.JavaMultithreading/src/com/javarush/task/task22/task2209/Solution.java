package com.javarush.task.task22.task2209;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.SortedMap;

/*
Составить цепочку слов
*/
/*
public class Solution
{
    public static void main(String[] args) throws IOException
        {
        //...
        BufferedReader reader = new BufferedReader (new InputStreamReader (System.in));
        String         nameF;//= reader.readLine ( );
        nameF = "c:/1";
        BufferedReader    readerF = new BufferedReader (new FileReader (nameF));
        ArrayList<String> words   = new ArrayList<> ( );
        while (readerF.ready ( ))
            {
                String   str  = readerF.readLine ( );
                String[] strA = str.split (" ");
                for (int i = 0; i < strA.length; i++)
                    if (strA[i].length ( ) != 0)
                        words.add (strA[i]);
            }
        System.out.println (words);

        String[] ww = words.toArray (new String[words.size ( )]);
        //  for (int i = 0; i < ww.length; i++)
        //    System.out.println (ww[i]+"|");

        StringBuilder result = getLine (ww);
        System.out.println (result.toString ( ));
        reader.close ( );
        readerF.close ( );
        }


    public static StringBuilder getLine(String... words)
        {
        int           max   = 0;
        int           len;
        StringBuilder sBmax = new StringBuilder ( );
        String        www;
        for (int i = 0; i < words.length; i++)
            {
                StringBuilder sb = new StringBuilder ( );
                www = words[i];
                sb.append (www).append (" ");
                len = 1;
                for (int j = 0; j < words.length; j++)
                    {
                        if (www .equals (words[j]))
                            continue;
                        if (control (www, words[j]))
                            {
                                sb.append (words[j]).append (" ");
                                len++;
                                www = words[j];

                                // построить массив неиспользованных слов и снова запустить алгоритм
                            }
                    }
                if (len > max)
                    {
                        sBmax = new StringBuilder ( );
                        sBmax.append (sb.toString ( ));
                    }
            }
        return sBmax;
        }

    public static boolean control(String first, String second)
        {
        String f = first.toUpperCase ( );
        String s = second.toUpperCase ( );
        return (f.charAt (f.length ( ) - 1) == s.charAt (0));
        }
}
*/
public class Solution {
    public static void main(String[] args) {
    try (BufferedReader rcon = new BufferedReader(new InputStreamReader(System.in));
         BufferedReader fileIn = new BufferedReader(new FileReader(rcon.readLine())))
        {
            StringBuilder sb = new StringBuilder();
            while (fileIn.ready()) {
                sb.append(fileIn.readLine());
            }
            String[] words = sb.toString().split(" ");
            StringBuilder result = getLine(words);
            System.out.println(result.toString());
        } catch (IOException e) {
        e.printStackTrace();
    }
    }

    public static StringBuilder getLine(String... words) {
    StringBuilder result = new StringBuilder();
    if (words == null || words.length == 0) return result;
    if (words.length==1 || words[0].equals("")) return result.append(words[0]);

    ArrayList<String> wordsList = new ArrayList<>();

    wordsList.addAll(Arrays.asList(words));
    while (wordsList.remove("")){
        wordsList.remove("");
    }
    while (isYes(wordsList)) {
        Collections.shuffle(wordsList);
    }
    for (String word: wordsList){
        result.append(word).append(" ");
    }
    result.deleteCharAt(result.length()-1);
    return result;
    }

    public static boolean isYes(ArrayList<String> wordsList) {
    for (int i = 0; i < wordsList.size() - 1; i++) {
        String firstWord = wordsList.get(i).toLowerCase();
        String secondWord = wordsList.get(i + 1).toLowerCase();
        if (firstWord.charAt(firstWord.length() - 1) != secondWord.charAt(0)) return true;
    }
    return false;
    }
}