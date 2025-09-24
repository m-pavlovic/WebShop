package com.webshop.view;

/**
 * Listener interface for registration events
 * Implements MVC pattern by decoupling view from controller logic
 */
public interface RegistrationListener {
    
    /**
     * Called when user attempts to register a new account
     * @param registrationData The user's registration information
     */
    void onRegisterUser(RegistrationData registrationData);
    
    /**
     * Called when user cancels the registration process
     */
    void onCancelRegistration();
}