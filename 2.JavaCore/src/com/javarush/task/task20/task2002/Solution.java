package com.javarush.task.task20.task2002;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* 
Читаем и пишем в файл: JavaRush
*/
public class Solution
{
    public static void main(String[] args)
        {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try
            {
                // File your_file_name = File.createTempFile("your_file_name", null);
                File         your_file_name = new File ("c:/1");
                OutputStream outputStream   = new FileOutputStream (your_file_name);
                InputStream  inputStream    = new FileInputStream (your_file_name);

                JavaRush javaRush = new JavaRush ( );
                //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
                User u = new User ( );
                u.setFirstName ("setFirstName1");
                u.setLastName ("setLastName1");
                u.setBirthDate (new Date ( ));
                u.setMale (true);
                u.setCountry (User.Country.UKRAINE);
                javaRush.users.add (u);
                u = new User ( );
                u.setFirstName ("setFirstName2");
                u.setLastName ("setLastName2");
                u.setBirthDate (new Date ( ));
                u.setMale (false);
                u.setCountry (User.Country.OTHER);
                javaRush.users.add (u);
                javaRush.save (outputStream);
                outputStream.flush ( );

                JavaRush loadedObject = new JavaRush ( );
                loadedObject.load (inputStream);
                //check here that javaRush object equals to loadedObject object - проверьте тут, что javaRush и loadedObject равны

               for(int i=0;i< javaRush.users.size ();i++)
                   {
                       User   u1=javaRush.users.get (i);
                       User  u2=loadedObject.users.get (i);
                       if(u1.equals (u2))
                           System.out.println ("OK");
                       else
                           System.out.println ("NO");
                   }

                outputStream.close ( );
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

    public static class JavaRush
    {
        public List<User> users = new ArrayList<> ( );

        public void save(OutputStream outputStream) throws Exception
            {
            //implement this method - реализуйте этот метод
            PrintWriter printWriter = new PrintWriter (outputStream);

            for (User u : users)
                {
                    String str = u.getFirstName ( ) + " " +
                            u.getLastName ( ) + " " +
                            u.getBirthDate ( ).getTime ( ) + " " +
                            u.isMale ( ) + " " +
                            u.getCountry ( ).getDisplayedName ();
                    printWriter.println (str);
                }
            printWriter.flush ( );
            }

        public void load(InputStream inputStream) throws Exception
            {
            //implement this method - реализуйте этот метод
            BufferedReader reader = new BufferedReader (new InputStreamReader (inputStream));
            while (reader.ready ( ))
                {
                    String   str  = reader.readLine ( );
                    String[] strA = str.split (" ");
                    User     u    = new User ( );
                    u.setFirstName (strA[0]);
                    u.setLastName (strA[1]);
                    u.setBirthDate (new Date (Long.parseLong (strA[2])));
                    u.setMale (Boolean.parseBoolean (strA[3]));
                    switch (strA[4])
                        {
                        case ("Ukraine"):
                            u.setCountry (User.Country.UKRAINE);
                            break;
                        case ("Russia"):
                            u.setCountry (User.Country.RUSSIA);
                            break;
                        default:
                            u.setCountry (User.Country.OTHER);
                            break;
                        }
                    String str1 = u.getFirstName ( ) + " " +
                            u.getLastName ( ) + " " +
                            u.getBirthDate ( ).getTime ( ) + " " +
                            u.isMale ( ) + " " +
                            u.getCountry ( );
                    System.out.println (str1);
                    users.add (u);
                }
            }

        @Override
        public boolean equals(Object o)
            {
            if (this == o) return true;
            if (o == null || getClass ( ) != o.getClass ( )) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals (javaRush.users) : javaRush.users == null;

            }

        @Override
        public int hashCode()
            {
            return users != null ? users.hashCode ( ) : 0;
            }
    }
}
