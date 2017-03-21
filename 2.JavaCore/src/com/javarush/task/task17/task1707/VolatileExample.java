package com.javarush.task.task17.task1707;

/**
 * Created by Administrator on 20.03.2017.
 */
public class VolatileExample
{

    public static void main(String[] args)
        {
        new VolatileExample ( ).start ( );
        }
    //----------------------------------------------
    volatile    private boolean btExit = false; //попробуйте убрать volatile
    // запуск потоков
    public void start()
        {
        new Thread (gui).start ( );
        System.out.println ("gui thread started");
        new Thread (game).start ( );
        System.out.println ("game thread started");
        }

    // поток для интерфейса
    Runnable gui = new Runnable ( )
    {
        @Override
        public void run()
            {
            try
                {
                    Thread.sleep (2000); // типа пользователь общается с GUI и выходит из игры
                }
            catch (InterruptedException ignored)
                {
                }
            btExit = true; // поток game не видит это изменение без volatile
            System.out.println ("gui thread finished");
            }
    };
    // поток для игры
    Runnable game = new Runnable ( )
    {
        @Override
        public void run()
            {
            while (!btExit)
                {
                    // без volatile этот цикл крутится бесконечно
                    ;   // System.out.println (btExit);
                }
            System.out.println ("game thread finished");
            }
    };

}
