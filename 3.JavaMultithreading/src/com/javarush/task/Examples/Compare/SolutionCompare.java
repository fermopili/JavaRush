package com.javarush.task.Examples.Compare;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Administrator on 11.04.2017.
 */
public class SolutionCompare
{
    class Woman implements Comparable<Woman>
    {
        public int age;

        public Woman(int age)
            {
            this.age = age;
            }

        @Override
        public int compareTo(Woman o)
            {
            return this.age - o.age;
            }

        @Override
        public String toString()
            {
            return "Woman{" +
                    "age=" + age +
                    '}';
            }
    }

    /////////////////////////////////////////
    static class AtomicCounter
    {
        private AtomicInteger c = new AtomicInteger(0);

        public void increment()
            {
            c.incrementAndGet();
            }

        public void decrement()
            {
            c.decrementAndGet();
            }

        public int value()
            {
            return c.get();
            }
    }
    ///////////////////////////////////////////////
    static public void main(String[] args)
        {
        ArrayList<Woman> women = new ArrayList<Woman> ( );
        women.add (new SolutionCompare ( ).new Woman (18));
        women.add (new SolutionCompare ( ).new Woman (21));
        women.add (new SolutionCompare ( ).new Woman (5));
        women.add (new SolutionCompare ( ).new Woman (17));

        System.out.println (women);
        Collections.sort (women);
        System.out.println (women);
//===========================================================
        ArrayList<WWomen> wwomen = new ArrayList<WWomen> ( );
        wwomen.add (new WWomen (18));
        wwomen.add (new WWomen (21));
        wwomen.add (new WWomen (5));

        Comparator<WWomen> compareByHeight = new Comparator<WWomen> ( )//
        {
            public int compare(WWomen o1, WWomen o2)
                {
                return o1.height - o2.height;
                }
        };
        Collections.sort (wwomen, compareByHeight);

        Comparator<WWomen> compareByName = new Comparator<WWomen> ( )// коипаратор где ставнивание идет по строкам
        {
            public int compare(WWomen o1, WWomen o2)
                {
                return o1.name.compareTo (o2.name);
                }
        };
        AtomicCounter c=new AtomicCounter ();
        c.increment ();
        c.increment ();
        c.increment ();
        c.increment ();
        c.increment ();
        System.out.println (c.value ());
        }
}
