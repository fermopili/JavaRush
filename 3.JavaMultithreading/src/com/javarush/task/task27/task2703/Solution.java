package com.javarush.task.task27.task2703;

/* 
Создаем deadlock
*/
public class Solution
{
    static class Friend
    {
        private final String name;

        public Friend(String name)
            {
            this.name = name;
            }

        public String getName()
            {
            return this.name;
            }

        synchronized public void bow(Friend bower)
            {
            synchronized(bower)
                {
                    System.out.format ("%s: %s"
                                    + " has bowed to me!%n",
                            this.name, bower.getName ( ));
                    bower.bowBack (this);
                }
            }

        synchronized public void bowBack(Friend bower)
            {
            System.out.format ("%s: %s"
                            + " has bowed back to me!%n",
                    this.name, bower.getName ( ));
            }
    }

    public static void main(String[] args)
        {
        final Friend alphonse = new Friend ("Alphonse");
        final Friend gaston   = new Friend ("Gaston");
        new Thread (new Runnable ( )
        {
            public void run()
                {
                alphonse.bow (gaston);
                }
        }).start ( );
        new Thread (new Runnable ( )
        {
            public void run()
                {
                gaston.bow (alphonse);
                }
        }).start ( );
        }
}
