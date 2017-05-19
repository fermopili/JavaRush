package com.javarush.task.task37.task3702;

import com.javarush.task.task37.task3702.female.FemaleFactory;
import com.javarush.task.task37.task3702.male.MaleFactory;

/**
 * Created by Administrator on 15.05.2017.
 */
public class FactoryProducer
{
    public static enum HumanFactoryType
    {
        MALE,
        FEMALE
    }

    public static AbstractFactory getFactory(HumanFactoryType type)
        {
        if (type == HumanFactoryType.MALE)
            return new MaleFactory ( );
        return new FemaleFactory ( );
        }
}
