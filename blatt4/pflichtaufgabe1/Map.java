public class Map {
    /** creates map size variable */
    private int mapSize;

    /** creates an array with robots */
    private Robot[][] locations;

    /** creates an array with mapobject types */
    private MapObjectType[][] map;

    /**
    constructor creates an empty map and robots and places them randomly on the map and remembers which robot is where
    with the locations array
    @param mapSize sets the map size
    @param numberOfHackedRobots takes in the number of hacked robots
    @param numberOfNormalRobots takes in the number of normal robots
    */
    public Map(int mapSize, int numberOfNormalRobots, int numberOfHackedRobots) {
        this.mapSize = mapSize;
        int totalRobots = numberOfNormalRobots + numberOfHackedRobots;
        map = new MapObjectType[mapSize][mapSize];
        locations = new Robot[mapSize][mapSize];
        Robot[] robots = new Robot[totalRobots + 1];
        for (int x = 0; x < mapSize; x++) {
            for (int y = 0; y < mapSize; y++) {
                map[x][y] = MapObjectType.EMPTY;
            }
        }
        for (int i = 1; i <= totalRobots; i++) {
            if (i <= numberOfNormalRobots) {
                robots[i] = new NormalRobot(i);
            } else {
                robots[i] = new HackedRobot(i);
            }
            boolean success = false;
            while (!success) {
                int xCoordinate = (int) (Math.random() * mapSize);
                int yCoordinate = (int) (Math.random() * mapSize);
                if (map[xCoordinate][yCoordinate] == MapObjectType.EMPTY) {
                    if (i <= numberOfNormalRobots) {
                        map[xCoordinate][yCoordinate] = MapObjectType.NORMAL;
                    } else {
                        map[xCoordinate][yCoordinate] = MapObjectType.HACKED;
                    }
                    locations[xCoordinate][yCoordinate] = robots[i];
                    success = true;
                }
            }
        }
    }

    /**
    method
    @param x cooridate of array field that is being checked
    @param y cooridate of array field that is being checked
    @return MapObjectType - returns the object that is on that field
    */
    public MapObjectType checkCoordinates(int x, int y) {
        return map[x][y];
    }

    /**
    method
    @param x cooridate of the robot on the map
    @param y cooridate of the robot on the map
    @return Robot - returns the robot that is on that field
    */
    public Robot getCoordinates(int x, int y) {
        return locations[x][y];
    }

    public MapObjectType[][] getMap() {
        return map;
    }

    public Robot[][] getLocations() {
        return locations;
    }

    /**
    prints the map out the the console with a nice border
    @return empty string because otherwise the toString method cannot be overridden
    */
    public String toString() {
        for (int i = 0; i < mapSize; i++) {
            System.out.print("__");
        }
        System.out.println("__");
        for (int  x = 0; x < mapSize; x++) {
            System.out.print("|");
            for (int  y = 0; y < mapSize; y++) {
                if (map[x][y] == MapObjectType.NORMAL || map[x][y] == MapObjectType.HACKED) {
                    System.out.print(locations[x][y].print());
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println("|");
        }
        for (int i = 0; i < mapSize; i++) {
            System.out.print("¯¯");
        }
        System.out.println("¯¯");
        return "";
    }
}
