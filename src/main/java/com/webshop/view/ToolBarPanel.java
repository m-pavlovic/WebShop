package com.webshop.view;
import java.awt.*;

import javax.swing.*;
import static javax.swing.BorderFactory.createLineBorder;

public class ToolBarPanel extends JPanel {

    private JToolBar toolBar;
    private ToolBarListener toolBarListener;
    private JButton homeButton;
    private JButton cartButton;
    private JButton profileButton;
    private JButton contactButton;

    public ToolBarPanel() {
        init();
        layoutComponents();
        activate();
    }

    private void init() {
        toolBar = new JToolBar();
        homeButton = new JButton("HOME");
        cartButton = new JButton("CART");
        profileButton = new JButton("PROFILE");
        contactButton = new JButton("CONTACT");

        toolBar.add(homeButton);
        toolBar.add(cartButton);
        toolBar.add(profileButton);
        toolBar.add(contactButton);

        // Set the toolbar panel to fill available space
        this.setPreferredSize(new Dimension(800, 60));
        this.add(toolBar);
    }

    private void layoutComponents() {
        this.setLayout(new BorderLayout());
        this.add(toolBar, BorderLayout.NORTH);
        toolBar.setFloatable(false);
        
        toolBar.setLayout(new GridLayout(1, 4, 5, 0));

        // Set button properties
        homeButton.setFocusable(false);
        cartButton.setFocusable(false);
        profileButton.setFocusable(false);
        contactButton.setFocusable(false);
        
        homeButton.setBackground(new Color(135, 206, 250));
        cartButton.setBackground(new Color(135, 206, 250));
        profileButton.setBackground(new Color(135, 206, 250));
        contactButton.setBackground(new Color(135, 206, 250));
        

        Color darkBlue = new Color(0, 0, 139);
        homeButton.setBorder(createLineBorder(darkBlue, 2));
        cartButton.setBorder(createLineBorder(darkBlue, 2));
        profileButton.setBorder(createLineBorder(darkBlue, 2));
        contactButton.setBorder(createLineBorder(darkBlue, 2));
        
        
        Dimension buttonSize = new Dimension(150, 50);
        homeButton.setPreferredSize(buttonSize);
        cartButton.setPreferredSize(buttonSize);
        profileButton.setPreferredSize(buttonSize);
        contactButton.setPreferredSize(buttonSize);
        
    
        Font buttonFont = new Font("Arial", Font.BOLD, 14);
        homeButton.setFont(buttonFont);
        cartButton.setFont(buttonFont);
        profileButton.setFont(buttonFont);
        contactButton.setFont(buttonFont);
        
        
        homeButton.setOpaque(true);
        cartButton.setOpaque(true);
        profileButton.setOpaque(true);
        contactButton.setOpaque(true);
    }

    private void activate() {

        homeButton.addActionListener(e -> {
            if (toolBarListener != null) {
                ToolBarEvent event = new ToolBarEvent(ToolBarEvent.ActionType.HOME, homeButton);
                toolBarListener.onToolBarAction(event);
            }
        });

        cartButton.addActionListener(e -> {
            if (toolBarListener != null) {
                ToolBarEvent event = new ToolBarEvent(ToolBarEvent.ActionType.CART, cartButton);
                toolBarListener.onToolBarAction(event);
            }
        });

        profileButton.addActionListener(e -> {
            if (toolBarListener != null) {
                ToolBarEvent event = new ToolBarEvent(ToolBarEvent.ActionType.PROFILE, profileButton);
                toolBarListener.onToolBarAction(event);
            }
        });

        contactButton.addActionListener(e -> {
            if (toolBarListener != null) {
                ToolBarEvent event = new ToolBarEvent(ToolBarEvent.ActionType.CONTACT, contactButton);
                toolBarListener.onToolBarAction(event);
            }
        });
    }
    
    /**
     * Sets the listener for toolbar events (typically the Controller)
     * @param listener The ToolBarListener implementation
     */
    public void setToolBarListener(ToolBarListener listener) {
        this.toolBarListener = listener;
    }

}
