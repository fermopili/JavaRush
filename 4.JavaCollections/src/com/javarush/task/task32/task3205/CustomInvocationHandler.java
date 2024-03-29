package com.javarush.task.task32.task3205;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by Administrator on 08.05.2017.
 */
public class CustomInvocationHandler implements InvocationHandler
{

    private SomeInterfaceWithMethods original;

    public CustomInvocationHandler(SomeInterfaceWithMethods original)
        {
        this.original = original;
        }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable
        {
        System.out.println (method.getName ( ) + " in");
        Object result = method.invoke (original, args);
        System.out.println (method.getName ( ) + " out");
        return result;
        }
}