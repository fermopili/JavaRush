package com.javarush.task.LecturesExamples.PrintObj;

import java.io.*;

/**
 * Created by Administrator on 28.03.2017.
 */
class Dog
{
    public String name;
    public int age;

    public void save(OutputStream outputStream) throws Exception
        {
        PrintWriter printWriter = new PrintWriter(outputStream);
        printWriter.println(name);
        printWriter.println(age);
        printWriter.flush();
        }

    public void load(InputStream inputStream) throws Exception
        {
        BufferedReader reader = new BufferedReader(new InputStreamReader (inputStream));
        name = reader.readLine();
        age = Integer.parseInt(reader.readLine());
        }
}
