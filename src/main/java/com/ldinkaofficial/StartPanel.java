package com.ldinkaofficial;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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


class MazeCreateButtonListener implements ActionListener {

    private StartFrame currentFrame;
    public MazeCreateButtonListener(StartFrame currentFrame) {
        this.currentFrame = currentFrame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(MazeFrame.isDisplayed()){
            JOptionPane.showMessageDialog(currentFrame,"Frame with maze is already exists",
                    "Alert", JOptionPane.WARNING_MESSAGE);
        }
        else if (!currentFrame.checkWhetherParametersSet()) {
            JOptionPane.showMessageDialog(currentFrame,"You should enter parameters of maze " +
                    "before creating one", "Alert", JOptionPane.WARNING_MESSAGE);
        }
        else{
            SwingUtilities.invokeLater(
                    ()-> {
                        new MazeFrame(currentFrame.getMazeSizeX(),currentFrame.getMazeSizeY(),
                                currentFrame.getNumberOfExits());
                        MazeFrame.setDisplayed(true);
                    });
        }
    }
}




class MazeSizeXSetButtonListener implements ActionListener {

    private StartFrame currentFrame;
    public MazeSizeXSetButtonListener(StartFrame currentFrame) {
        this.currentFrame = currentFrame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int gotMazeSizeX = 0;
        try{
            gotMazeSizeX = Integer.parseInt(JOptionPane.showInputDialog("Enter the width of the maze"));
            try{
                if(gotMazeSizeX < 2 || gotMazeSizeX > 1000){
                    throw new UndesiredMazeSizeException();
                }
                else{
                    currentFrame.setMazeSizeX(gotMazeSizeX);
                }
            }catch (UndesiredMazeSizeException ex){
                JOptionPane.showMessageDialog(currentFrame,"Wrong size of maze."
                                + " The size should be between 2 and 1000.",
                        "Alert",JOptionPane.WARNING_MESSAGE);
            }
        }catch (NumberFormatException ex){
            JOptionPane.showMessageDialog(currentFrame,"Wrong format, number should be entered",
                    "Alert",JOptionPane.WARNING_MESSAGE);
        }
    }
}



class MazeSizeYSetButtonListener implements ActionListener {

    private StartFrame currentFrame;
    public MazeSizeYSetButtonListener(StartFrame currentFrame) {
        this.currentFrame = currentFrame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int gotMazeSizeY = 0;
        try{
            gotMazeSizeY = Integer.parseInt(JOptionPane.showInputDialog("Enter the height of the maze"));
            try{
                if(gotMazeSizeY < 2 || gotMazeSizeY > 1000){
                    throw new UndesiredMazeSizeException();
                }
                else{
                    currentFrame.setMazeSizeY(gotMazeSizeY);
                }
            }catch (UndesiredMazeSizeException ex){
                JOptionPane.showMessageDialog(currentFrame,"Wrong size of maze."
                                + " The size should be between 2 and 1000.",
                        "Alert",JOptionPane.WARNING_MESSAGE);
            }
        }catch (NumberFormatException ex){
            JOptionPane.showMessageDialog(currentFrame,"Wrong format, number should be entered",
                    "Alert",JOptionPane.WARNING_MESSAGE);
        }
    }
}



class NumberOfExitsButtonListener implements ActionListener {

    private StartFrame currentFrame;
    public NumberOfExitsButtonListener(StartFrame currentFrame) {
        this.currentFrame = currentFrame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int gotAmountOfExits = 0;
        try{
            gotAmountOfExits = Integer.parseInt(JOptionPane.showInputDialog("Enter number of exits"));
            try{
                if(gotAmountOfExits <= 0 || gotAmountOfExits >= currentFrame.getMazeSizeX()
                        + currentFrame.getMazeSizeY()){
                    throw new WrongNumberOfExitsException();
                }
                else{
                    currentFrame.setNumberOfExits(gotAmountOfExits);
                }
            }catch (WrongNumberOfExitsException ex){
                JOptionPane.showMessageDialog(currentFrame,"Wrong number of exits. The number" +
                                " should be greater than 0 and less than maze size multiplied by 2",
                        "Alert", JOptionPane.WARNING_MESSAGE);
            }
        }catch (NumberFormatException ex){
            JOptionPane.showMessageDialog(currentFrame,"Wrong format, number should be entered",
                    "Alert",JOptionPane.WARNING_MESSAGE);
        }
    }
}

class WrongNumberOfExitsException extends RuntimeException {
}
class UndesiredMazeSizeException extends RuntimeException {
}
