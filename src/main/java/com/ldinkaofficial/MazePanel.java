package com.ldinkaofficial;

import javax.swing.*;
import java.awt.*;

public class MazePanel extends JPanel {

    private JScrollPane scrollPane;
    private JPanel scrollPanel;
    private JButton btnAddPage;


    private final int mazeSize, thickness, blockSize, offset, numberOfExits;

    private final Labyrinth labyrinth;

    public MazePanel(int mazeSize, int thickness, int blockSize, int offset, int numberOfExits){
        this.mazeSize = mazeSize;
        this.thickness = thickness;
        this.blockSize = blockSize;
        this.offset = offset;
        this.numberOfExits = numberOfExits;
        labyrinth = new Labyrinth(mazeSize, numberOfExits);

    }
    @Override
    public void paintComponent(Graphics g){

        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;
        BasicStroke stroke = new BasicStroke(thickness);
        g2.setStroke(stroke);

        Cell cell = null;

        for (int i = 0; i < mazeSize; i++) {
            for (int j = 0; j < mazeSize; j++) {
                cell = labyrinth.cellMap.get(new Pair(i,j));
                if(cell.hasRightWall()) {
                    // draw vertical line on the right border of the cell
                    g2.drawLine(offset + j * blockSize + blockSize, offset + i * blockSize, offset + blockSize + j * blockSize, offset + blockSize + i * blockSize);
                }
                if(cell.hasDownWall()) {
                    // draw horizontal line on the bottom border of the cell
                    g2.drawLine(offset + j * blockSize, offset + i * blockSize + blockSize, offset + j * blockSize + blockSize, offset + i * blockSize + blockSize);
                }
                if(cell.hasLeftWall()) {
                    // draw vertical line on the left border of the cell
                    g2.drawLine(offset + j * blockSize, offset + i * blockSize, offset + j * blockSize, offset + blockSize + i * blockSize);
                }
                if(cell.hasUpWall()) {
                    // draw horizontal line on the top border of the cell
                    g2.drawLine(offset + j * blockSize, offset + i * blockSize, offset + blockSize + j * blockSize, offset + i * blockSize);
                }
            }
        }
//        g2.drawLine(20,0,20,100);
//        g2.drawLine(300,0,300,100);
    }
}