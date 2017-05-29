package com.javarush.task.task38.task3811;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by Administrator on 23.05.2017.
 */
@Retention(value= RetentionPolicy.RUNTIME )
@Target(ElementType.TYPE)
public @interface Ticket
{
    public enum Priority
    {
        LOW,
        MEDIUM,
        HIGH
    }


    Priority priority() default Priority.MEDIUM;

    String createdBy() default "Amigo";

    String[] tags() default {};
}
