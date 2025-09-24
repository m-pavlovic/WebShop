package com.webshop.view;

import javax.swing.*;
import java.awt.*;

/**
 * Cart panel displaying shopping cart contents
 */
public class CartPanel extends JPanel {
    
    public CartPanel() {
        initComponents();
        layoutComponents();
    }
    
    private void initComponents() {
        setBackground(new Color(245, 245, 245));
    }
    
    private void layoutComponents() {
        setLayout(new BorderLayout());
        
        JLabel titleLabel = new JLabel("Shopping Cart", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        
        JLabel contentLabel = new JLabel("Your cart is empty", JLabel.CENTER);
        contentLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        contentLabel.setForeground(Color.GRAY);
        
        add(titleLabel, BorderLayout.NORTH);
        add(contentLabel, BorderLayout.CENTER);
    }
}
