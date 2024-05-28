package com.ldinkaofficial;

import javax.swing.*;
import java.awt.*;

public class MazePanel extends JPanel {

    private final int mazeSizeX, mazeSizeY, thickness, blockSize, offsetX,offsetY, numberOfExits;

    private final Labyrinth labyrinth;

    public MazePanel(int mazeSizeX, int mazeSizeY, int thickness,
                     int blockSize, int offsetX, int offsetY, int numberOfExits){
        this.mazeSizeX = mazeSizeX;
        this.mazeSizeY = mazeSizeY;
        this.thickness = thickness;
        this.blockSize = blockSize;
        this.offsetX = offsetX;
        this.offsetY = offsetY;
        this.numberOfExits = numberOfExits;
        labyrinth = new Labyrinth(mazeSizeX, mazeSizeY, numberOfExits);

    }
    @Override
    public void paintComponent(Graphics g){

        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;
        BasicStroke stroke = new BasicStroke(thickness);
        g2.setStroke(stroke);

        Cell cell = null;

        for (int i = 0; i < mazeSizeY; i++) {
            for (int j = 0; j < mazeSizeX; j++) {
                cell = labyrinth.cellMap.get(new Pair(i,j));
                if(cell.hasRightWall()) {
                    // draw vertical line on the right border of the cell
                    g2.drawLine(offsetX + j * blockSize + blockSize, offsetY + i * blockSize,
                            offsetX + blockSize + j * blockSize, offsetY + blockSize + i * blockSize);
                }
                if(cell.hasDownWall()) {
                    // draw horizontal line on the bottom border of the cell
                    g2.drawLine(offsetX + j * blockSize, offsetY + i * blockSize + blockSize,
                            offsetX + j * blockSize + blockSize, offsetY + i * blockSize + blockSize);
                }
                if(cell.hasLeftWall()) {
                    // draw vertical line on the left border of the cell
                    g2.drawLine(offsetX + j * blockSize, offsetY + i * blockSize,
                            offsetX + j * blockSize, offsetY + blockSize + i * blockSize);
                }
                if(cell.hasUpWall()) {
                    // draw horizontal line on the top border of the cell
                    g2.drawLine(offsetX + j * blockSize, offsetY + i * blockSize,
                            offsetX + blockSize + j * blockSize, offsetY + i * blockSize);
                }
            }
        }
    }
}