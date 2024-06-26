package com.ldinkaofficial;

import javax.swing.*;

public class StartFrame extends JFrame {

    public final static int WRONG_MAZE_SIZE = 0;
    public final static int WRONG_NUMBER_OF_EXITS = 0;

    private final StartPanel startPanel;
    private int mazeSizeX = WRONG_MAZE_SIZE;
    private int mazeSizeY = WRONG_MAZE_SIZE;
    private int numberOfExits = WRONG_NUMBER_OF_EXITS;

    public StartFrame() {
        startFrameInitialize();
        startPanel = getStartPanel();
        add(startPanel);
    }
    private void startFrameInitialize() {
        setTitle("Start Frame");
        setSize(250,200);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private StartPanel getStartPanel() {
        return new StartPanel(this);
    }

    public boolean checkWhetherParametersSetCorrect(){
        return (mazeSizeX >= 2 && mazeSizeX < 1000 &&
                numberOfExits >= 1 && numberOfExits < mazeSizeX + mazeSizeY
                && mazeSizeY >= 2 && mazeSizeY < 1000);
    }

    public int getMazeSizeX() {
        return mazeSizeX;
    }
    public int getMazeSizeY() {
        return mazeSizeY;
    }

    public void setMazeSizeX(int mazeSizeX) {
        this.mazeSizeX = mazeSizeX;
    }
    public void setMazeSizeY(int mazeSizeY) {
        this.mazeSizeY = mazeSizeY;
    }

    public int getNumberOfExits() {
        return numberOfExits;
    }

    public void setNumberOfExits(int numberOfExits) {
        this.numberOfExits = numberOfExits;
    }
}

