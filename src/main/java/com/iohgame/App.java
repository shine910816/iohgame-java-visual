package com.iohgame;

import com.iohgame.visual.property.VisualWindow;

/**
 * Hello world!
 */
public class App
{
    public static void main(String[] args)
    {
        VisualWindow win = VisualWindow.getInstance("Hello World!");
        win.disp();
    }
}
