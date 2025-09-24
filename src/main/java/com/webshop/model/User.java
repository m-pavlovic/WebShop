package com.webshop.model;

import java.time.LocalDateTime;

/**
 * User entity representing a registered user in the WebShop system
 * Contains user information and authentication data
 */
public class User {
    
    private Long id;
    private String username;
    private String hashedPassword;
    private String email;
    private String fullName;
    private LocalDateTime createdAt;
    private LocalDateTime lastLogin;
    private boolean isActive;
    
    /**
     * Constructor for creating a new user
     * @param username The unique username
     * @param hashedPassword The hashed password (never store plain text!)
     * @param email The user's email address
     * @param fullName The user's full name
     */
    public User(String username, String hashedPassword, String email, String fullName) {
        this.username = username;
        this.hashedPassword = hashedPassword;
        this.email = email;
        this.fullName = fullName;
        this.createdAt = LocalDateTime.now();
        this.isActive = true;
    }
    
    /**
     * Constructor with all fields for loading from database
     * @param id The user ID
     * @param username The username
     * @param hashedPassword The hashed password
     * @param email The email address
     * @param fullName The full name
     * @param createdAt The creation timestamp
     * @param lastLogin The last login timestamp
     * @param isActive Whether the user is active
     */
    public User(Long id, String username, String hashedPassword, String email, 
                String fullName, LocalDateTime createdAt, LocalDateTime lastLogin, boolean isActive) {
        this.id = id;
        this.username = username;
        this.hashedPassword = hashedPassword;
        this.email = email;
        this.fullName = fullName;
        this.createdAt = createdAt;
        this.lastLogin = lastLogin;
        this.isActive = isActive;
    }
    
    // Getters and setters
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getUsername() {
        return username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    public String getHashedPassword() {
        return hashedPassword;
    }
    
    public void setHashedPassword(String hashedPassword) {
        this.hashedPassword = hashedPassword;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getFullName() {
        return fullName;
    }
    
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
    
    public LocalDateTime getLastLogin() {
        return lastLogin;
    }
    
    public void setLastLogin(LocalDateTime lastLogin) {
        this.lastLogin = lastLogin;
    }
    
    public boolean isActive() {
        return isActive;
    }
    
    public void setActive(boolean active) {
        isActive = active;
    }
    
    /**
     * Returns a user-friendly display name
     * @return The full name if available, otherwise the username
     */
    public String getDisplayName() {
        return fullName != null && !fullName.trim().isEmpty() ? fullName : username;
    }
    
    /**
     * Checks if the user has a complete profile
     * @return true if all required fields are filled
     */
    public boolean hasCompleteProfile() {
        return username != null && !username.trim().isEmpty() &&
               email != null && !email.trim().isEmpty() &&
               fullName != null && !fullName.trim().isEmpty();
    }
    
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", fullName='" + fullName + '\'' +
                ", createdAt=" + createdAt +
                ", lastLogin=" + lastLogin +
                ", isActive=" + isActive +
                '}';
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        User user = (User) obj;
        return username != null ? username.equals(user.username) : user.username == null;
    }
    
    @Override
    public int hashCode() {
        return username != null ? username.hashCode() : 0;
    }
}