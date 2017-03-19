package com.javarush.task.task14.task1408;

/**
 * Created by Administrator on 16.03.2017.
 */
public class MoldovanHen extends Hen
{
    @Override
    int getCountOfEggsPerMonth()
        {
        return 20;
        }
    public String getDescription()
        {
        return  super.getDescription()+" Моя страна - "+Country.MOLDOVA+". Я несу "+getCountOfEggsPerMonth()+" яиц в месяц.";
        }
}
