package com.javarush.task.LecturesExamples.Adapter;

/**
 * Created by Administrator on 26.03.2017.
 */
public class Solution

{
    public static void main(String[] args)
        {
        AlphaList listAlpha = AlphaListManager.createList ( );
        BetaList  listBeta  = new ListAdapter (listAlpha);
        BetaSaveManager.saveList (listBeta);
        }
}
//////////////////////////////////////////////////////////
