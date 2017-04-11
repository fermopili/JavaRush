package com.javarush.task.task36.task3608.model;

import com.javarush.task.task36.task3608.bean.User;

import java.util.List;

/**
 * Created by Administrator on 04.04.2017.
 */
public class ModelData
{
    private  User       activeUser;
    List<User> users;
    private boolean displayDeletedUserList;

    public boolean isDisplayDeletedUserList()
        {
        return displayDeletedUserList;
        }

    public void setDisplayDeletedUserList(boolean displayDeletedUserList)
        {
        this.displayDeletedUserList = displayDeletedUserList;
        }

    public void setUsers(List<User> users)
        {
        this.users = users;
        }

    public List<User> getUsers()
        {
        return users;
        }

    public User getActiveUser()
        {
        return activeUser;
        }

    public void setActiveUser(User activeUser)
        {
        this.activeUser = activeUser;
        }
}
