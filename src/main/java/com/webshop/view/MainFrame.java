package com.webshop.view;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame extends JFrame {
    
    private ToolBarPanel toolBarPanel;
    private JPanel contentPanel;
    private HomePanel homePanel;
    private CartPanel cartPanel;
    private ProfilePanel profilePanel;
    private ContactPanel contactPanel;

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
        
        // Initialize all content panels
        homePanel = new HomePanel();
        cartPanel = new CartPanel();
        profilePanel = new ProfilePanel();
        contactPanel = new ContactPanel();
        
        // Initialize content panel with BorderLayout for panel switching
        contentPanel = new JPanel(new BorderLayout());
        contentPanel.setBackground(Color.LIGHT_GRAY);
        
        // Show home panel by default
        showPanel(homePanel);
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
     * Gets the home panel for setting up listeners
     * @return The HomePanel instance
     */
    public HomePanel getHomePanel() {
        return homePanel;
    }
    
    /**
     * Gets the content panel for updating main content
     * @return The main content panel
     */
    public JPanel getContentPanel() {
        return contentPanel;
    }
    
    /**
     * Shows the specified panel in the content area
     * @param panel The panel to display
     */
    private void showPanel(JPanel panel) {
        contentPanel.removeAll();
        contentPanel.add(panel, BorderLayout.CENTER);
        contentPanel.revalidate();
        contentPanel.repaint();
    }
    
    /**
     * Shows the home panel
     */
    public void showHomePanel() {
        showPanel(homePanel);
        setTitle("WebShop - Home");
    }
    
    /**
     * Shows the cart panel
     */
    public void showCartPanel() {
        showPanel(cartPanel);
        setTitle("WebShop - Shopping Cart");
    }
    
    /**
     * Shows the profile panel
     */
    public void showProfilePanel() {
        showPanel(profilePanel);
        setTitle("WebShop - Profile");
    }
    
    /**
     * Shows the contact panel
     */
    public void showContactPanel() {
        showPanel(contactPanel);
        setTitle("WebShop - Contact Us");
    }

}
