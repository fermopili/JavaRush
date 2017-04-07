package com.javarush.task.task36.task3608.model;

import com.javarush.task.task36.task3608.bean.User;

import java.util.List;

/**
 * Created by Administrator on 04.04.2017.
 */
public class ModelData
{
    private List<User> users;
    public void setUsers(List<User> users)
        {
        this.users = users;
        }

    public List<User> getUsers()
        {
        return users;
        }


}
