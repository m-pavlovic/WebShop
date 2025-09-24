package com.webshop;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import com.webshop.view.LoginFrame;
import com.webshop.controller.LoginController;

/**
 * Main entry point for WebShop MVC application
 * Now starts with login/authentication flow
 */
public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                try {
                    // Set system look and feel
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (Exception e) {
                    System.err.println("Could not set system look and feel: " + e.getMessage());
                }

                // Start with login flow
                LoginFrame loginFrame = new LoginFrame();
                LoginController loginController = new LoginController(loginFrame);
                
                // Wire up login MVC
                loginFrame.setLoginListener(loginController);
                loginController.initialize();
                
                System.out.println("WebShop Application started with login system");
            }
        });
    }
}