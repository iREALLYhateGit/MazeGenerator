package com.ldinkaofficial;

import javax.swing.*;

public class StartFrame extends JFrame {

    public StartFrame() {
        initialize();

    }
    private void initialize() {
        setTitle("Start Frame");
        setSize(800,600);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
