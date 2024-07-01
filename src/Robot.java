public class Robot {

    private int x; // x- axis position
    private int y; // y- axis position

    private  Direction facing; // Robot direction it is facing

    private  boolean isPlaced = false; // Flag to tell if robot is placed on table

    // Place robot on table
    public void place(int x, int y, Direction facing){
        // Only place the robot if position is valid
        if(isValidPosition(x,y)){
            this.x = x;
            this.y = y;
            this.facing = facing;
            this.isPlaced = true;
        }
    }

    public void  move(){
        // Ignore the command if the robot is not placed on table
        if(!isPlaced) return;

        // Calculate the new position
        int newX = x;
        int newY = y;

        switch (facing){
            case NORTH -> {
                newY++;
            }
            case EAST -> {
                newX++;
            }
            case SOUTH -> {
                newY--;
            }
            case WEST -> {
                newX--;
            }
        }

        // Update the position if it is valid
        if(isValidPosition(newX, newY)){
            x = newX;
            y = newY;
        }
    }

    // Rotate robot to 90 degree left
    public void left(){
        if(!isPlaced) return;
        facing = facing.turnLeft();
    }

    // Rotate robot to 90 degree right
    public void right(){
        if(!isPlaced) return;
        facing = facing.turnRight();
    }

    // Report the current position and direction of robot
    public String report(){
        if(!isPlaced) return "Robot not placed yet";
        return x +"," + y + "," + facing;
    }
    private boolean isValidPosition(int x, int y) {
        return x >= 0 && x <5 && y >=0 && y <5;
    }

    // Check if the robot is placed on table
    public boolean isPlaced() {
        return isPlaced;
    }
}
