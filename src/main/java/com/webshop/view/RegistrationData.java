package com.webshop.view;

/**
 * Data transfer object for user registration information
 * Encapsulates all data needed to create a new user account
 */
public class RegistrationData {
    
    private final String username;
    private final String password;
    private final String email;
    private final String fullName;
    
    /**
     * Constructor for registration data
     * @param username The desired username
     * @param password The user's password
     * @param email The user's email address
     * @param fullName The user's full name
     */
    public RegistrationData(String username, String password, String email, String fullName) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.fullName = fullName;
    }
    
    /**
     * Gets the username
     * @return The username
     */
    public String getUsername() {
        return username;
    }
    
    /**
     * Gets the password
     * @return The password
     */
    public String getPassword() {
        return password;
    }
    
    /**
     * Gets the email address
     * @return The email address
     */
    public String getEmail() {
        return email;
    }
    
    /**
     * Gets the full name
     * @return The full name
     */
    public String getFullName() {
        return fullName;
    }
    
    /**
     * Validates that all required fields are present and not empty
     * @return true if all required fields are valid
     */
    public boolean isValid() {
        return username != null && !username.trim().isEmpty() &&
               password != null && !password.isEmpty() &&
               email != null && !email.trim().isEmpty() &&
               fullName != null && !fullName.trim().isEmpty();
    }
    
    @Override
    public String toString() {
        return "RegistrationData{" +
                "username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", fullName='" + fullName + '\'' +
                '}'; // Password omitted for security
    }
}