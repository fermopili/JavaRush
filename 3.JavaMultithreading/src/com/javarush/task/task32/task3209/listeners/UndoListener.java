package com.javarush.task.task32.task3209.listeners;

import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.UndoManager;
import javax.swing.undo.UndoableEdit;

/**
 * Created by Administrator on 26.04.2017.
 */
public class UndoListener implements UndoableEditListener

{
  private   UndoManager undoManager;

    public UndoListener(UndoManager undoManager)
        {
        this.undoManager = undoManager;
        }

    @Override
    public void undoableEditHappened(UndoableEditEvent e)
        {
        UndoableEdit undoableEdit=e.getEdit ();
        undoManager.addEdit (undoableEdit);
        }

}
