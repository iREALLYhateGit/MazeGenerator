package com.ldinkaofficial.buttonListeners;

import com.ldinkaofficial.MazeFrame;
import com.ldinkaofficial.StartFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MazeCreateButtonListener implements ActionListener {

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
        else if (!currentFrame.checkWhetherParametersSetCorrect()) {
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
