package com.webshop.view;

import java.awt.*;
import javax.swing.*;

/**
 * Login/Register frame that appears before the main application
 * Follows MVC pattern with LoginListener for controller communication
 */
public class LoginFrame extends JFrame {
    
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JButton registerButton;
    private LoginListener loginListener;
    
    public LoginFrame() {
        setTitle("WebShop - Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);
        setResizable(false);
        
        initComponents();
        layoutComponents();
        setupActions();
    }
    
    private void initComponents() {
        // Create form components
        usernameField = new JTextField(20);
        passwordField = new JPasswordField(20);
        loginButton = new JButton("Login");
        registerButton = new JButton("Register");
        
        // Style buttons
        loginButton.setPreferredSize(new Dimension(120, 30));
        registerButton.setPreferredSize(new Dimension(120, 30));
    }
    
    private void layoutComponents() {
        setLayout(new BorderLayout());
        
        // Title panel
        JPanel titlePanel = new JPanel();
        titlePanel.add(new JLabel("Welcome to WebShop"));
        titlePanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        
        // Form panel
        JPanel formPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        
        // Username
        gbc.gridx = 0; gbc.gridy = 0; gbc.anchor = GridBagConstraints.EAST;
        formPanel.add(new JLabel("Username:"), gbc);
        gbc.gridx = 1; gbc.anchor = GridBagConstraints.WEST;
        formPanel.add(usernameField, gbc);
        
        // Password
        gbc.gridx = 0; gbc.gridy = 1; gbc.anchor = GridBagConstraints.EAST;
        formPanel.add(new JLabel("Password:"), gbc);
        gbc.gridx = 1; gbc.anchor = GridBagConstraints.WEST;
        formPanel.add(passwordField, gbc);
        
        // Button panel
        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(loginButton);
        buttonPanel.add(registerButton);
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 10, 0));
        
        // Add to frame
        add(titlePanel, BorderLayout.NORTH);
        add(formPanel, BorderLayout.CENTER);
        
        JPanel southPanel = new JPanel(new BorderLayout());
        southPanel.add(buttonPanel, BorderLayout.NORTH);
        add(southPanel, BorderLayout.SOUTH);
    }
    
    private void setupActions() {
        loginButton.addActionListener(e -> {
            if (loginListener != null) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());
                LoginEvent event = new LoginEvent(LoginEvent.ActionType.LOGIN_ATTEMPT, 
                                                username, password, loginButton);
                loginListener.onLoginAction(event);
            }
        });
        
        registerButton.addActionListener(e -> {
            if (loginListener != null) {
                LoginEvent event = new LoginEvent(LoginEvent.ActionType.REGISTER_REQUEST, registerButton);
                loginListener.onLoginAction(event);
            }
        });
    }
    
    /**
     * Sets the login listener (typically the controller)
     * @param listener The LoginListener implementation
     */
    public void setLoginListener(LoginListener listener) {
        this.loginListener = listener;
    }
    
    /**
     * Shows an error message to the user
     * @param message The error message
     */
    public void showError(String message) {
        JOptionPane.showMessageDialog(this, message, "Login Error", JOptionPane.ERROR_MESSAGE);
    }
    
    /**
     * Shows a success message to the user
     * @param message The success message
     */
    public void showSuccess(String message) {
        JOptionPane.showMessageDialog(this, message, "Success", JOptionPane.INFORMATION_MESSAGE);
    }
    
    /**
     * Clears the form fields
     */
    public void clearForm() {
        usernameField.setText("");
        passwordField.setText("");
    }
}