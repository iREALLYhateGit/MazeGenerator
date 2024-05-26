package com.ldinkaofficial;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class StartFrame extends JFrame {

    public final static int WRONG_MAZE_SIZE = 0;

    private JPanel jpanel;
    private static int mazeSize = WRONG_MAZE_SIZE;
    private int amountOfExits;

    public StartFrame() {
        startFrameInitialize();
        jpanelInitialize();
    }
    private void startFrameInitialize() {
        setTitle("Start Frame");
        setSize(600,600);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    private void jpanelInitialize() {

        jpanel = new JPanel();
        jpanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10,5));
        jpanel.setBackground(Color.GREEN);

        JButton amountOfExitsButton = new JButton("Enter amount of exits");
        JButton mazeSizeButton = new JButton("Set a maze size");
        JButton createMazeButton = new JButton("create maze");


//        JLabel loading = new JLabel("Loading");
//        try {
//            ImageIcon loadingImage = new ImageIcon(ImageIO.read(new File("C:\\Users\\ПК\\Pictures\\assets\\loading.jpg")));
//            loading = new JLabel(loadingImage);
//        } catch (IOException e) {
//        }
        jpanel.add(amountOfExitsButton);
        jpanel.add(mazeSizeButton);
        jpanel.add(createMazeButton);
        add(jpanel);

        createMazeButton.addActionListener(new MazeCreateButtonListener(this));

        mazeSizeButton.addActionListener(new MazeSizeSetButtonListener(this));

    }
    public boolean checkWhetherParametersSet(){
        if(mazeSize == WRONG_MAZE_SIZE){
            return false;
        }
        else return true;
    }

    public static int getMazeSize() {
        return mazeSize;
    }

    public static void setMazeSize(int mazeSize) {
        StartFrame.mazeSize = mazeSize;
    }
}
class MazeCreateButtonListener implements ActionListener {

    StartFrame currentFrame;
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
                        new MazeFrame(StartFrame.getMazeSize());
                        MazeFrame.setDisplayed(true);
                    });
        }
    }
}




class MazeSizeSetButtonListener implements ActionListener {

    StartFrame currentFrame;
    public MazeSizeSetButtonListener(StartFrame currentFrame) {
        this.currentFrame = currentFrame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int gotMazeSize;
        try{
            gotMazeSize = Integer.parseInt(JOptionPane.showInputDialog("Enter a maze size"));
            StartFrame.setMazeSize(gotMazeSize);
        }catch (NumberFormatException ex){
            JOptionPane.showMessageDialog(currentFrame,"Wrong format, number should be entered",
                    "Alert",JOptionPane.WARNING_MESSAGE);
        }
    }
}
