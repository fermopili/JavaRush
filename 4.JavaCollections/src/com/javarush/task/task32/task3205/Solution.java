package com.javarush.task.task32.task3205;

import java.lang.reflect.Proxy;

/*
Создание прокси-объекта
*/
public class Solution
{


    public static void main(String[] args)
        {
        SomeInterfaceWithMethods obj = getProxy ( );
        obj.stringMethodWithoutArgs ( );
        obj.voidMethodWithIntArg (1);
        obj.YYY ();
     //   obj.voidMethodWithoutArgs ();

        /* expected output
        stringMethodWithoutArgs in
        inside stringMethodWithoutArgs
        stringMethodWithoutArgs out
        voidMethodWithIntArg in
        inside voidMethodWithIntArg
        inside voidMethodWithoutArgs
        voidMethodWithIntArg out
        */
        }

    public static SomeInterfaceWithMethods getProxy()
        {
        SomeInterfaceWithMethods origin = new SomeInterfaceWithMethodsImpl ( );
        SomeInterfaceWithMethods proxyObj = (SomeInterfaceWithMethods) Proxy.newProxyInstance (
                origin.getClass ( ).getClassLoader ( ), // class loader
                origin.getClass ( ).getInterfaces ( ), // interfaces
                new CustomInvocationHandler (origin)
        );
        return proxyObj;
        }
}