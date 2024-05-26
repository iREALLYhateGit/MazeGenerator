package com.ldinkaofficial;

import javax.swing.*;

public class StartFrame extends JFrame {

    public final static int WRONG_MAZE_SIZE = 0;
    public final static int WRONG_NUMBER_OF_EXITS = 0;

    private final StartPanel startPanel;
    private int mazeSizeX = WRONG_MAZE_SIZE;
    private int mazeSizeY = WRONG_MAZE_SIZE;
    private int amountOfExits = WRONG_NUMBER_OF_EXITS;

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

    public boolean checkWhetherParametersSet(){
        return mazeSizeX == WRONG_MAZE_SIZE
                || amountOfExits == WRONG_NUMBER_OF_EXITS || mazeSizeY == WRONG_MAZE_SIZE;
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

    public int getAmountOfExits() {
        return amountOfExits;
    }

    public void setAmountOfExits(int amountOfExits) {
        this.amountOfExits = amountOfExits;
    }
}

