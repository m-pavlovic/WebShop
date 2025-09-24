package com.webshop.view;

import java.util.EventListener;

/**
 * Interface for handling HomePanel events
 * This follows the MVC pattern where the Controller implements this interface
 */
public interface HomePanelListener extends EventListener {
    
    /**
     * Handles home panel action events
     * @param event The HomePanelEvent containing action details
     */
    void onHomePanelAction(HomePanelEvent event);
    
    // Default methods for backward compatibility (optional individual handlers)
    default void onSearchProducts(String searchText) {
        // Default empty implementation - use onHomePanelAction instead
    }
    
    default void onCategorySelected(String categoryName) {
        // Default empty implementation - use onHomePanelAction instead
    }
    
    default void onAddToCart(String productId) {
        // Default empty implementation - use onHomePanelAction instead
    }
    
    default void onProceedToCheckout() {
        // Default empty implementation - use onHomePanelAction instead
    }
    
    default void onProductSelected(String productId) {
        // Default empty implementation - use onHomePanelAction instead
    }
}