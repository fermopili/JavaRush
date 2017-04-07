package com.javarush.task.LecturesExamples.ApaterTwo;

/**
 * Created by Administrator on 26.03.2017.
 */
public class SequenceGenerator
{

    private Generator generator;

    public SequenceGenerator(Generator generator)
        {
        super ( );
        this.generator = generator;
        }

    public int[] generate(int length)
        {
        int ret[] = new int[length];

        for (int i = 0; i < length; i++)
            {
                ret[i] = generator.next ( )+55;
            }

        return ret;
        }
}