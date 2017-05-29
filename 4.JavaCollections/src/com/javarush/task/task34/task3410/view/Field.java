package com.javarush.task.task34.task3410.view;

import com.javarush.task.task34.task3410.controller.EventListener;
import com.javarush.task.task34.task3410.model.Direction;
import com.javarush.task.task34.task3410.model.GameObject;
import com.javarush.task.task34.task3410.model.GameObjects;
import com.javarush.task.task34.task3410.model.Model;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Set;


/**
 * Created by Administrator on 26.05.2017.
 */
public class Field extends JPanel
{
    private View          view;
    private EventListener eventListener;

    public Field(View view)
        {

        this.view = view;
        this.addKeyListener(new KeyHandler());
        this.setFocusable(true);
        }

    public void setEventListener(EventListener eventListener)
        {
        this.eventListener = eventListener;
        }

    public void paint(Graphics g)
        {
        g.setColor ( Color.BLACK );
        g.fillRect ( 0, 0, Model.WIDTH_WINDOW, Model.HEIGHT_WINDOW );
        GameObjects     gameObjects = view.getGameObjects ( );
        Set<GameObject> set         = gameObjects.getAll ( );
        for (GameObject gameObject : set)
            gameObject.draw ( g );
        }

    public    class KeyHandler extends KeyAdapter
    {
        @Override
        public void keyPressed(KeyEvent e)
            {
            switch (e.getKeyCode ( ))
                {
                case KeyEvent.VK_LEFT:eventListener.move ( Direction.LEFT);
                    break;
                case KeyEvent.VK_RIGHT:eventListener.move ( Direction.RIGHT);
                    break;
                case  KeyEvent.VK_UP:eventListener.move ( Direction.UP);
                    break;
                case  KeyEvent.VK_DOWN:eventListener.move ( Direction.DOWN);
                    break;
                case  KeyEvent.VK_R:eventListener.restart ();
                    break;
                case  KeyEvent.VK_X:System.exit(0);
                    break;
                }
            }
    }
}
