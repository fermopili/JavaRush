package com.javarush.task.task14.task1408;

/**
 * Created by Administrator on 16.03.2017.
 */
public class UkrainianHen extends Hen
{
    @Override
    int getCountOfEggsPerMonth()
        {
        return 2000;
        }
    public String getDescription()
        {
        return  super.getDescription()+" Моя страна - "+Country.UKRAINE+". Я несу "+getCountOfEggsPerMonth()+" яиц в месяц.";
        }
}
