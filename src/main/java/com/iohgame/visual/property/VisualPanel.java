package com.iohgame.visual.property;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class VisualPanel extends JPanel
{
    private static final long serialVersionUID = 1L;
    private GridBagConstraints m_gbc = null;

    private VisualPanel()
    {
        super();
    }

    private VisualPanel(LayoutManager layout)
    {
        super(layout);
        if (layout.getClass().getName() == "java.awt.GridBagLayout")
        {
            m_gbc = new GridBagConstraints();
            m_gbc.fill = GridBagConstraints.BOTH;
            m_gbc.anchor = GridBagConstraints.NORTHWEST;
        }
    }

    public VisualPanel setCons(int gridx, int gridy, int gridwidth, int gridheight, double weightx, double weighty)
    {
        m_gbc.gridx = gridx;
        m_gbc.gridy = gridy;
        m_gbc.gridwidth = gridwidth;
        m_gbc.gridheight = gridheight;
        m_gbc.weightx = weightx;
        m_gbc.weighty = weighty;
        return this;
    }

    public GridBagConstraints constraints()
    {
        return m_gbc;
    }

    public void addTextLabel(String text)
    {
        JLabel label = new JLabel(text);
        if (m_gbc != null)
        {
            add(label, m_gbc);
        }
        else
        {
            add(label);
        }
    }

    public static VisualPanel getFlowLayoutPanel()
    {
        return new VisualPanel();
    }

    public static VisualPanel getBorderLayoutPanel()
    {
        return new VisualPanel(new BorderLayout());
    }

    public static VisualPanel getGridLayoutPanel(int rows, int cols)
    {
        return new VisualPanel(new GridLayout(rows, cols));
    }

    public static VisualPanel getGridBagLayoutPanel()
    {
        return new VisualPanel(new GridBagLayout());
    }
}
