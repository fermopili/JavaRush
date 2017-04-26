package com.javarush.task.Examples;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by Administrator on 24.04.2017.
 */
public class CallableClass
{


    public static void main(String[] args) throws InterruptedException
        {//1. Создаем ThreadPoolExecutor
        ExecutorService service = Executors.newFixedThreadPool (5);

//2 помещаем в него задачу для выполнения

        Future<String> task = service.submit (new  ReverseString("1234567asd"));

//3 ждем пока задача выполнится
        while (!task.isDone ( ))
            {
                try
                    {
                        Thread.sleep (1);
                    }
                catch (InterruptedException e)
                    {
                        e.printStackTrace ( );
                    }
            }

//4 пробуем получить результат задачи
//получим или результат или исключение, если оно было при выполнении задачи
        try
            {
                System.out.println ("Развернутая строка : " + task.get ( ));
            }
        catch (Exception ie)
            {
                ie.printStackTrace (System.err);
            }

//5 останавливаем ThreadPool.
        service.shutdown ( );
        }
}
