package com.javarush.task.task26.task2613;

/**
 * Created by Administrator on 25.05.2017.
 */
public enum Operation
{
    INFO,
    DEPOSIT,
    WITHDRAW,
    EXIT;

    public static Operation getAllowableOperationByOrdinal(Integer i)
        {
        switch (i)
            {
            case 1:
                return INFO;
            case 2:
                return DEPOSIT;
            case 3:
                return WITHDRAW;
            case 4:
                return EXIT;
            default:
                throw new IllegalArgumentException ( );
            }
        }
}

