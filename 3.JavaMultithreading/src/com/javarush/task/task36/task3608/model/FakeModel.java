package com.javarush.task.task36.task3608.model;

import com.javarush.task.task36.task3608.bean.User;

import java.util.ArrayList;

/**
 * Created by Administrator on 04.04.2017.
 */
public class FakeModel implements Model
{
    private ModelData modelData = new ModelData ( );

    @Override
    public ModelData getModelData()
        {
        return modelData;
        }

    @Override
    public void loadUsers()
        {
        ArrayList<User> users = new ArrayList<User> ( );

        users.add (new User ("AAA", 1, 1));
        users.add (new User ("BBB", 11, 1));
        users.add (new User ("CCC", 111, 1));
        modelData.setUsers (users);


        }
}


