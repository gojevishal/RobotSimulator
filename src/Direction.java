public enum Direction {
    NORTH,SOUTH,EAST,WEST;

    // Rotate 90 degree to left
    public Direction turnLeft(){
        return values()[(ordinal() + 3) %4];
    }

    // Rotate 90 degree to right
    public Direction turnRight(){
        return values()[(ordinal() + 1) %4];
    }
}