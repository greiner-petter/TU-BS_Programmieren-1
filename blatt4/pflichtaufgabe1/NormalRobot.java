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

    /**
    empty method because robot passes through this method to all children
    @param robotBeingHacked placeholder
    @return boolean
    */
    public Boolean tryHack(Robot robotBeingHacked) {
        return false;
    }
}
