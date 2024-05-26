package com.ldinkaofficial;

import javax.swing.*;
import java.awt.*;

public class MazeFrame extends JFrame {

    private MazePanel mazePanel;
    private final int mazeSize;
    private int thickness;
    private int blockSize;
    private int offset;
    private final int numberOfExits;

    private JScrollPane scrollPane;


    public MazeFrame(int mazeSize, int numberOfExits) {
        this.mazeSize = mazeSize;
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
        if(mazeSize <= 20){
            blockSize = 14;
            thickness = 4;
            setSize(300 + thickness + 20, 300 + thickness + 20 + 32);
            setResizable(false);
            offset = (getSize().width - blockSize*mazeSize - thickness - 10)/2;
            mazePanel = getMazePanel();
            mazePanel.setPreferredSize(new Dimension(300 + thickness + 20, 300 + thickness + 20 + 32));
            add(mazePanel);
        }
        else{
            blockSize = 10;
            thickness = 4;
            setSize(300 + thickness + 20, 300 + thickness + 20 + 32);
            setResizable(true);
            offset = 20;
            mazePanel = getMazePanel();
            mazePanel.setPreferredSize(new Dimension(blockSize*mazeSize + thickness + 40, blockSize*mazeSize + thickness + 40));
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

        MazePanel finalMazePanel = new MazePanel(mazeSize,thickness, blockSize, offset, numberOfExits);
        finalMazePanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10,5));
        finalMazePanel.setBackground(Color.MAGENTA);

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
