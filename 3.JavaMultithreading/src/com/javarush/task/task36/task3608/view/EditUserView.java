package com.javarush.task.task36.task3608.view;

import com.javarush.task.task36.task3608.bean.User;
import com.javarush.task.task36.task3608.controller.Controller;
import com.javarush.task.task36.task3608.model.ModelData;

/**
 * Created by Administrator on 10.04.2017.
 */
public class EditUserView implements View
{
    private Controller controller;

    @Override
    public void refresh(ModelData modelData)
        {
        User user = modelData.getActiveUser ( );
        System.out.println ("User to be edited:");
        System.out.println ("\t" + user.toString ( ));
        System.out.println ("===================================================");
        }

    @Override
    public void setController(Controller controller)
        {
        this.controller = controller;
        }

    public void fireEventUserDeleted(long id)// 8
    {
    controller.onUserDelete (id);
    }


    public void fireEventUserChanged(String name, long id, int level) //должен находиться в классе EditUserView.
    {
    controller.onUserChange (name, id, level);
    }
}
