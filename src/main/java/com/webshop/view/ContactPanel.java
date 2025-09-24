package com.webshop.view;

import javax.swing.*;
import java.awt.*;

/**
 * Contact panel displaying contact information and form
 */
public class ContactPanel extends JPanel {
    
    public ContactPanel() {
        initComponents();
        layoutComponents();
    }
    
    private void initComponents() {
        setBackground(new Color(245, 245, 245));
    }
    
    private void layoutComponents() {
        setLayout(new BorderLayout());
        
        JLabel titleLabel = new JLabel("Contact Us", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        
        JPanel contactInfo = new JPanel(new GridLayout(4, 1, 10, 10));
        contactInfo.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));
        contactInfo.setBackground(new Color(245, 245, 245));
        
        contactInfo.add(new JLabel("📧 Email: support@webshop.com", JLabel.CENTER));
        contactInfo.add(new JLabel("📞 Phone: +1 (555) 123-4567", JLabel.CENTER));
        contactInfo.add(new JLabel("🏢 Address: 123 Shop Street, Commerce City", JLabel.CENTER));
        contactInfo.add(new JLabel("🕒 Hours: Mon-Fri 9AM-6PM", JLabel.CENTER));
        
        add(titleLabel, BorderLayout.NORTH);
        add(contactInfo, BorderLayout.CENTER);
    }
}
