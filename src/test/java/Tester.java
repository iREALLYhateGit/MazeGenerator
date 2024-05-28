import com.ldinkaofficial.Labyrinth;
import com.ldinkaofficial.MazeFrame;
import com.ldinkaofficial.StartFrame;
import com.ldinkaofficial.StartPanel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

public class Tester extends Assertions {
    @Test
    void testGenerateMaze(){
        assertThrowsExactly(java.lang.IllegalArgumentException.class,new Executable() {
            @Override
            public void execute() throws Throwable {
                new Labyrinth(0, 0, 10);
            }
        });
    }
    @Test
    void testParametersSet1(){
        StartFrame startFrame = new StartFrame();
        startFrame.setMazeSizeX(7);
        startFrame.setMazeSizeY(5);
        startFrame.setNumberOfExits(4);
        assertTrue(startFrame.checkWhetherParametersSet());
    }
    @Test
    void testParametersSet2(){
        StartFrame startFrame = new StartFrame();
        startFrame.setMazeSizeX(0);
        startFrame.setMazeSizeY(5);
        startFrame.setNumberOfExits(4);
        assertFalse(startFrame.checkWhetherParametersSet());
    }
    @Test
    void testParametersSet3(){
        StartFrame startFrame = new StartFrame();
        startFrame.setMazeSizeX(7);
        startFrame.setMazeSizeY(0);
        startFrame.setNumberOfExits(4);
        assertFalse(startFrame.checkWhetherParametersSet());
    }
    @Test
    void testParametersSet4(){
        StartFrame startFrame = new StartFrame();
        startFrame.setMazeSizeX(4);
        startFrame.setMazeSizeY(5);
        startFrame.setNumberOfExits(0);
        assertFalse(startFrame.checkWhetherParametersSet());
    }
}
