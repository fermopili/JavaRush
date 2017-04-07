package com.javarush.task.LecturesExamples.Adapter;

/**
 * Created by Administrator on 25.03.2017.
 */
interface AlphaList
{
    void add(int value);

    void insert(int index, int value);

    int get(int index);

    void set(int index, int value);

    int count();

    void remove(int index);
}