package com.javarush.task.task28.task2810;

import com.javarush.task.task28.task2810.model.Provider;
import com.javarush.task.task28.task2810.vo.Vacancy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 23.05.2017.
 */
public class Controller
{
    private Provider[] providers;


    public Controller(Provider... providers)
        {
        if (providers == null)
            throw new IllegalArgumentException ( );
        if (providers.length == 0)
            throw new IllegalArgumentException ( );
        this.providers = providers;
        }

    @Override
    public String toString()
        {
        return "Controller{" +
                "providers=" + Arrays.toString ( providers ) +
                '}';
        }


    public void scan()
        {
        try
            {   List<Vacancy> vacancies = new ArrayList<> ( );
        for (Provider provider : providers)
            vacancies.addAll (  provider.getJavaVacancies ("java"));
       System.out.println (vacancies.size ());

            }
        catch (NullPointerException e)
            {  System.out.println(0);
            }


        }
}
