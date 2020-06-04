package com.iohgame.visual.property;

import javax.swing.JLabel;

public class VisualLabel extends JLabel
{
    private static final long serialVersionUID = 1L;

    public VisualLabel()
    {
        super();
    }

    public static VisualLabel getInstance()
    {
        return new VisualLabel();
    }
}
