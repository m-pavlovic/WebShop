package com.webshop.view;

import javax.swing.*;
import java.awt.*;

/**
 * Registration frame for creating new user accounts
 * Follows MVC pattern with RegistrationListener for controller communication
 */
public class RegistrationFrame extends JFrame {
    
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JPasswordField confirmPasswordField;
    private JTextField emailField;
    private JTextField fullNameField;
    private JButton registerButton;
    private JButton cancelButton;
    private RegistrationListener registrationListener;
    
    public RegistrationFrame() {
        setTitle("WebShop - Create Account");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(450, 400);
        setLocationRelativeTo(null);
        setResizable(false);
        
        initComponents();
        layoutComponents();
        setupActions();
    }
    
    private void initComponents() {
        // Create form components
        usernameField = new JTextField(22);
        passwordField = new JPasswordField(22);
        confirmPasswordField = new JPasswordField(22);
        emailField = new JTextField(22);
        fullNameField = new JTextField(22);
        registerButton = new JButton("Create Account");
        cancelButton = new JButton("Cancel");
        
        // Match ToolBarPanel styling
        Color buttonBackground = new Color(135, 206, 250);  // Light Sky Blue
        Color darkBlue = new Color(0, 0, 139);              // Dark Blue border
        Font buttonFont = new Font("Arial", Font.BOLD, 14);
        
        // Register button styling to match ToolBarPanel
        registerButton.setPreferredSize(new Dimension(130, 50));
        registerButton.setBackground(buttonBackground);
        registerButton.setForeground(Color.BLACK);
        registerButton.setFont(buttonFont);
        registerButton.setBorder(BorderFactory.createLineBorder(darkBlue, 2));
        registerButton.setFocusable(false);
        registerButton.setOpaque(true);
        
        // Cancel button styling to match ToolBarPanel (but slightly muted)
        cancelButton.setPreferredSize(new Dimension(100, 50));
        cancelButton.setBackground(new Color(220, 220, 220)); // Keep gray for cancel
        cancelButton.setForeground(Color.BLACK);
        cancelButton.setFont(buttonFont);
        cancelButton.setBorder(BorderFactory.createLineBorder(darkBlue, 2));
        cancelButton.setFocusable(false);
        cancelButton.setOpaque(true);
    }
    
    private void layoutComponents() {
        setLayout(new BorderLayout());
        
        // Title panel
        JPanel titlePanel = new JPanel();
        JLabel titleLabel = new JLabel("Create New Account");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        titlePanel.add(titleLabel);
        titlePanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        
        // Form panel
        JPanel formPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 10, 8, 10);
        gbc.anchor = GridBagConstraints.WEST;
        
        // Username
        gbc.gridx = 0; gbc.gridy = 0;
        JLabel usernameLabel = new JLabel("Username *:");
        usernameLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        formPanel.add(usernameLabel, gbc);
        gbc.gridx = 1;
        formPanel.add(usernameField, gbc);
        
        // Full Name
        gbc.gridx = 0; gbc.gridy = 1;
        JLabel fullNameLabel = new JLabel("Full Name *:");
        fullNameLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        formPanel.add(fullNameLabel, gbc);
        gbc.gridx = 1;
        formPanel.add(fullNameField, gbc);
        
        // Email
        gbc.gridx = 0; gbc.gridy = 2;
        JLabel emailLabel = new JLabel("Email *:");
        emailLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        formPanel.add(emailLabel, gbc);
        gbc.gridx = 1;
        formPanel.add(emailField, gbc);
        
        // Password
        gbc.gridx = 0; gbc.gridy = 3;
        JLabel passwordLabel = new JLabel("Password *:");
        passwordLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        formPanel.add(passwordLabel, gbc);
        gbc.gridx = 1;
        formPanel.add(passwordField, gbc);
        
        // Confirm Password
        gbc.gridx = 0; gbc.gridy = 4;
        JLabel confirmPasswordLabel = new JLabel("Confirm Password *:");
        confirmPasswordLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        formPanel.add(confirmPasswordLabel, gbc);
        gbc.gridx = 1;
        formPanel.add(confirmPasswordField, gbc);
        
        // Required fields note
        gbc.gridx = 0; gbc.gridy = 5; gbc.gridwidth = 2;
        JLabel requiredLabel = new JLabel("* Required fields");
        requiredLabel.setFont(new Font("Arial", Font.ITALIC, 10));
        requiredLabel.setForeground(Color.GRAY);
        formPanel.add(requiredLabel, gbc);
        
        // Button panel
        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(registerButton);
        buttonPanel.add(cancelButton);
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        
        // Add to frame
        add(titlePanel, BorderLayout.NORTH);
        add(formPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }
    
    private void setupActions() {
        registerButton.addActionListener(e -> {
            if (registrationListener != null) {
                if (validateForm()) {
                    RegistrationData data = new RegistrationData(
                        usernameField.getText().trim(),
                        new String(passwordField.getPassword()),
                        emailField.getText().trim(),
                        fullNameField.getText().trim()
                    );
                    registrationListener.onRegisterUser(data);
                }
            }
        });
        
        cancelButton.addActionListener(e -> {
            if (registrationListener != null) {
                registrationListener.onCancelRegistration();
            }
            dispose();
        });
        
        // Allow Enter key to submit form
        getRootPane().setDefaultButton(registerButton);
    }
    
    /**
     * Validates the registration form
     * @return true if form is valid, false otherwise
     */
    private boolean validateForm() {
        // Check required fields
        if (usernameField.getText().trim().isEmpty()) {
            showError("Username is required");
            usernameField.requestFocus();
            return false;
        }
        
        if (fullNameField.getText().trim().isEmpty()) {
            showError("Full name is required");
            fullNameField.requestFocus();
            return false;
        }
        
        if (emailField.getText().trim().isEmpty()) {
            showError("Email is required");
            emailField.requestFocus();
            return false;
        }
        
        if (passwordField.getPassword().length == 0) {
            showError("Password is required");
            passwordField.requestFocus();
            return false;
        }
        
        if (confirmPasswordField.getPassword().length == 0) {
            showError("Please confirm your password");
            confirmPasswordField.requestFocus();
            return false;
        }
        
        // Check password match
        String password = new String(passwordField.getPassword());
        String confirmPassword = new String(confirmPasswordField.getPassword());
        
        if (!password.equals(confirmPassword)) {
            showError("Passwords do not match");
            confirmPasswordField.requestFocus();
            return false;
        }
        
        // Check password strength
        if (password.length() < 6) {
            showError("Password must be at least 6 characters long");
            passwordField.requestFocus();
            return false;
        }
        
        // Basic email validation
        if (!isValidEmail(emailField.getText().trim())) {
            showError("Please enter a valid email address");
            emailField.requestFocus();
            return false;
        }
        
        // Check username length
        if (usernameField.getText().trim().length() < 3) {
            showError("Username must be at least 3 characters long");
            usernameField.requestFocus();
            return false;
        }
        
        return true;
    }
    
    /**
     * Basic email validation
     * @param email The email to validate
     * @return true if email format is valid
     */
    private boolean isValidEmail(String email) {
        return email.contains("@") && email.contains(".") && email.length() > 5;
    }
    
    /**
     * Sets the registration listener (typically the controller)
     * @param listener The RegistrationListener implementation
     */
    public void setRegistrationListener(RegistrationListener listener) {
        this.registrationListener = listener;
    }
    
    /**
     * Shows an error message to the user
     * @param message The error message
     */
    public void showError(String message) {
        JOptionPane.showMessageDialog(this, message, "Registration Error", JOptionPane.ERROR_MESSAGE);
    }
    
    /**
     * Shows a success message to the user
     * @param message The success message
     */
    public void showSuccess(String message) {
        JOptionPane.showMessageDialog(this, message, "Registration Successful", JOptionPane.INFORMATION_MESSAGE);
    }
    
    /**
     * Clears all form fields
     */
    public void clearForm() {
        usernameField.setText("");
        passwordField.setText("");
        confirmPasswordField.setText("");
        emailField.setText("");
        fullNameField.setText("");
    }
}