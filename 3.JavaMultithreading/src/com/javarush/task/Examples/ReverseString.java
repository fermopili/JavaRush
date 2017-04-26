package com.javarush.task.Examples;

import java.util.concurrent.Callable;

/**
 * Created by Administrator on 24.04.2017.
 */
public class ReverseString implements  Callable<String>
{

    String str;

    public ReverseString(String str)
        {
        this.str = str;
        }

    public String call() throws Exception
        {
        StringBuilder builder = new StringBuilder (str);
        builder.reverse ( );
        return builder.toString ( );
        }

}
