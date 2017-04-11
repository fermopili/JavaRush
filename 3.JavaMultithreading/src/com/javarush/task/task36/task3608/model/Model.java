package com.javarush.task.task36.task3608.model;

/**
 * Created by Administrator on 04.04.2017.
 */
public interface Model
{
    ModelData getModelData();
    void loadUsers();
    void loadDeletedUsers();
    void loadUserById(long userId);
    void deleteUserById(long userId);/// 8
    void changeUserData(String name, long id, int level);
}
