package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.Operation;
import com.javarush.task.task26.task2613.exception.InterruptOperationException;
import com.javarush.task.task26.task2613.exception.NotEnoughMoneyException;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 25.05.2017.
 */
public class CommandExecutor
{
    private final static Map<Operation, Command> allKnownCommandsMap = new HashMap<> ( );

    static
        {
            allKnownCommandsMap.put ( Operation.INFO, new InfoCommand ( ) );
            allKnownCommandsMap.put ( Operation.DEPOSIT, new DepositCommand ( ) );
            allKnownCommandsMap.put ( Operation.WITHDRAW, new WithdrawCommand ( ) );
            allKnownCommandsMap.put ( Operation.EXIT, new ExitCommand ( ) );
        }
    private CommandExecutor() {
    }
    public static final void execute(Operation operation) throws InterruptOperationException
        {
       Command command= allKnownCommandsMap.get ( operation );
        command.execute ();

        }
}
