package com.javarush.task.task20.task2001;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* 
Читаем и пишем в файл: Human
*/
public class Solution
{
    public static void main(String[] args)
        {
        //исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try
            {
              //  File your_file_name = File.createTempFile ("your_file_name", null);
                 File         your_file_name =new  File("c:/file_name");
                OutputStream outputStream = new FileOutputStream (your_file_name);
                InputStream  inputStream  = new FileInputStream (your_file_name);
                Human ivanov = new Human ("Ivanov", new Asset ("home"), new Asset ("car"));
                ivanov.save (outputStream);
                Human somePerson = new Human ( );
                somePerson.load (inputStream);
                //check here that ivanov equals to somePerson - проверьте тут, что ivanov и somePerson равны
                if (ivanov.equals (somePerson))
                    System.out.println ("OK");
                else
                    System.out.println ("NO");
                inputStream.close ( );
            }
        catch (IOException e)
            {
                //e.printStackTrace();
                System.out.println ("Oops, something wrong with my file");
            }
        catch (Exception e)
            {
                //e.printStackTrace();
                System.out.println ("Oops, something wrong with save/load method");
            }
        }
    public static class Human
    {
        public String name;
        public List<Asset> assets = new ArrayList<> ( );

        public Human()
            {
            }

        @Override
        public boolean equals(Object o)
            {
            if (this == o) return true;
            if (o == null || getClass ( ) != o.getClass ( )) return false;
            Human human = (Human) o;
            if (name != null ? !name.equals (human.name) : human.name != null) return false;
            return assets != null ? assets.equals (human.assets) : human.assets == null;

            }
        @Override
        public int hashCode()
            {
            int result = name != null ? name.hashCode ( ) : 0;
            result = 31 * result + (assets != null ? assets.hashCode ( ) : 0);
            return result;
            }

        public Human(String name, Asset... assets)
            {
            this.name = name;
            if (assets != null)
                {
                    this.assets.addAll (Arrays.asList (assets));
                }
            }
        public void save(OutputStream outputStream) throws Exception
            {
            //implement this method - реализуйте этот метод
            if (name == null)
                throw new Exception ( );
            PrintWriter printWriter = new PrintWriter (outputStream);
            printWriter.println (name);
            for (Asset as : assets)
                {
                    String str = as.getName ( ) + " " + as.getPrice ( );
                    printWriter.println (str);
                }
            printWriter.flush ( );
            }
        public void load(InputStream inputStream) throws Exception
            {
            //implement this method - реализуйте этот метод
            BufferedReader reader = new BufferedReader (new InputStreamReader (inputStream));
            name = reader.readLine ( );
            assets = new ArrayList<> ( );
            while (reader.ready ( ))
                {
                    String   str  = reader.readLine ( );
                    String[] strA = str.split (" ");
                    Asset    as   = new Asset (strA[0]);
                    as.setPrice (Double.parseDouble (strA[1]));
                    assets.add (as);
                }
            }
    }
}
