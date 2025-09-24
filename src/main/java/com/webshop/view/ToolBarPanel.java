package com.webshop.view;
import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JToolBar;

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

        this.add(toolBar);
        
    }

    private void layoutComponents() {
        this.setLayout(new BorderLayout());
        this.add(toolBar, BorderLayout.NORTH);
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
