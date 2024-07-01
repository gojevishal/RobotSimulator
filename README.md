# RobotSimulator

## Description

This project implements a simulation of a toy robot moving on a square tabletop of dimensions 5 units x 5 units. The robot is free to roam around the surface of the table but must be prevented from falling to destruction. Any movement that would result in the robot falling from the table must be prevented, however further valid movement commands must still be allowed.

## Commands

The application can read in commands of the following form:

- PLACE X,Y,F
- MOVE
- LEFT
- RIGHT
- REPORT

PLACE will put the toy robot on the table in position X,Y and facing NORTH, SOUTH, EAST or WEST.
The origin (0,0) can be considered to be the SOUTH WEST most corner.

MOVE will move the toy robot one unit forward in the direction it is currently facing.

LEFT and RIGHT will rotate the robot 90 degrees in the specified direction without changing the position of the robot.

REPORT will announce the X,Y and F of the robot.

## Constraints

- The toy robot must not fall off the table during movement. This also includes the initial placement of the toy robot.
- Any move that would cause the robot to fall must be ignored.

## How to Run

1. Compile the Java files:
 ```
  javac Robot.java Direction.java RobotSimulator.java
```
2. Run the simulator:
```
  java RobotSimulator
```
3. Enter commands when prompted. Type 'EXIT' to quit the program.
```
## Example
Enter commands (type 'EXIT' to quit):
PLACE 1,2,EAST
MOVE
MOVE
LEFT
MOVE
REPORT
3,3,NORTH
EXIT
```
## Running Tests

To run the JUnit tests:

1. Ensure you have JUnit 5 in your classpath.
2. Compile the test file:
```
   javac -cp .:path/to/junit.jar RobotSimulatorTest.java
```
3. Run the tests:
```
  java -jar path/to/junit-platform-console-standalone.jar --class-path . --scan-class-path
```
Replace `path/to/junit.jar` and `path/to/junit-platform-console-standalone.jar` with the actual paths to your JUnit JAR files.

## Project Structure

- `Robot.java`: Represents the robot and its movements
- `Direction.java`: Enum for the four directions
- `RobotSimulator.java`: Main class for processing commands and user interaction
- `RobotSimulatorTest.java`: JUnit tests for the simulator
