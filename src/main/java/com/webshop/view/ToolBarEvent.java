package com.webshop.view;

import java.time.LocalDateTime;

/**
 * Event class representing toolbar actions in the WebShop application
 * Contains information about which toolbar action was triggered
 */
public class ToolBarEvent {

    /**
     * Enum representing the different types of toolbar actions
     */
    public enum ActionType {
        HOME, CART, PROFILE, CONTACT
    }

    private final ActionType actionType;
    private final Object source;
    private final LocalDateTime timestamp;
    private final String description;

    /**
     * Constructor for ToolBarEvent
     * @param actionType The type of action that was performed
     * @param source The source component that triggered the event
     */
    public ToolBarEvent(ActionType actionType, Object source) {
        this.actionType = actionType;
        this.source = source;
        this.timestamp = LocalDateTime.now();
        this.description = "Toolbar action: " + actionType.name();
    }

    /**
     * Gets the action type of this event
     * @return The ActionType enum value
     */
    public ActionType getActionType() {
        return actionType;
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

    @Override
    public String toString() {
        return "ToolBarEvent{" +
                "action='" + actionType + '\'' +
                ", timestamp=" + timestamp +
                ", description='" + description + '\'' +
                '}';
    }
}