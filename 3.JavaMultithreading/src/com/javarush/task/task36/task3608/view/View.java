package com.javarush.task.task36.task3608.view;

import com.javarush.task.task36.task3608.controller.Controller;
import com.javarush.task.task36.task3608.model.ModelData;

/**
 * Created by Administrator on 04.04.2017.
 */
public interface View
{
    void refresh(ModelData modelData) ;
    void setController(Controller controller);
}
