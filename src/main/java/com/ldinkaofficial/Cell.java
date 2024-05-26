package com.ldinkaofficial;

public class Cell{

    private boolean isRiched = false;

    public boolean isRiched() {
        return isRiched;
    }

    public void setRiched() {
        isRiched = true;
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

    public void setRightWall(boolean rightWall) {
        this.rightWall = rightWall;
    }

    public void setLeftWall(boolean leftWall) {
        this.leftWall = leftWall;
    }

    public void setUpWall(boolean upWall) {
        this.upWall = upWall;
    }

    public void setDownWall(boolean downWall) {
        this.downWall = downWall;
    }
}