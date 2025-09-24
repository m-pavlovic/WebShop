package com.webshop.view;

import javax.swing.*;
import java.awt.*;

/**
 * Home panel displaying the main shopping interface
 * Features product catalog, categories, and shopping functionality
 */
public class HomePanel extends JPanel {
    
    
    private HomePanelListener homePanelListener;
    
    
    private static final Color BACKGROUND_COLOR = new Color(245, 245, 245);
    private static final Color CARD_COLOR = new Color(135, 206, 250);
    private static final Color BUTTON_COLOR = new Color(135, 206, 250);
    private static final Color HOVER_COLOR = new Color(100, 149, 237);
    private static final Color TEXT_COLOR = Color.BLACK;
    private static final Color BORDER_COLOR = new Color(0, 0, 139);
    
    public HomePanel() {
        initComponents();
        layoutComponents();
    }
    
    private void initComponents() {
        setBackground(BACKGROUND_COLOR);
    }
    
    private void layoutComponents() {
        setLayout(new BorderLayout());
        
    
        JPanel mainContainer = new JPanel(new BorderLayout());
        mainContainer.setBackground(BACKGROUND_COLOR);
        mainContainer.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        
        
        JPanel topSection = createTopSection();
        
        
        JPanel contentArea = new JPanel(new BorderLayout());
        contentArea.setBackground(BACKGROUND_COLOR);
        
        
        JPanel categoryPanel = createCategoryPanel();

        JPanel filterPanel = createFilterPanel();
        JPanel productArea = createProductArea();
        
        contentArea.add(categoryPanel, BorderLayout.WEST);
        contentArea.add(productArea, BorderLayout.CENTER);
        
        mainContainer.add(topSection, BorderLayout.NORTH);
        mainContainer.add(contentArea, BorderLayout.CENTER);
        
        add(mainContainer, BorderLayout.CENTER);
    }
    
    private JPanel createFilterPanel() {
        //price and components filter
        //... to be implemented
        return new JPanel();
    }

    private JPanel createTopSection() {
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.setBackground(BACKGROUND_COLOR);
        topPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 15, 0));
        
        
        JPanel searchPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        searchPanel.setBackground(BACKGROUND_COLOR);
        searchPanel.setPreferredSize(new Dimension(180, 60));
        
        
        JPanel searchContainer = new JPanel();
        searchContainer.setLayout(new BoxLayout(searchContainer, BoxLayout.Y_AXIS));
        searchContainer.setBackground(BACKGROUND_COLOR);
        searchContainer.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 15));
        
        JLabel searchLabel = new JLabel("Search Products:", JLabel.LEFT);
        searchLabel.setFont(new Font("Arial", Font.BOLD, 14));
        searchLabel.setForeground(TEXT_COLOR);
        searchLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        
        JTextField searchField = new JTextField();
        searchField.setPreferredSize(new Dimension(160, 35));
        searchField.setMaximumSize(new Dimension(160, 35));
        searchField.setFont(new Font("Arial", Font.PLAIN, 12));
        searchField.setBorder(BorderFactory.createLineBorder(BORDER_COLOR, 2));
        searchField.setAlignmentX(Component.LEFT_ALIGNMENT);
        
    
        searchField.addActionListener(e -> {
            if (homePanelListener != null) {
                String searchText = searchField.getText();
                HomePanelEvent event = new HomePanelEvent(
                    HomePanelEvent.ActionType.SEARCH_PRODUCTS, 
                    searchText, 
                    searchField
                );
                homePanelListener.onHomePanelAction(event);
            }
        });
        
        searchContainer.add(searchLabel);
        searchContainer.add(Box.createVerticalStrut(8));
        searchContainer.add(searchField);
        
        searchPanel.add(searchContainer);
        
        
        JPanel titlePanel = new JPanel(new BorderLayout());
        titlePanel.setBackground(BACKGROUND_COLOR);
        
        JLabel titleLabel = new JLabel("Computer Hardware & Accessories", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(TEXT_COLOR);
        titleLabel.setBorder(BorderFactory.createEmptyBorder(15, 0, 15, 0));
        
        titlePanel.add(titleLabel, BorderLayout.CENTER);
        
        topPanel.add(searchPanel, BorderLayout.WEST);
        topPanel.add(titlePanel, BorderLayout.CENTER);
        
        return topPanel;
    }
    
    private JPanel createCategoryPanel() {
        JPanel categoryPanel = new JPanel();
        categoryPanel.setLayout(new BoxLayout(categoryPanel, BoxLayout.Y_AXIS));
        categoryPanel.setBackground(BACKGROUND_COLOR);
        categoryPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 15));
        categoryPanel.setPreferredSize(new Dimension(180, 0));
        
        // Category dropdown label
        JLabel categoryLabel = new JLabel("Categories:", JLabel.CENTER);
        categoryLabel.setFont(new Font("Arial", Font.BOLD, 16));
        categoryLabel.setForeground(TEXT_COLOR);
        categoryLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        categoryLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 15, 0));
        
        
        String[] categories = {
            "All Categories",
            "Case", 
            "Motherboard", 
            "GPU", 
            "CPU", 
            "RAM", 
            "Cooling System", 
            "PSU", 
            "Storage"
        };
        
        JComboBox<String> categoryDropdown = new JComboBox<>(categories);
        categoryDropdown.setPreferredSize(new Dimension(160, 40));
        categoryDropdown.setMaximumSize(new Dimension(160, 40));
        categoryDropdown.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        
        categoryDropdown.setBackground(BUTTON_COLOR);
        categoryDropdown.setForeground(TEXT_COLOR);
        categoryDropdown.setFont(new Font("Arial", Font.BOLD, 14));
        categoryDropdown.setBorder(BorderFactory.createLineBorder(BORDER_COLOR, 2));
        categoryDropdown.setFocusable(false);
        
        
        categoryDropdown.addActionListener(e -> {
            if (homePanelListener != null) {
                String selectedCategory = (String) categoryDropdown.getSelectedItem();
                if (selectedCategory != null) {
                    HomePanelEvent event = new HomePanelEvent(
                        HomePanelEvent.ActionType.CATEGORY_SELECTED,
                        selectedCategory,
                        categoryDropdown
                    );
                    homePanelListener.onHomePanelAction(event);
                }
            }
        });
        
        categoryPanel.add(categoryLabel);
        categoryPanel.add(categoryDropdown);
        categoryPanel.add(Box.createVerticalStrut(20));
        
        return categoryPanel;
    }
    
    private JPanel createProductArea() {
        JPanel productArea = new JPanel(new BorderLayout());
        productArea.setBackground(BACKGROUND_COLOR);
        
        // Product grid
        JPanel productGrid = new JPanel(new GridLayout(3, 3, 15, 15));
        productGrid.setBackground(BACKGROUND_COLOR);
        
        
        for (int i = 1; i <= 9; i++) {
            JPanel productCard = createProductCard("ITEM " + i, "$" + (99 + i * 50));
            productGrid.add(productCard);
        }
        
        
        JPanel bottomSection = new JPanel(new BorderLayout());
        bottomSection.setBackground(BACKGROUND_COLOR);
        bottomSection.setBorder(BorderFactory.createEmptyBorder(15, 0, 0, 0));
        
        
        JPanel pagePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        pagePanel.setBackground(CARD_COLOR);
        pagePanel.setPreferredSize(new Dimension(0, 22));
        
        JLabel pageLabel = new JLabel("Page 1 of 5", JLabel.CENTER);
        pageLabel.setFont(new Font("Arial", Font.BOLD, 12));
        pageLabel.setForeground(TEXT_COLOR);
        pagePanel.add(pageLabel);
        
        // Checkout button
        JPanel checkoutPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        checkoutPanel.setBackground(BACKGROUND_COLOR);
        
        JButton checkoutBtn = createStyledButton("Proceed to checkout", 200, 45);
        checkoutBtn.setFont(new Font("Arial", Font.BOLD, 16));
        
        // Add checkout event handling
        checkoutBtn.addActionListener(e -> {
            if (homePanelListener != null) {
                HomePanelEvent event = new HomePanelEvent(
                    HomePanelEvent.ActionType.PROCEED_TO_CHECKOUT,
                    checkoutBtn
                );
                homePanelListener.onHomePanelAction(event);
            }
        });
        
        checkoutPanel.add(checkoutBtn);
        
        bottomSection.add(pagePanel, BorderLayout.NORTH);
        bottomSection.add(checkoutPanel, BorderLayout.CENTER);
        
        productArea.add(productGrid, BorderLayout.CENTER);
        productArea.add(bottomSection, BorderLayout.SOUTH);
        
        return productArea;
    }
    
    private JPanel createProductCard(String itemName, String price) {
        JPanel card = new JPanel(new BorderLayout());
        card.setBackground(CARD_COLOR);
        card.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(50, 110, 160), 2),
            BorderFactory.createEmptyBorder(15, 15, 5, 15)
        ));
        card.setPreferredSize(new Dimension(160, 140));
        
        // Item info
        JPanel infoPanel = new JPanel(new BorderLayout());
        infoPanel.setBackground(CARD_COLOR);
        
        JLabel nameLabel = new JLabel(itemName, JLabel.CENTER);
        nameLabel.setFont(new Font("Arial", Font.BOLD, 14));
        nameLabel.setForeground(TEXT_COLOR);
        
        JLabel priceLabel = new JLabel(price, JLabel.CENTER);
        priceLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        priceLabel.setForeground(TEXT_COLOR);
        
        infoPanel.add(nameLabel, BorderLayout.CENTER);
        infoPanel.add(priceLabel, BorderLayout.SOUTH);
        
        
        JButton addButton = createStyledButton("Add to cart", 60, 15);
        addButton.setFont(new Font("Arial", Font.BOLD, 12));
        
        
        addButton.addActionListener(e -> {
            if (homePanelListener != null) {
                HomePanelEvent event = new HomePanelEvent(
                    HomePanelEvent.ActionType.ADD_TO_CART,
                    itemName, // Pass the item name as product identifier
                    addButton
                );
                homePanelListener.onHomePanelAction(event);
            }
        });
        
        JPanel buttonWrapper = new JPanel(new BorderLayout());
        buttonWrapper.setBackground(CARD_COLOR);
        buttonWrapper.setBorder(BorderFactory.createEmptyBorder(0, 0, 5, 0));
        buttonWrapper.add(addButton, BorderLayout.CENTER);
        
        card.add(infoPanel, BorderLayout.CENTER);
        card.add(buttonWrapper, BorderLayout.SOUTH);
        
        return card;
    }
    
    private JButton createStyledButton(String text, int width, int height) {
        JButton button = new JButton(text);
        button.setPreferredSize(new Dimension(width, height));
        button.setBackground(BUTTON_COLOR);
        button.setForeground(TEXT_COLOR);
        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.setBorder(BorderFactory.createLineBorder(BORDER_COLOR, 2));
        button.setFocusable(false);
        button.setOpaque(true);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        
        button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setBackground(HOVER_COLOR);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setBackground(BUTTON_COLOR);
            }
        });
        
        return button;
    }
    
    /**
     * Sets the listener for home panel events (typically the Controller)
     * @param listener The HomePanelListener implementation
     */
    public void setHomePanelListener(HomePanelListener listener) {
        this.homePanelListener = listener;
    }
}
