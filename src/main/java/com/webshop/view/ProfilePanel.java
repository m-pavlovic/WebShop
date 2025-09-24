package com.webshop.view;

import javax.swing.*;
import java.awt.*;

/**
 * Profile panel displaying user profile information
 */
public class ProfilePanel extends JPanel {
    
    public ProfilePanel() {
        initComponents();
        layoutComponents();
    }
    
    private void initComponents() {
        setBackground(new Color(245, 245, 245));
    }
    
    private void layoutComponents() {
        setLayout(new BorderLayout());
        
        JLabel titleLabel = new JLabel("User Profile", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        
        JLabel contentLabel = new JLabel("Profile management coming soon", JLabel.CENTER);
        contentLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        contentLabel.setForeground(Color.GRAY);
        
        add(titleLabel, BorderLayout.NORTH);
        add(contentLabel, BorderLayout.CENTER);
    }
}
