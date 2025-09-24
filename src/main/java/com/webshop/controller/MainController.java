package com.webshop.controller;

import com.webshop.view.MainFrame;
import com.webshop.view.ToolBarEvent;
import com.webshop.view.ToolBarListener;
import com.webshop.view.HomePanelEvent;
import com.webshop.view.HomePanelListener;

/**
 * Main controller for the WebShop application following MVC pattern
 * Handles navigation events from the toolbar and home panel interactions
 */
public class MainController implements ToolBarListener, HomePanelListener {
    
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
    
    // HomePanelListener implementation
    
    @Override
    public void onHomePanelAction(HomePanelEvent event) {
        System.out.println("HomePanelEvent received: " + event);
        
        switch (event.getAction()) {
            case SEARCH_PRODUCTS:
                onSearchProducts(event.getData());
                break;
            case CATEGORY_SELECTED:
                onCategorySelected(event.getData());
                break;
            case ADD_TO_CART:
                onAddToCart(event.getData());
                break;
            case PROCEED_TO_CHECKOUT:
                onProceedToCheckout();
                break;
            case PRODUCT_SELECTED:
                onProductSelected(event.getData());
                break;
            default:
                System.out.println("Unknown home panel action: " + event.getAction());
        }
    }
    
    @Override
    public void onSearchProducts(String searchText) {
        System.out.println("Search initiated for: '" + searchText + "'");
        showMessage("Searching for: " + searchText);
        // TODO: Implement product search logic
    }
    
    @Override
    public void onCategorySelected(String categoryName) {
        System.out.println("Category selected: " + categoryName);
        showMessage("Category: " + categoryName);
        // TODO: Implement category filtering logic
    }
    
    @Override
    public void onAddToCart(String productId) {
        System.out.println("Adding to cart: " + productId);
        showMessage("Added " + productId + " to cart");
        // TODO: Implement add to cart logic
    }
    
    @Override
    public void onProceedToCheckout() {
        System.out.println("Proceeding to checkout");
        showMessage("Checkout initiated");
        // TODO: Implement checkout logic
    }
    
    @Override
    public void onProductSelected(String productId) {
        System.out.println("Product selected: " + productId);
        showMessage("Viewing: " + productId);
        // TODO: Implement product detail view
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
