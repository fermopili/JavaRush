package com.javarush.task.task26.task2613;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 25.05.2017.
 */
public class CurrencyManipulator
{
    private String currencyCode;
    private Map<Integer, Integer> denominations = new HashMap<> ( );

    public CurrencyManipulator(String currencyCode)
        {
        this.currencyCode = currencyCode;
        }

    public String getCurrencyCode()
        {
        return currencyCode;
        }

    public void addAmount(int denomination, int count)
        {
        if (denominations.containsKey ( denomination ))
            {
                denominations.put ( denomination, denominations.get ( denomination ) + count );
            }
        else
            {
                denominations.put ( denomination, count );
            }
        }

    public int getTotalAmount()
        {
        int sum = 0;
        for (Map.Entry<Integer, Integer> pair : denominations.entrySet ( ))
            sum += pair.getKey ( ) * pair.getValue ( );

        return sum;
        }

    public boolean hasMoney()
        {
        return denominations.size ( ) != 0;
        }
}
