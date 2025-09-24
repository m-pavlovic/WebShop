package com.webshop.view;

import javax.swing.*;
import java.awt.*;

/**
 * Home panel displaying the main content of the WebShop
 * Shows welcome message and featured products/categories
 */
public class HomePanel extends JPanel {
    
    public HomePanel() {
        initComponents();
        layoutComponents();
    }
    
    private void initComponents() {
        setBackground(new Color(245, 245, 245)); // Light gray background
    }
    
    private void layoutComponents() {
        setLayout(new BorderLayout());
        
        // Welcome section
        JPanel welcomePanel = new JPanel();
        welcomePanel.setBackground(Color.WHITE);
        welcomePanel.setBorder(BorderFactory.createEmptyBorder(30, 20, 30, 20));
        
        JLabel welcomeLabel = new JLabel("Welcome to WebShop!", JLabel.CENTER);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 28));
        welcomeLabel.setForeground(new Color(51, 51, 51));
        welcomePanel.add(welcomeLabel);
        
        // Content section
        JPanel contentSection = new JPanel(new GridLayout(2, 2, 20, 20));
        contentSection.setBackground(new Color(245, 245, 245));
        contentSection.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        // Feature cards
        contentSection.add(createFeatureCard("Featured Products", "Browse our latest collection"));
        contentSection.add(createFeatureCard("Special Offers", "Don't miss our amazing deals"));
        contentSection.add(createFeatureCard("New Arrivals", "Check out what's new"));
        contentSection.add(createFeatureCard("Customer Reviews", "See what others are saying"));
        
        add(welcomePanel, BorderLayout.NORTH);
        add(contentSection, BorderLayout.CENTER);
    }
    
    private JPanel createFeatureCard(String title, String description) {
        JPanel card = new JPanel(new BorderLayout());
        card.setBackground(Color.WHITE);
        card.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(200, 200, 200), 1),
            BorderFactory.createEmptyBorder(15, 15, 15, 15)
        ));
        
        JLabel titleLabel = new JLabel(title);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
        titleLabel.setForeground(new Color(51, 51, 51));
        
        JLabel descLabel = new JLabel(description);
        descLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        descLabel.setForeground(new Color(102, 102, 102));
        
        card.add(titleLabel, BorderLayout.NORTH);
        card.add(descLabel, BorderLayout.CENTER);
        
        return card;
    }
}
