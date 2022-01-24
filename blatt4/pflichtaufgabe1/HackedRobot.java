public class HackedRobot extends Robot implements MapObject {
    /**
    constructs a hacked robot with an id
    @param id is the id that is given to the hacked robot
    */
    public HackedRobot(int id) {
        super(id);
    }

    /**
    prints the robot id with a "H" infront of it
    @return string - returns that
    */
    public String print() {
        return "H" + getID();
    }

    /**
    trys to hack a given normal robot with a 1/7 chance of succeeding
    @param robotBeingHacked is the normal robot that is being hacked
    @return success - returns if the hack was successful or not
    */
    public Boolean tryHack(Robot robotBeingHacked) {
        int guess = (int) (Math.random() * 6 + 1);
        boolean success = false;
        if (guess == robotBeingHacked.getID()) {
            success = true;
        }
        return success;
    }
}
