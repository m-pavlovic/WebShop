package com.webshop;

import javax.swing.SwingUtilities;
import com.webshop.view.MainFrame;

/**
 * Main entry point for WebShop MVC application
 */
public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new MainFrame();
            }
        });
    }
}