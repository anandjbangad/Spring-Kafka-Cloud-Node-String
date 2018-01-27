package com.codenotfound.kafka.Receiver;

import javax.swing.*;
import java.awt.*;

public class DisplayResponse {
    public static void createWindow(String displayText){
        JFrame frame = new JFrame("Response Window");
        JLabel jLabel = new JLabel(displayText,SwingConstants.LEFT);
        jLabel.setPreferredSize(new Dimension(1500,200));
        jLabel.setFont(new Font("Serif",Font.BOLD,25));
        jLabel.setForeground(Color.BLUE);
        frame.getContentPane().add(jLabel, BorderLayout.CENTER);
        frame.setLocation(50,100);
        frame.pack();
        frame.setVisible(true);
    }
}
