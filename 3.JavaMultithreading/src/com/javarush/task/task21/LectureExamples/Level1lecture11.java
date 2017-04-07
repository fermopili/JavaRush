package com.javarush.task.task21.LectureExamples;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

/**
 * Created by Administrator on 30.03.2017.
 */
public class Level1lecture11
{
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchMethodException
        {
        Class[] interfaces = String.class.getInterfaces ( );
        Class   parrent    = String.class.getSuperclass ( );

        Method[] metod = List.class.getMethods ( );
        String   s     = String.class.newInstance ( );

        String s1     = String.class.newInstance ( );
        Method m      = String.class.getMethod ("length");
        int    length = (int) m.invoke (s);
        for (Class cc : interfaces)
            System.out.println (cc);
        System.out.println ("===================================");
        System.out.println (parrent);
        System.out.println ("===================================");
        for (Method mm : metod)
               System.out.println (mm);

        System.out.println (s);
        System.out.println ("===================================");
        System.out.println (s1);
        System.out.println ("===================================");
        System.out.println (length);
        System.out.println ("===================================");


        }
}
