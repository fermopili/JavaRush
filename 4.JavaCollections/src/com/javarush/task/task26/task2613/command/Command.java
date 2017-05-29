package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.exception.InterruptOperationException;
import com.javarush.task.task26.task2613.exception.NotEnoughMoneyException;

/**
 * Created by Administrator on 25.05.2017.
 */
interface Command
{
    void execute()  throws InterruptOperationException;
}
