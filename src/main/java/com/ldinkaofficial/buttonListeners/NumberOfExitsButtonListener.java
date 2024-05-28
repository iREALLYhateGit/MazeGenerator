package com.ldinkaofficial.buttonListeners;

import com.ldinkaofficial.StartFrame;
import com.ldinkaofficial.exceptions.WrongNumberOfExitsException;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NumberOfExitsButtonListener implements ActionListener {

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
