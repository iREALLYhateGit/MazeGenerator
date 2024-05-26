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

        add(amountOfExitsButton);
        add(mazeSizeButton);
        add(createMazeButton, BorderLayout.SOUTH);

        try {
            background = (new ImageIcon(ImageIO.read(
                    new File("C:\\Users\\ПК\\Pictures\\assets\\maze.jpg")))).getImage();

        }catch (Exception ex){

        }
        createMazeButton.addActionListener(new MazeCreateButtonListener(startFrame));

        mazeSizeButton.addActionListener(new MazeSizeSetButtonListener(startFrame));

        amountOfExitsButton.addActionListener(new AmountOfExitsButtonListener(startFrame));
    }

    JButton amountOfExitsButton;
    JButton mazeSizeButton;
    JButton createMazeButton;
    Image background;


    private void jButtonsCreation(){
        amountOfExitsButton = new JButton("Enter amount of exits");
        amountOfExitsButton.setPreferredSize(new Dimension(170,30));
        mazeSizeButton = new JButton("Set a maze size");
        mazeSizeButton.setPreferredSize(new Dimension(150,30));
        createMazeButton = new JButton("Create maze");
        createMazeButton.setPreferredSize(new Dimension(120,30));
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
        else if (currentFrame.checkWhetherParametersSet()) {
            JOptionPane.showMessageDialog(currentFrame,"You should enter parameters of maze " +
                    "before creating one", "Alert", JOptionPane.WARNING_MESSAGE);
        }
        else{
            SwingUtilities.invokeLater(
                    ()-> {
                        new MazeFrame(currentFrame.getMazeSize(), currentFrame.getAmountOfExits());
                        MazeFrame.setDisplayed(true);
                    });
        }
    }
}




class MazeSizeSetButtonListener implements ActionListener {

    private StartFrame currentFrame;
    public MazeSizeSetButtonListener(StartFrame currentFrame) {
        this.currentFrame = currentFrame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int gotMazeSize = 0;
        try{
            gotMazeSize = Integer.parseInt(JOptionPane.showInputDialog("Enter a maze size"));
            try{
                if(gotMazeSize < 2 || gotMazeSize > 1000){
                    throw new UndesiredMazeSizeException();
                }
                else{
                    currentFrame.setMazeSize(gotMazeSize);
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



class AmountOfExitsButtonListener implements ActionListener {

    private StartFrame currentFrame;
    public AmountOfExitsButtonListener(StartFrame currentFrame) {
        this.currentFrame = currentFrame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int gotAmountOfExits = 0;
        try{
            gotAmountOfExits = Integer.parseInt(JOptionPane.showInputDialog("Enter a maze size"));
            try{
                if(gotAmountOfExits <= 0 || gotAmountOfExits >= currentFrame.getMazeSize() *2){
                    throw new WrongNumberOfExitsException();
                }
                else{
                    currentFrame.setAmountOfExits(gotAmountOfExits);
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
