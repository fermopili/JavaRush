package com.javarush.task.task32.task3212;

import com.javarush.task.task32.task3212.service.Service;

/* 
Service Locator
*/
//  https://www.tutorialspoint.com/design_pattern/service_locator_pattern.htm
public class Solution {
    public static void main(String[] args) {
        Service service = ServiceLocator.getService("EJBService");
        service.execute();
        System.out.println();
        service = ServiceLocator.getService("JMSService");
        service.execute();
        System.out.println();
        service = ServiceLocator.getService("EJBService");
        service.execute();
        System.out.println();
        service = ServiceLocator.getService("JMSService");
        service.execute();

    }

}

