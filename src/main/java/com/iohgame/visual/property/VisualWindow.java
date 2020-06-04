package com.iohgame.visual.property;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class VisualWindow extends JFrame
{
    private static final long serialVersionUID = 1L;
    private VisualScrollPane m_scroll = null;

    private VisualWindow(String title, int width, int height, boolean resizeAble)
    {
        super(title);
        setSize(width, height);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((dim.width - width) / 2, (dim.height - height) / 2);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(resizeAble);
    }

    public VisualWindow addComponent(VisualPanel panel)
    {
        add(panel);
        return this;
    }

    public VisualWindow addScrollPane(VisualPanel panel)
    {
        m_scroll = VisualScrollPane.getInstance(panel);
        m_scroll.getVerticalScrollBar().setUnitIncrement(25);
        m_scroll.getHorizontalScrollBar().setUnitIncrement(25);
        add(m_scroll);
        return this;
    }

    public void disp()
    {
        setVisible(true);
    }

    public void undisp()
    {
        setVisible(false);
    }

    public static VisualWindow getInstance(String title, int width, int height, boolean resizeAble)
    {
        return new VisualWindow(title, width, height, resizeAble);
    }

    public static VisualWindow getInstance(String title)
    {
        return new VisualWindow(title, 1280, 720, false);
    }
}
