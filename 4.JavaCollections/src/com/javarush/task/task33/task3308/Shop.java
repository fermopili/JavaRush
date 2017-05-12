package com.javarush.task.task33.task3308;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 12.05.2017.
 */
@XmlType(name = "shop")
@XmlRootElement
public class Shop
{
    @Override
    public String toString()
        {
        return "Shop{" +
                "goods=" + goods +
                ", count=" + count +
                ", profit=" + profit +
                ", secretData=" + Arrays.toString (secretData) +
                '}';
        }

    @XmlType(name = "goods")
    @XmlRootElement
    static class Goods
    {  @XmlElement(name = "names")
        List<String> names;

        @Override
        public String toString()
            {
            return "Goods{" +
                    "names=" + names +
                    '}';
            }
    }
    @XmlElement(name = "goods")
    public Goods    goods;
    @XmlElement(name = "count")
    public int      count;
    @XmlElement(name = "profit")
    public double   profit;
    @XmlElement(name = "secretData")
    public String[] secretData;

}
