package com.webshop.controller;

import com.webshop.view.MainFrame;
import com.webshop.view.ToolBarEvent;
import com.webshop.view.ToolBarListener;

/**
 * Main controller for the WebShop application following MVC pattern
 * Handles navigation events from the toolbar and coordinates between View and Model
 */
public class MainController implements ToolBarListener {
    
    private MainFrame mainFrame;
    
    /**
     * Constructor for MainController
     * @param mainFrame The main view frame
     */
    public MainController(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
    }
    
    /**
     * Sets the main frame reference
     * @param mainFrame The main view frame
     */
    public void setMainFrame(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
    }
    
    @Override
    public void onToolBarAction(ToolBarEvent event) {
        System.out.println("ToolBarEvent received: " + event);
        
        switch (event.getActionType()) {
            case HOME:
                onHomeClicked();
                break;
            case CART:
                onCartClicked();
                break;
            case PROFILE:
                onProfileClicked();
                break;
            case CONTACT:
                onContactClicked();
                break;
            default:
                System.out.println("Unknown toolbar action: " + event.getActionType());
        }
    }
    
    // Individual action handlers (using default interface methods)
    
    @Override
    public void onHomeClicked() {
        System.out.println("Navigation: HOME clicked");
        // Business logic for home navigation
        if (mainFrame != null) {
            mainFrame.showHomePanel();
        }
    }
    
    @Override
    public void onCartClicked() {
        System.out.println("Navigation: CART clicked");
        // Business logic for cart navigation
        if (mainFrame != null) {
            mainFrame.showCartPanel();
        }
    }
    
    @Override
    public void onProfileClicked() {
        System.out.println("Navigation: PROFILE clicked");
        // Business logic for profile navigation
        if (mainFrame != null) {
            mainFrame.showProfilePanel();
        }
    }
    
    @Override
    public void onContactClicked() {
        System.out.println("Navigation: CONTACT clicked");
        // Business logic for contact navigation
        if (mainFrame != null) {
            mainFrame.showContactPanel();
        }
    }
    
    // Helper methods
    
    /**
     * Shows a message to the user (temporary implementation)
     * @param message The message to display
     */
    private void showMessage(String message) {
        if (mainFrame != null) {
            // For now, just update window title as demonstration
            mainFrame.setTitle("WebShop - " + message);
        }
    }
    
    /**
     * Initialize the controller with the view components
     */
    public void initialize() {
        // Set up initial state
        if (mainFrame != null) {
            mainFrame.setTitle("WebShop - Ready");
        }
        System.out.println("MainController initialized");
    }
}
