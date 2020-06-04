package com.iohgame.visual.property;

import javax.swing.JScrollPane;

public class VisualScrollPane extends JScrollPane
{
    private static final long serialVersionUID = 1L;

    private VisualScrollPane(VisualPanel center)
    {
        super(center);
    }

    public static VisualScrollPane getInstance(VisualPanel center)
    {
        return new VisualScrollPane(center);
    }
}
