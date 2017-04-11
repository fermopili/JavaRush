package com.javarush.task.task36.task3608.model;

import com.javarush.task.task36.task3608.bean.User;
import com.javarush.task.task36.task3608.model.service.UserService;
import com.javarush.task.task36.task3608.model.service.UserServiceImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 10.04.2017.
 */
public class MainModel implements Model
{
    private ModelData   modelData   = new ModelData ( );
    private UserService userService = new UserServiceImpl ( );

    @Override
    public ModelData getModelData()
        {
        return modelData;
        }

    @Override
    public void loadUsers()
        {
        List<User> users = new ArrayList<User> ( );
     //   modelData.setDisplayDeletedUserList (false);
      //  users = userService.getUsersBetweenLevels (1, 100);
        users= getAllUsers();// 8
        modelData.setUsers (users);
        }

    @Override
    public void loadDeletedUsers()
        {

        List<User> users = new ArrayList<User> ( );
        modelData.setDisplayDeletedUserList (true);
        users = userService.getAllDeletedUsers ( );
        modelData.setUsers (users);
        }

    @Override
    public void loadUserById(long userId)
        {
        User user = userService.getUsersById (userId);
        modelData.setActiveUser (user);
        }

   private  List<User> getAllUsers()///// 8
    {
    List<User> users = new ArrayList<User> ( );
    users = userService.getUsersBetweenLevels (1,100);
    users= userService.filterOnlyActiveUsers (users);
    return users;
    }

    public void deleteUserById(long id) /// 8
    {
    userService.deleteUser (id);
    List<User> users = new ArrayList<User> ( );
    users= getAllUsers();// 8
    modelData.setUsers (users);
    }

    @Override
    public void changeUserData(String name, long id, int level)
        {
        userService.createOrUpdateUser (name,  id,  level);
        List<User> users = new ArrayList<User> ( );
        users= getAllUsers();// 8
        modelData.setUsers (users);
        }
}


