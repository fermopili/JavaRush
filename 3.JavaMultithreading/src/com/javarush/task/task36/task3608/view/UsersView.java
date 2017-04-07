package com.javarush.task.task36.task3608.view;

import com.javarush.task.task36.task3608.bean.User;
import com.javarush.task.task36.task3608.controller.Controller;
import com.javarush.task.task36.task3608.model.ModelData;

import java.util.List;

/**
 * Created by Administrator on 04.04.2017.
 */
public class UsersView implements View
{

  //  Метод refresh класса UsersView должен быть реализован согласно условию.
    private Controller controller;
    private ModelData modelData;
    @Override
    public void refresh(ModelData modelData)
        {
         this.modelData=modelData;
         System.out.println ("All users:");
        List<User> users = modelData.getUsers ( );
        for (User u : users)
            {
                System.out.println ("\t"+u);
            }
        System.out.println ("==================================================");

        }

    @Override
    public void setController(Controller controller)
        {
        this.controller = controller;
        }

    public  void fireEventShowAllUsers()
        {
        controller.onShowAllUsers ();
        }

}
