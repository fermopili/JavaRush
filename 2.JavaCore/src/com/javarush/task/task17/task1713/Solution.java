package com.javarush.task.task17.task1713;

import java.util.*;

/* 
Общий список
*/

public abstract class Solution implements List<Long>
{

    private ArrayList<Long> original = new ArrayList<Long> ( );

    public static void main(String[] args)
        {
        }

    @Override
    synchronized public int size()
        {
        return original.size ( );
        }

}
