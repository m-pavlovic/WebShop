package com.webshop.view;

import java.util.EventListener;

/**
 * Interface for handling toolbar navigation events
 * This follows the MVC pattern where the Controller implements this interface
 */
public interface ToolBarListener extends EventListener {

    /**
     * Handles toolbar action events
     * @param event The ToolBarEvent containing action details
     */
    void onToolBarAction(ToolBarEvent event);

    // Default methods for backward compatibility (optional individual handlers)
    default void onHomeClicked() {
        // Default empty implementation
    }

    default void onCartClicked() {
        // Default empty implementation
    }

    default void onProfileClicked() {
        // Default empty implementation
    }

    default void onContactClicked() {
        // Default empty implementation
    }
}
