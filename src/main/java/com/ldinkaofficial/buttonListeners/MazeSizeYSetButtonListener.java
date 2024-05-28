package com.ldinkaofficial.buttonListeners;

import com.ldinkaofficial.StartFrame;
import com.ldinkaofficial.exceptions.UndesiredMazeSizeException;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MazeSizeYSetButtonListener implements ActionListener {

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
