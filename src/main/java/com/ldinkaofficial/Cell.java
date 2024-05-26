package com.ldinkaofficial;

public class Cell{

    private boolean inMaze = false;

    public boolean isInMaze() {
        return inMaze;
    }

    public void setInMaze() {
        inMaze = true;
    }
    private boolean rightWall = true;
    private boolean leftWall = true;
    private boolean upWall = true;
    private boolean downWall = true;

    public boolean hasRightWall() {
        return rightWall;
    }

    public boolean hasLeftWall() {
        return leftWall;
    }

    public boolean hasUpWall() {
        return upWall;
    }

    public boolean hasDownWall() {
        return downWall;
    }

    public void breakRightWall() {
        rightWall = false;
    }

    public void breakLeftWall() {
        leftWall = false;
    }

    public void breakUpWall() {
        upWall = false;
    }

    public void breakDownWall() {
        downWall = false;
    }
}