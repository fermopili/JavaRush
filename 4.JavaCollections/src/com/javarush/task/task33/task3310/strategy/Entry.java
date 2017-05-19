package com.javarush.task.task33.task3310.strategy;

import java.io.Serializable;
import java.util.Map;
import java.util.Objects;

/**
 * Created by Administrator on 19.05.2017.
 */
public class Entry implements Serializable
{
    int    hash;
    Long   key;
    String value;
    Entry  next;

    public Entry(int hash, Long key, String value, Entry next)
        {
        this.hash = hash;
        this.key = key;
        this.value = value;
        this.next = next;
        }

    public final Long getKey()
        {
        return key;
        }

    public final String getValue()
        {
        return value;
        }

    public final String toString()
        {
        return key + "=" + value;
        }


    public final String setValue(String newValue)
        {
        String oldValue = value;
        value = newValue;
        return oldValue;
        }

    @Override
    public int hashCode()
        {
        return (key == null ? 0 : key.hashCode ( )) ^ (value == null ? 0 : value.hashCode ( ));
        }

    @Override
    public boolean equals(Object o)
        {
        if (!(o instanceof Entry))
            return false;

        Long   k1 = getKey ( );
        Long   k2 = ((Entry) o).getKey ( );
        String v1 = getValue ( );
        String v2 = ((Entry) o).getValue ( );
        if (k1 == k2 || (k1 != null && k1.equals ( k2 )))
            {
                if (v1 == v2 || (v1 != null && v1.equals ( v2 )))
                    {
                        return true;
                    }
            }

        return false;
        }

}