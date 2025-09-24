package com.webshop.view;

import java.time.LocalDateTime;

/**
 * Event class representing login-related actions in the WebShop application
 * Contains information about login attempts and user authentication events
 */
public class LoginEvent {

    /**
     * Enum representing the different types of login actions
     */
    public enum ActionType {
        LOGIN_ATTEMPT, REGISTER_REQUEST, LOGOUT, PASSWORD_RESET
    }

    private final ActionType actionType;
    private final String username;
    private final String password;
    private final Object source;
    private final LocalDateTime timestamp;
    private final String description;

    /**
     * Constructor for login attempt events
     * @param actionType The type of login action
     * @param username The username (can be null for some actions)
     * @param password The password (can be null for some actions)
     * @param source The source component that triggered the event
     */
    public LoginEvent(ActionType actionType, String username, String password, Object source) {
        this.actionType = actionType;
        this.username = username;
        this.password = password;
        this.source = source;
        this.timestamp = LocalDateTime.now();
        this.description = "Login action: " + actionType.name();
    }

    /**
     * Constructor for simple login actions without credentials
     * @param actionType The type of login action
     * @param source The source component that triggered the event
     */
    public LoginEvent(ActionType actionType, Object source) {
        this(actionType, null, null, source);
    }

    /**
     * Gets the action type of this event
     * @return The ActionType enum value
     */
    public ActionType getActionType() {
        return actionType;
    }

    /**
     * Gets the username associated with this event
     * @return The username, or null if not applicable
     */
    public String getUsername() {
        return username;
    }

    /**
     * Gets the password associated with this event
     * @return The password, or null if not applicable
     */
    public String getPassword() {
        return password;
    }

    /**
     * Gets the source component that triggered this event
     * @return The source object
     */
    public Object getSource() {
        return source;
    }

    /**
     * Gets the timestamp when this event was created
     * @return LocalDateTime of event creation
     */
    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    /**
     * Gets a description of this event
     * @return String description of the event
     */
    public String getDescription() {
        return description;
    }

    /**
     * Checks if this event has credentials
     * @return true if both username and password are present
     */
    public boolean hasCredentials() {
        return username != null && password != null && 
               !username.trim().isEmpty() && !password.trim().isEmpty();
    }

    @Override
    public String toString() {
        return "LoginEvent{" +
                "action='" + actionType + '\'' +
                ", username='" + (username != null ? username : "N/A") + '\'' +
                ", timestamp=" + timestamp +
                ", description='" + description + '\'' +
                '}';
    }
}