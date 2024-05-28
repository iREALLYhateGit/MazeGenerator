import com.ldinkaofficial.Labyrinth;
import com.ldinkaofficial.Pair;
import com.ldinkaofficial.StartFrame;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class Tester extends Assertions {

    @Test
    void testParametersSet1(){
        StartFrame startFrame = new StartFrame();
        startFrame.setMazeSizeX(7);
        startFrame.setMazeSizeY(5);
        startFrame.setNumberOfExits(4);
        assertTrue(startFrame.checkWhetherParametersSetCorrect());
    }
    @Test
    void testParametersSet2(){
        StartFrame startFrame = new StartFrame();
        startFrame.setMazeSizeX(0);
        startFrame.setMazeSizeY(5);
        startFrame.setNumberOfExits(4);
        assertFalse(startFrame.checkWhetherParametersSetCorrect());
    }
    @Test
    void testParametersSet3(){
        StartFrame startFrame = new StartFrame();
        startFrame.setMazeSizeX(7);
        startFrame.setMazeSizeY(0);
        startFrame.setNumberOfExits(4);
        assertFalse(startFrame.checkWhetherParametersSetCorrect());
    }
    @Test
    void testParametersSet4(){
        StartFrame startFrame = new StartFrame();
        startFrame.setMazeSizeX(4);
        startFrame.setMazeSizeY(5);
        startFrame.setNumberOfExits(0);
        assertFalse(startFrame.checkWhetherParametersSetCorrect());
    }

    @Test
    void testMazeSize(){
        int width = 10;
        int height = 10;
        int numberOfExits = 10;
        Labyrinth labyrinth = new Labyrinth(width,height,10);
        assertEquals(labyrinth.cellMap.size(), width * height);
    }
    @Test
    void testMazeSize2(){
        int width = 10;
        int height = 10;
        int numberOfExits = 10;
        Labyrinth labyrinth = new Labyrinth(9,height,10);
        assertNotEquals(labyrinth.cellMap.size(), width * height);
    }
    @Test
    void testExitNumbers(){
        int mazeSizeX = 10;
        int mazeSizeY = 10;
        int numberOfExits = 8;
        Labyrinth labyrinth = new Labyrinth(mazeSizeX,mazeSizeY,numberOfExits);
        labyrinth.fillMaze();
        labyrinth.generateMaze();
        int counter = 0;
        for (int j = 0; j < mazeSizeX; j++) {
            if(!labyrinth.cellMap.get(new Pair(0,j)).hasUpWall()){
                counter++;
            }
            if(!labyrinth.cellMap.get(new Pair(mazeSizeY - 1,j)).hasDownWall()){
                counter++;
            }
        }
        for (int i = 0; i < mazeSizeY; i++) {
            if(!labyrinth.cellMap.get(new Pair(i,0)).hasLeftWall()){
                counter++;
            }
            if(!labyrinth.cellMap.get(new Pair(i,mazeSizeX - 1)).hasRightWall()){
                counter++;
            }
        }
        assertEquals(numberOfExits, counter);
    }


//    @Test
//    void testGenerateMaze(){
//        assertThrowsExactly(java.lang.IllegalArgumentException.class,new Executable() {
//            @Override
//            public void execute() throws Throwable {
//                new Labyrinth(0, 0, 10);
//            }
//        });
//    }
//
//    @Test
//    void testGenerateMazeExc(){
//        assertDoesNotThrow(new Executable() {
//            @Override
//            public void execute() throws Throwable {
//                new Labyrinth(10, 10, 10);
//            }
//        });
//    }

}
