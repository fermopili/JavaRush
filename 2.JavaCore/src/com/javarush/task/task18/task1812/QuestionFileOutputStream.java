package com.javarush.task.task18.task1812;

import java.io.*;

/* 
Расширяем AmigoOutputStream
*/

public class QuestionFileOutputStream implements AmigoOutputStream
{
    private AmigoOutputStream aos;

    public QuestionFileOutputStream(AmigoOutputStream aos)
        {
        this.aos = aos;
        }

    @Override
    public void flush() throws IOException
        {
        aos.flush ( );
        }

    @Override
    public void write(int b) throws IOException
        {
        aos.write (b);
        }

    @Override
    public void write(byte[] b) throws IOException
        {
        aos.write (b);
        }

    @Override
    public void write(byte[] b, int off, int len) throws IOException
        {
        aos.write (b, off, len);
        }

    @Override
    public void close() throws IOException
        {
        BufferedReader reader = new BufferedReader (new InputStreamReader (System.in));
        System.out.print ("Вы действительно хотите закрыть поток? Д/Н");
        String str = reader.readLine ( );
        reader.close ( );
        if ("Д".equals (str))
            {
                aos.close ( );
            }
        }
}

