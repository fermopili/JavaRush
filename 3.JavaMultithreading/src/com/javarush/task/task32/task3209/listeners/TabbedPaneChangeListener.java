package com.javarush.task.task32.task3209.listeners;

import com.javarush.task.task32.task3209.View;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * Created by Administrator on 25.04.2017.
 */
public class TabbedPaneChangeListener implements ChangeListener
{   private View view;

    public TabbedPaneChangeListener(View view)
        {
        this.view = view;
        }

    @Override
    public void stateChanged(ChangeEvent e)
        {
        view.selectedTabChanged ();
        }
}
