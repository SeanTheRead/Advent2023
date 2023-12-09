package aoc.objects;

public class Elevator {
    private int floor;

    /**
     * Default constructor
     * Sets floor to default of 0
     */
    public Elevator(){
        this.floor = 0;
    }

    /**
     * Creates object with a specific starting floor
     * @param startFloor
     */
    public Elevator(int startFloor){
        this.floor = startFloor;
    }

    /**
     * Go up floorsTraversed number of floors
     * @param floorsTraversed
     */
    public void takeElevatorUp(int floorsTraversed){
        this.floor+=floorsTraversed;
    }

    /**
     * Go down floorsTraversed number of floors
     * @param floorsTraversed
     */
    public void takeElevatorDown(int floorsTraversed){
        this.floor-=floorsTraversed;
    }

    /**
     * traverse a floor according to char input
     * @param direction
     */
    public void takeElevator(char direction){
        if(direction == '('){
            this.takeElevatorUp(1);
        } else if (direction==')') {
            this.takeElevatorDown(1);
        }
    }

    /**
     *
     * @return current floor
     */
    public int getCurrentFloor(){
        return this.floor;
    }
}
