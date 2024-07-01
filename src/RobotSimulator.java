import java.awt.*;
import java.util.Scanner;

public class RobotSimulator {
    protected Robot robot;

    //Constructor
    public RobotSimulator(){
        this.robot = new Robot();
    }

    // Process the single command
    public void processCommand(String command){
        String[] parts = command.split(" ");
        switch (parts[0].toUpperCase()){
            case "PLACE":
                if(parts.length != 2) break;

                String[] params = parts[1].split(",");
                if(params.length != 3) break;
                try{
                    int x = Integer.parseInt(params[0]);
                    int y = Integer.parseInt(params[1]);
                    Direction facing = Direction. valueOf(params[2].toUpperCase());
                    robot.place(x,y,facing);
                }catch (IllegalArgumentException ex){
                    System.out.println("Invalid PLACE command");
                }
                break;
            case"MOVE":
                robot.move();
                break;
            case "LEFT":
                robot.left();
                break;
            case "RIGHT":
                robot.right();
            case "REPORT":
                System.out.println(robot.report());
                break;
            default:
                System.out.println("Invalid command!");
        }

    }
    public static void main(String[] args) {
        RobotSimulator simulator = new RobotSimulator();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the command (Enter 'X' to exit):");

        while (true){
            String command = scanner.nextLine().trim(); // trim the input
            if(command.equalsIgnoreCase("X")) break;
            simulator.processCommand(command);
        }

    }
}