package com.webshop.view;

import java.util.EventListener;

/**
 * Interface for handling login-related events
 * This follows the MVC pattern where the Controller implements this interface
 */
public interface LoginListener extends EventListener {
    
    /**
     * Handles login-related events
     * @param event The LoginEvent containing action details
     */
    void onLoginAction(LoginEvent event);
    
    // Default methods for backward compatibility (optional individual handlers)
    default void onLogin(String username, String password) {
        // Default empty implementation - use onLoginAction instead
    }
    
    default void onRegister() {
        // Default empty implementation - use onLoginAction instead
    }
}