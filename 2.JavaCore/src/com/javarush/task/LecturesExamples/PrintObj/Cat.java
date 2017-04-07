package com.javarush.task.LecturesExamples.PrintObj;


import java.io.*;

/**
 * Created by Administrator on 28.03.2017.
 */

    class Cat
    {
        public String name;
        public int    age;
        public int    weight;
        public Cat()
            {
            }
        public Cat(String name, int age, int weight)
            {
            this.name = name;
            this.age = age;
            this.weight = weight;
            }
        public void save(OutputStream outputStream) throws Exception
            {
            PrintWriter printWriter = new PrintWriter (outputStream);
            printWriter.println (name);
            printWriter.println (age);
            printWriter.println (weight);
            printWriter.flush ( );
            }
        public void load(InputStream inputStream) throws Exception
            {
            BufferedReader reader = new BufferedReader (new InputStreamReader (inputStream));
            name = reader.readLine ( );
            age = Integer.parseInt (reader.readLine ( ));
            weight = Integer.parseInt (reader.readLine ( ));
            }
        public Cat loadO(InputStream inputStream) throws Exception
            {
            BufferedReader reader = new BufferedReader (new InputStreamReader (inputStream));
            name = reader.readLine ( );
            age = Integer.parseInt (reader.readLine ( ));
            weight = Integer.parseInt (reader.readLine ( ));
            return new Cat (name, age, weight);
            }
    }

