package com.javarush.task.task34.task3408;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.WeakHashMap;

public class Cache<K, V>
{
    private Map<K, V> cache = new WeakHashMap<K, V> ( );   //TODO add your code here

    public V getByKey(K key, Class<V> clazz) throws Exception
        {
        //TODO add your code here
        if (!cache.containsKey (key))
            cache.put (key, clazz.getConstructor (key.getClass ( )).newInstance (key));
        return cache.get (key);
        }

    public boolean put(V obj)
        {
        //TODO add your code here
        try
            {
                Method getKey = obj.getClass ( ).getDeclaredMethod ("getKey");
                getKey.setAccessible (true);
                cache.put ((K) getKey.invoke (obj), obj);
                return true;
            }
        catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e)
            {

            }
        return false;

        }

    public int size()
        {
        return cache.size ( );
        }
}
