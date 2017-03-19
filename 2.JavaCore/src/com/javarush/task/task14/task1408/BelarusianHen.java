package com.javarush.task.task14.task1408;

/**
 * Created by Administrator on 16.03.2017.
 */
public class BelarusianHen extends  Hen
{
    @Override
    int getCountOfEggsPerMonth()
        {
        return 10;
        }
    public String getDescription()
        {
        return  super.getDescription()+" Моя страна - "+Country.BELARUS+". Я несу "+getCountOfEggsPerMonth()+" яиц в месяц.";
        }
}
