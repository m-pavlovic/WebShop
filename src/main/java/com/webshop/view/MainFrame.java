package com.webshop.view;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainFrame extends JFrame {
    
    private ToolBarPanel toolBarPanel;
    private JPanel contentPanel;

    public MainFrame() {
        setTitle("WebShop");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        init();
        layoutComponents();
        activate();
    }

    private void init() {
        toolBarPanel = new ToolBarPanel();
        contentPanel = new JPanel();
        contentPanel.setBackground(Color.LIGHT_GRAY);
        contentPanel.add(new JLabel("Welcome to WebShop", JLabel.CENTER));
    }

    private void layoutComponents() {
        setLayout(new BorderLayout());
        add(toolBarPanel, BorderLayout.NORTH);
        add(contentPanel, BorderLayout.CENTER);
    }

    private void activate() {
        setVisible(true);
    }
    
    /**
     * Gets the toolbar panel for setting up listeners
     * @return The ToolBarPanel instance
     */
    public ToolBarPanel getToolBarPanel() {
        return toolBarPanel;
    }
    
    /**
     * Gets the content panel for updating main content
     * @return The main content panel
     */
    public JPanel getContentPanel() {
        return contentPanel;
    }

}
