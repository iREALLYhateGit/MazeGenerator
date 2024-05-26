package com.ldinkaofficial;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MazeFrame extends JFrame {

    private MazePanel mazePanel;
    private int mazeSize = 1000;
    public MazeFrame(int mazeSize) {
        this.mazeSize = mazeSize;
        frameBasicInitialize();
        mazePanelInitialize();
        System.out.println(mazeSize);
    }
    private void frameBasicInitialize() {
        setTitle("Start Frame");
        setSize(mazeSize*20,mazeSize*20);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }
    private void mazePanelInitialize() {

        mazePanel = new MazePanel(mazeSize,5,1);
        mazePanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10,5));
        mazePanel.setBackground(Color.MAGENTA);


        add(mazePanel);
    }


    private static boolean isDisplayed;

    public static boolean isDisplayed() {
        return isDisplayed;
    }

    public static void setDisplayed(boolean isDisplayed) {
        MazeFrame.isDisplayed = isDisplayed;
    }

    @Override
    public void dispose() {
        super.dispose();
        isDisplayed = false;
    }
}
