package com.javarush.task.task26.task2613;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 25.05.2017.
 */
public final class CurrencyManipulatorFactory
{
    static private Map<String, CurrencyManipulator> map = new HashMap<> ( );

    private CurrencyManipulatorFactory()
        {
        }

    public static CurrencyManipulator getManipulatorByCurrencyCode(String currencyCode)
        {
        if (!map.containsKey ( currencyCode ))
            map.put ( currencyCode, new CurrencyManipulator ( currencyCode ) );

        return map.get ( currencyCode );
        }
    public static Collection<CurrencyManipulator> getAllCurrencyManipulators() {
    return map.values();
    }

}
