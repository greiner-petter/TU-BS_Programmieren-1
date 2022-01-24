public class NormalRobot extends Robot implements MapObject {
    /**
    constructs a normal robot with an id
    @param id is the id that is given to the normal robot
    */
    public NormalRobot(int id) {
        super(id);
    }

    /**
    prints the robot id with a "N" infront of it
    @return string - returns that
    */
    public String print() {
        return "N" + getID();
    }
}
