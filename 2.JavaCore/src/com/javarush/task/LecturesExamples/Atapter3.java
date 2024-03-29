package com.javarush.task.LecturesExamples;

/**
 * Created by Administrator on 26.03.2017.
 */
public class Atapter3
{
    public interface Generator
    {
        public int next();
    }

    static  public class RandomGenerator
    {
        public int getRandomNumber()
            {
            return 4;
            }
    }

    static public class RandomGeneratorAdapter extends RandomGenerator implements Generator
    {
        @Override
        public int next()
            {
            return getRandomNumber ( );
            }
    }

    static public class SequenceGenerator
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
                    ret[i] = generator.next ( );
                }
            return ret;
            }
    }

    // Использование
    public static void main(String[] args)
        {
        RandomGeneratorAdapter adapter   = new RandomGeneratorAdapter ( );
        SequenceGenerator      generator = new SequenceGenerator (adapter);
        for (int i : generator.generate (10))
            {
                System.out.print (i + " ");
            }
        }
}