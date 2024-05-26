package com.ldinkaofficial;

import javax.swing.*;
import java.awt.*;

public class MazePanel extends JPanel {


    private final int dims, thickness, margin;
    private Cell [][] cells;

    Labyrinth labyrinth;
    public MazePanel(int dims, int thickness, int margin){
        this.dims = dims;
        this.thickness = thickness;
        this.margin = margin;
        labyrinth = new Labyrinth(dims);
        initCellArray();
    }
    public void paintComponent(Graphics g){

        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;
        BasicStroke stroke = new BasicStroke(thickness);
        g2.setStroke(stroke);

        int blockSize = 10;

        Cell cellsX = null;

        for (int i = 0; i < dims; i++) {
            for (int j = 0; j < dims; j++) {
                cellsX = labyrinth.cellMap.get(new Pair(i,j));
                if(cellsX.hasRightWall()) {
                    // draw vertical line on the right border of the cell
                    g2.drawLine(j * blockSize + blockSize, i * blockSize, blockSize + j * blockSize, blockSize + i * blockSize);
                }
                if(cellsX.hasDownWall()) {
                    // draw horizontal line on the bottom border of the cell
                    g2.drawLine(j * blockSize, i * blockSize + blockSize, j * blockSize + blockSize, i * blockSize + blockSize);
                }
                if(cellsX.hasLeftWall()) {
                    // draw vertical line on the left border of the cell
                    g2.drawLine(j * blockSize, i * blockSize, j * blockSize, blockSize + i * blockSize);
                }
                if(cellsX.hasUpWall()) {
                    // draw horizontal line on the top border of the cell
                    g2.drawLine(j * blockSize, i * blockSize, blockSize + j * blockSize, i * blockSize);
                }
            }
        }
    }

    private void initCellArray(){
        cells = new Cell[dims][dims];
        for(int i = 0; i < dims; i++){
            for(int j = 0; j < dims; j++){
                cells[i][j] = new Cell();
            }
        }
    }

//    public MazePanel createMazePanel() {
//        MazePanel mazePanel = new MazePanel(dims, thickness, margin);
//        mazePanel = new MazePanel(50,1,1);
//        mazePanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10,5));
//        mazePanel.setBackground(Color.GREEN);
//        return mazePanel;
//    }
}