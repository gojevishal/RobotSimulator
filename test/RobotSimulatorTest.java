import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import static  org.junit.jupiter.api.Assertions.*;

public class RobotSimulatorTest {
    private RobotSimulator simulator;

    @BeforeEach
    public void setUp(){
        simulator = new RobotSimulator();
    }

    @Test
    public void testPlaceAndMove(){
        simulator.processCommand("PLACE 0,0,NORTH");
        simulator.processCommand("MOVE");
        assertEquals("0,1,NORTH", simulator.robot.report());
    }

    @Test
    public void testLeftTurn(){
        simulator.processCommand("PLACE 0,0,NORTH");
        simulator.processCommand("LEFT");
        assertEquals("0,0,WEST", simulator.robot.report());
    }

    @Test
    public void testRightTurn(){
        simulator.processCommand("PLACE 0,0,NORTH");
        simulator.processCommand("RIGHT");
        assertEquals("0,0,EAST", simulator.robot.report());
    }

    @Test
    public void testRobotMovement(){
        simulator.processCommand("PLACE 1,2,EAST");
        simulator.processCommand("MOVE");
        simulator.processCommand("MOVE");
        simulator.processCommand("LEFT");
        simulator.processCommand("MOVE");
        assertEquals("3,3,NORTH", simulator.robot.report());
    }
}
