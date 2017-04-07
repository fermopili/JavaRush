package com.javarush.task.LecturesExamples.ApaterTwo;

import java.util.Random;

/**
 * Created by Administrator on 26.03.2017.
 */
    // Использование
    public class AdapterExample {

        public static void main(String[] args) {

        RandomGeneratorAdapter adapter = new RandomGeneratorAdapter();
        System.out.println( adapter.next ());
        SequenceGenerator generator = new SequenceGenerator(adapter);

        for (int i: generator.generate(5)) {
            System.out.print(i + " ");
        }
        }
    }

