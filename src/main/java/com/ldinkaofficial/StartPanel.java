package com.ldinkaofficial;

import com.ldinkaofficial.buttonListeners.MazeCreateButtonListener;
import com.ldinkaofficial.buttonListeners.MazeSizeXSetButtonListener;
import com.ldinkaofficial.buttonListeners.MazeSizeYSetButtonListener;
import com.ldinkaofficial.buttonListeners.NumberOfExitsButtonListener;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;

public class StartPanel extends JPanel {

    private final StartFrame startFrame;

    public StartPanel(StartFrame startFrame) {
        this.startFrame = startFrame;

        setLayout(new FlowLayout(FlowLayout.CENTER,10,5));
        jButtonsCreation();

        add(mazeSizeXButton);
        add(mazeSizeYButton);
        add(amountOfExitsButton);
        add(createMazeButton, BorderLayout.SOUTH);

        try {
            background = (new ImageIcon(ImageIO.read(
                    new File("C:\\Users\\ПК\\Pictures\\assets\\maze.jpg")))).getImage();

        }catch (Exception ex){

        }
        createMazeButton.addActionListener(new MazeCreateButtonListener(startFrame));

        mazeSizeXButton.addActionListener(new MazeSizeXSetButtonListener(startFrame));
        mazeSizeYButton.addActionListener(new MazeSizeYSetButtonListener(startFrame));

        amountOfExitsButton.addActionListener(new NumberOfExitsButtonListener(startFrame));
    }

    JButton amountOfExitsButton;
    JButton mazeSizeXButton;
    JButton mazeSizeYButton;
    JButton createMazeButton;
    Image background;


    private void jButtonsCreation(){
        amountOfExitsButton = new JButton("Enter amount of exits");
        amountOfExitsButton.setPreferredSize(new Dimension(170,25));
        mazeSizeXButton = new JButton("Set a maze width");
        mazeSizeXButton.setPreferredSize(new Dimension(150,25));
        mazeSizeYButton = new JButton("Set a maze height");
        mazeSizeYButton.setPreferredSize(new Dimension(150,25));
        createMazeButton = new JButton("Create maze");
        createMazeButton.setPreferredSize(new Dimension(120,25));
    }
    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        g.drawImage(background,0,0,getWidth(),getHeight(),null);
    }
}


