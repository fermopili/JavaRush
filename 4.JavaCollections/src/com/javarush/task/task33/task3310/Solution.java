package com.javarush.task.task33.task3310;

import com.javarush.task.task33.task3310.strategy.FileStorageStrategy;
import com.javarush.task.task33.task3310.strategy.HashMapStorageStrategy;
import com.javarush.task.task33.task3310.strategy.OurHashMapStorageStrategy;
import com.javarush.task.task33.task3310.strategy.StorageStrategy;

import java.security.SecureRandom;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by Administrator on 19.05.2017.
 */
public class Solution
{
    static public Set<Long> getIds(Shortener shortener, Set<String> strings)
        {
        Set<Long> longSet = new HashSet<> ( );
        for (String s : strings)
              longSet.add ( shortener.getId ( s ) );
        return longSet;
        }
    public static Set<String> getStrings(Shortener shortener, Set<Long> keys)
        {
        Set<String> stringSet = new HashSet<> ( );
        for (Long id : keys)
            stringSet.add ( shortener.getString ( id ) );

        return stringSet;
        }

    static public void testStrategy(StorageStrategy strategy, long elementsNumber)
        {
        Helper.printMessage ( strategy.getClass ( ).getSimpleName ( ) );

        Set<String> strings  = new HashSet<> ( );
        Long[]      elements = new Long[(int) elementsNumber];

        for (int i = 0; i < elementsNumber; i++)
            strings.add ( Helper.generateRandomString ( ) );

        //6.2.3.3. Создавать объект типа Shortener, используя переданную стратегию.
        Shortener shortener = new Shortener ( strategy );

        //6.2.3.4. Замерять и выводить время необходимое для отработки метода getIds для заданной стратегии
        Date      startDateTime  = new Date ( );
        Set<Long> ids            = getIds ( shortener, strings );
        Date      finishDateTime = new Date ( );

        long deltaTime = finishDateTime.getTime ( ) - startDateTime.getTime ( );
        Helper.printMessage ( Long.toString ( deltaTime ) );

        //6.2.3.5. Замерять и выводить время необходимое для отработки метода getStrings для заданной стратегии
        startDateTime = new Date ( );
        Set<String> strs = getStrings ( shortener, ids );
        finishDateTime = new Date ( );

        deltaTime = finishDateTime.getTime ( ) - startDateTime.getTime ( );
        Helper.printMessage ( Long.toString ( deltaTime ) );

        //6.2.3.6. Сравнивать одинаковое ли содержимое множества строк, которое было сгенерировано и множества, которое было возвращено методом getStrings.
        if (strings.equals ( strs ))
            Helper.printMessage ( "Тест пройден." );
        else
            Helper.printMessage ( "Тест не пройден." );
        }
    public static void main(String... args)
        {
        StorageStrategy strategy = new HashMapStorageStrategy ( );
        testStrategy ( strategy, 10000 );
        strategy = new OurHashMapStorageStrategy ( );
        testStrategy ( strategy, 10000 );
        strategy = new FileStorageStrategy ( );
        testStrategy ( strategy, 10000 );

        }

}
