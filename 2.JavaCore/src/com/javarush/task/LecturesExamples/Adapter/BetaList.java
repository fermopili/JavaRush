package com.javarush.task.LecturesExamples.Adapter;

/**
 * Created by Administrator on 26.03.2017.
 */
interface BetaList
{
    int getValue(int index);

    void setValue(int index, int value);

    int getSize();

    void setSize(int newSize);
}

class BetaSaveManager
{
    public static void saveList(BetaList list)
        {
        //какой-то код по сохранению объекта
        //типа BetaList в файл на диске
        }
}