package com.javarush.task.task36.task3601;

import java.util.List;

/**
 * Created by Administrator on 19.05.2017.
 */
public class Model
{
    Service service = new Service ( );

    public List<String> getStringDataList()
        {
        return service.getData ( );
        }
}
