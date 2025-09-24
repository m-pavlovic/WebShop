package com.webshop.view;

import javax.swing.*;
import java.time.LocalDateTime;

/**
 * Event class for HomePanel interactions
 * Follows the same pattern as ToolBarEvent and LoginEvent
 */
public class HomePanelEvent {
    
    public enum ActionType {
        SEARCH_PRODUCTS,
        CATEGORY_SELECTED,
        ADD_TO_CART,
        PROCEED_TO_CHECKOUT,
        PRODUCT_SELECTED
    }
    
    private final ActionType action;
    private final String data; // Search text, category name, product ID, etc.
    private final JComponent source;
    private final LocalDateTime timestamp;
    private final String description;
    
    // Constructor for actions with data (search, category selection, product)
    public HomePanelEvent(ActionType action, String data, JComponent source) {
        this.action = action;
        this.data = data;
        this.source = source;
        this.timestamp = LocalDateTime.now();
        this.description = "Home panel action: " + action + (data != null ? " - " + data : "");
    }
    
    // Constructor for simple actions (checkout)
    public HomePanelEvent(ActionType action, JComponent source) {
        this(action, null, source);
    }
    
    // Getters
    public ActionType getAction() {
        return action;
    }
    
    public String getData() {
        return data;
    }
    
    public JComponent getSource() {
        return source;
    }
    
    public LocalDateTime getTimestamp() {
        return timestamp;
    }
    
    public String getDescription() {
        return description;
    }
    
    @Override
    public String toString() {
        return "HomePanelEvent{" +
                "action='" + action + '\'' +
                ", data='" + data + '\'' +
                ", timestamp=" + timestamp +
                ", description='" + description + '\'' +
                '}';
    }
}