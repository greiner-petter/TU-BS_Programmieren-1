abstract class Robot {
    /** the variable id which hold the id of the robot */
    private int id;

    /**
    constructs a robot with the id that is parsed
    @param id is the id that is parsed
    */
    public Robot(int id) {
        this.id = id;
    }

    /**
    passthrough method to access the print function in the hacked and normal robot classes
    @return string
    */
    public abstract String print();

    /**
    passthrough method to access the tryhack function in the hacked robot
    @param robotBeingHacked is the robot that is being hacked
    @return boolean - returns if the hack was successful or not
    */
    public abstract Boolean tryHack(Robot robotBeingHacked);

    public int getID() {
        return id;
    }

    /**
    overrides the tostring method because the task said so
    @return string of the id of the robot
    */
    public String toString() {
        return Integer.toString(id);
    }
}
