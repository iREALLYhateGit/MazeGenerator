package com.ldinkaofficial.buttonListeners;

import com.ldinkaofficial.StartFrame;
import com.ldinkaofficial.exceptions.UndesiredMazeSizeException;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MazeSizeXSetButtonListener implements ActionListener {

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
