package com.webshop;

import javax.swing.SwingUtilities;
import com.webshop.view.MainFrame;

public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
           MainFrame mainFrame = new MainFrame();
              mainFrame.setVisible(true);
        });
    }
}