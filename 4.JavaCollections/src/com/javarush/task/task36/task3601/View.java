package com.javarush.task.task36.task3601;

/**
 * Created by Administrator on 19.05.2017.
 */
public class View
{ Controller controller=new Controller ();
    public void fireEventShowData()
        {
        System.out.println (controller.onDataListShow ( ));
        }
}
