package com.webshop.controller;

import com.webshop.view.LoginFrame;
import com.webshop.view.LoginListener;
import com.webshop.view.LoginEvent;
import com.webshop.view.MainFrame;

/**
 * Controller for handling login/authentication logic
 * Manages the flow between LoginFrame and MainFrame
 */
public class LoginController implements LoginListener {
    
    private LoginFrame loginFrame;
    private MainFrame mainFrame;
    private MainController mainController;
    
    /**
     * Constructor for LoginController
     * @param loginFrame The login view
     */
    public LoginController(LoginFrame loginFrame) {
        this.loginFrame = loginFrame;
    }
    
    @Override
    public void onLoginAction(LoginEvent event) {
        System.out.println("LoginEvent received: " + event);
        
        switch (event.getActionType()) {
            case LOGIN_ATTEMPT:
                handleLogin(event);
                break;
            case REGISTER_REQUEST:
                handleRegister(event);
                break;
            default:
                System.out.println("Unknown login action: " + event.getActionType());
        }
    }
    
    /**
     * Handles login attempts
     * @param event The login event with credentials
     */
    private void handleLogin(LoginEvent event) {
        System.out.println("Login attempt: " + event.getUsername());
        
        if (!event.hasCredentials()) {
            loginFrame.showError("Please enter both username and password");
            return;
        }
        
        // Simulate authentication
        if (authenticateUser(event.getUsername(), event.getPassword())) {
            loginFrame.showSuccess("Login successful!");
            proceedToMainApplication(event.getUsername());
        } else {
            loginFrame.showError("Invalid username or password");
            loginFrame.clearForm();
        }
    }
    
    /**
     * Handles registration requests
     * @param event The registration event
     */
    private void handleRegister(LoginEvent event) {
        System.out.println("Registration requested at: " + event.getTimestamp());
        // TODO: Show registration dialog or navigate to registration view
        loginFrame.showSuccess("Registration feature coming soon!");
    }
    
    /**
     * Simulated authentication method
     * @param username The username
     * @param password The password
     * @return true if credentials are valid
     */
    private boolean authenticateUser(String username, String password) {
        // TODO: Replace with actual authentication logic
        // For demo purposes, accept any credentials with length > 2
        return username.length() > 2 && password.length() > 2;
    }
    
    /**
     * Proceeds to the main application after successful authentication
     * @param username The authenticated username
     */
    private void proceedToMainApplication(String username) {
        // Hide login frame
        loginFrame.setVisible(false);
        
        // Create and show main application
        mainFrame = new MainFrame();
        mainFrame.setTitle("WebShop - Welcome " + username);
        
        // Set up main controller
        mainController = new MainController(mainFrame);
        mainFrame.getToolBarPanel().setToolBarListener(mainController);
        mainController.initialize();
        
        // Show main frame
        mainFrame.setVisible(true);
        
        // Dispose login frame (optional - keeps it in memory)
        // loginFrame.dispose();
        
        System.out.println("Main application started for user: " + username);
    }
    
    /**
     * Initialize the login controller
     */
    public void initialize() {
        loginFrame.setVisible(true);
        System.out.println("Login system initialized");
    }
}