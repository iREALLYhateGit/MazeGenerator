package com.ldinkaofficial;

import javax.swing.*;
import java.awt.*;

public class MazeFrame extends JFrame {

    private MazePanel mazePanel;
    private final int mazeSizeX;
    private final int mazeSizeY;
    private int thickness;
    private int blockSize;
    private int offsetX;
    private int offsetY;
    private final int numberOfExits;

    private JScrollPane scrollPane;


    public MazeFrame(int mazeSizeX, int mazeSizeY, int numberOfExits) {
        this.mazeSizeX = mazeSizeX;
        this.mazeSizeY = mazeSizeY;
        this.numberOfExits = numberOfExits;
        frameBasicInitialize();
        addPanels();
    }
    private void frameBasicInitialize() {
        setTitle("Start Frame");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    private void addPanels(){
        if(mazeSizeX <= 20 && mazeSizeY <= 20){
            blockSize = 14;
            thickness = 4;
            setSize(300 + thickness + 20, 300 + thickness + 20 + 35);
            setResizable(false);
            offsetX = (getSize().width - blockSize*mazeSizeX - thickness - 10)/2;
            offsetY = (getSize().height - blockSize*mazeSizeY - thickness - 35)/2;
            mazePanel = getMazePanel();
            mazePanel.setPreferredSize(new Dimension(300 + thickness + 20, 300 + thickness + 20 + 32));
            add(mazePanel);
        }
        else{
            blockSize = 10;
            thickness = 4;
            setSize(300 + thickness + 20, 300 + thickness + 20 + 32);
            setResizable(true);
            offsetX = 20;
            offsetY = 20;
            mazePanel = getMazePanel();
            mazePanel.setPreferredSize(new Dimension(blockSize*mazeSizeX + thickness + 40, blockSize*mazeSizeY + thickness + 40));
            addScrollPane();
            mazePanel.setAutoscrolls(true);
        }
    }

    private void addScrollPane(){
        scrollPane = new JScrollPane(mazePanel);
        setContentPane(scrollPane);
        scrollPane.setViewportView(mazePanel);
        scrollPane.setPreferredSize(new Dimension(300, 300));
    }

    private MazePanel getMazePanel() {

        MazePanel finalMazePanel = new MazePanel(mazeSizeX, mazeSizeY,thickness,
                blockSize, offsetX, offsetY, numberOfExits);
        finalMazePanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10,5));
        finalMazePanel.setBackground(Color.LIGHT_GRAY);

        return finalMazePanel;
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
