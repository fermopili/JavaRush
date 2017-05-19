package com.javarush.task.task33.task3310.tests;

import com.javarush.task.task33.task3310.Shortener;
import com.javarush.task.task33.task3310.strategy.*;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Administrator on 19.05.2017.
 */
public class FunctionalTest
{
    public void testStorage(Shortener shortener)
        {

        Long id1 = shortener.getId ( "123456" );
        Long id2 = shortener.getId ( "ABCDEF" );
        Long id3 = shortener.getId ( "123456" );
        Assert.assertNotEquals ( id1, id2 );
        Assert.assertNotEquals ( id3, id2 );
        Assert.assertEquals ( id1, id3 );
        String s1 = shortener.getString ( id1 );
        String s2 = shortener.getString ( id2 );
        String s3 = shortener.getString ( id3 );
        Assert.assertNotEquals ( s1, s2 );
        Assert.assertNotEquals ( s3, s2 );
        Assert.assertEquals ( s1, s3 );
        }

    @Test
    public void testHashMapStorageStrategy()
        {
        Shortener shortener = new Shortener ( new HashMapStorageStrategy ( ) );
        testStorage( shortener);
        }

    @Test
    public void testOurHashMapStorageStrategy()
        {
        Shortener shortener = new Shortener ( new OurHashMapStorageStrategy ( ) );
        testStorage( shortener);
        }

    @Test
    public void testFileStorageStrategy()
        {
        Shortener shortener = new Shortener ( new FileStorageStrategy ( ) );
        testStorage( shortener);
        }

    @Test
    public void testHashBiMapStorageStrategy()
        {
        Shortener shortener = new Shortener ( new HashBiMapStorageStrategy ( ) );
        testStorage( shortener);
        }

    @Test
    public void testDualHashBidiMapStorageStrategy()
        {
        Shortener shortener = new Shortener ( new DualHashBidiMapStorageStrategy ( ) );
        testStorage( shortener);
        }

    @Test
    public void testOurHashBiMapStorageStrategy()
        {
        Shortener shortener = new Shortener ( new OurHashBiMapStorageStrategy ( ) );
        testStorage( shortener);
        }
}
