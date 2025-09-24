package com.webshop.controller;

import com.webshop.view.LoginFrame;
import com.webshop.view.LoginListener;
import com.webshop.view.LoginEvent;
import com.webshop.view.MainFrame;
import com.webshop.view.RegistrationFrame;
import com.webshop.view.RegistrationListener;
import com.webshop.view.RegistrationData;
import com.webshop.model.User;

/**
 * Controller for handling login/authentication logic and user registration
 * Manages the flow between LoginFrame, RegistrationFrame, and MainFrame
 */
public class LoginController implements LoginListener, RegistrationListener {
    
    private LoginFrame loginFrame;
    private MainFrame mainFrame;
    private MainController mainController;
    private RegistrationFrame registrationFrame;
    
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
        showRegistrationFrame();
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
     * Simple password hashing method
     * TODO: Replace with proper password hashing (BCrypt, PBKDF2, etc.)
     * @param password The plain text password
     * @return The hashed password
     */
    private String hashPassword(String password) {
        // For demonstration purposes - DO NOT use in production!
        // Use BCrypt, PBKDF2, or similar in real applications
        return "hashed_" + password.hashCode();
    }
    
    /**
     * Shows the registration frame
     */
    private void showRegistrationFrame() {
        if (registrationFrame == null) {
            registrationFrame = new RegistrationFrame();
            registrationFrame.setRegistrationListener(this);
        }
        registrationFrame.setVisible(true);
        registrationFrame.clearForm();
        registrationFrame.toFront();
        System.out.println("Registration frame opened");
    }
    
    /**
     * Implementation of RegistrationListener interface
     * Handles new user registration
     */
    @Override
    public void onRegisterUser(RegistrationData registrationData) {
        System.out.println("Processing registration for: " + registrationData.getUsername());
        
        if (!registrationData.isValid()) {
            registrationFrame.showError("Please fill in all required fields");
            return;
        }
        
        try {
            // Hash the password before storing
            String hashedPassword = hashPassword(registrationData.getPassword());
            
            // Create new user
            User newUser = new User(
                    registrationData.getUsername(),
                    hashedPassword,
                    registrationData.getEmail(),
                    registrationData.getFullName()
            );
            
            // TODO: Save user to database/service
            System.out.println("User created successfully: " + newUser.getUsername());
            
            registrationFrame.showSuccess("Account created successfully! You can now log in.");
            registrationFrame.dispose();
            registrationFrame = null;
            
        } catch (Exception e) {
            System.err.println("Registration failed: " + e.getMessage());
            registrationFrame.showError("Registration failed: " + e.getMessage());
        }
    }
    
    /**
     * Implementation of RegistrationListener interface
     * Handles registration cancellation
     */
    @Override
    public void onCancelRegistration() {
        System.out.println("Registration cancelled");
        if (registrationFrame != null) {
            registrationFrame.dispose();
            registrationFrame = null;
        }
    }
    
    /**
     * Initialize the login controller
     */
    public void initialize() {
        loginFrame.setVisible(true);
        System.out.println("Login system initialized");
    }
}