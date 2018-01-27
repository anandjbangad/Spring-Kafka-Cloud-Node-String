package com.codenotfound.kafka.Receiver;

import javax.swing.*;
import java.awt.*;

public class DisplayRequest {

    public static void createWindow(String displayText){
        JFrame frame = new JFrame("Request Window");
        JLabel jLabel = new JLabel(displayText,SwingConstants.LEFT);
        jLabel.setPreferredSize(new Dimension(600,400));
        jLabel.setFont(new Font("Serif",Font.BOLD,20));
        jLabel.setForeground(Color.BLUE);
        frame.getContentPane().add(jLabel, BorderLayout.CENTER);
        frame.setLocation(100,300);
        //frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(true);
    }
}
