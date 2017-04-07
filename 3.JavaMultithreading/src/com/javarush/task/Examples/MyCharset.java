package com.javarush.task.Examples;

import java.io.*;
import java.nio.charset.Charset;
import java.util.SortedMap;
import java.util.StringTokenizer;

/**
 * Created by Administrator on 01.04.2017.
 */
 class BigObject implements Serializable
{
}

public class MyCharset
{
    public static void main(String[] args) throws IOException, ClassNotFoundException
        {
//===========================================================================
        BigObject objectOriginal = new BigObject ( );

        ByteArrayOutputStream writeBuffer  = new ByteArrayOutputStream ( );
        ObjectOutputStream    outputStream = new ObjectOutputStream (writeBuffer);
        System.out.println (writeBuffer.size ());
        outputStream.writeObject (objectOriginal);
        outputStream.close ( );
        System.out.println (writeBuffer.size ());
        System.out.println (writeBuffer);

        byte[]               buffer      = writeBuffer.toByteArray ( );
        ByteArrayInputStream readBuffer  = new ByteArrayInputStream (buffer);
        ObjectInputStream    inputStream = new ObjectInputStream (readBuffer);
        BigObject            objectCopy  = (BigObject) inputStream.readObject ( );
        //================================================================
        /*
        SortedMap<String, Charset> charsets = Charset.availableCharsets ( );
        System.out.println (charsets);
        System.out.println ("size=" + charsets.size ( ));
        Charset currentCharset = Charset.defaultCharset ( );

        System.out.println (currentCharset);

        String s      = "АПАПАП news everyone!";
        byte[] buffer = s.getBytes ( );
        for (int i = 0; i < buffer.length; i++)
            System.out.print ((char) buffer[i]);
        System.out.println ( );
//=================================

        Charset koi8 = Charset.forName ("KOI8-R");
        buffer = s.getBytes (koi8);
        for (int i = 0; i < buffer.length; i++)
            System.out.print ((char) buffer[i]);
        System.out.println ( );
        //====================================
        buffer = s.getBytes ("Windows-1251");
        for (int i = 0; i < buffer.length; i++)
            System.out.print ((char) buffer[i]);
        System.out.println ( );
        //===========================================

        //====================================
        buffer = s.getBytes ("GB18030");
        for (int i = 0; i < buffer.length; i++)
            System.out.print ((char) buffer[i]);
        System.out.println ( );
        //===========================================
        String s1 = "Good news everyone!";
        String s2 = s1.replaceAll ("e.", "EX");
        System.out.println (s2);
        {
            String s3 = "Good news everyone!";

            StringTokenizer tokenizer =
                    new StringTokenizer (s3, "ne");
            while (tokenizer.hasMoreTokens ( ))
                {
                    String token = tokenizer.nextToken ( );
                    System.out.println ("|" + token + "|");
                }
        }
        */
        }
}
