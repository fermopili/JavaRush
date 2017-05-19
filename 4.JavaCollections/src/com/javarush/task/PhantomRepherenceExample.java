package com.javarush.task;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.ArrayList;

/**
 * Created by Administrator on 15.05.2017.
 */
public class PhantomRepherenceExample
{
    public static void main(String... args)
        {
        ReferenceQueue<Integer> queue = new ReferenceQueue<Integer> ( );

//список призрачных ссылок
        ArrayList<PhantomReference<Integer>> list = new ArrayList<PhantomReference<Integer>> ( );

//создаем 10 объектов и добавляем их в список через призрачные ссылки
        for (int i = 0; i < 10; i++)
            {
                Integer x = new Integer (i);
                list.add (new PhantomReference<Integer> (x, queue));

            }
        for (int i = 0; i < 10; i++)
             System.out.println (list.get (i).toString ());
        Reference<? extends Integer> referenceFromQueue1;
        while ((referenceFromQueue1 = queue.poll ( )) != null)
            {
                //выводим объект на экран
                System.out.println (referenceFromQueue1.get ( ));
                //очищаем ссылку
             //   referenceFromQueue.clear ( );
            }
//взываем сборщик мусора, надеемся, что он нас послушается :)
//он должен убить все «призрачно достижимые» объекты и поместить их в очередь
//призраков
        System.gc ( );

//достаем из очереди все объекты
        Reference<? extends Integer> referenceFromQueue;
        while ((referenceFromQueue = queue.poll ( )) != null)
            {
                //выводим объект на экран
                System.out.println (referenceFromQueue.get ( ));
                //очищаем ссылку
                referenceFromQueue.clear ( );
            }

        }

}
