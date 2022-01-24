public class GameMaster {
    /** sets the map size */
    private static int mapSize = 20;

    /** sets the number of hacked robots */
    private static int numberOfHackedRobots = 2;

    /** sets the number of normal robots */
    private static int numberOfNormalRobots = 5;

    /** adds together the total number of hacked and normal robots */
    private static int totalRobots = numberOfHackedRobots + numberOfNormalRobots;

    public static void main(String[] args) {
        Map map = new Map(mapSize, numberOfNormalRobots, numberOfHackedRobots);
        gameLoop(map);
    }

    /**
    main game loop
    @param map created in the main method
    */
    public static void gameLoop(Map map) {
        boolean allHacked = false;
        int day = 0;
        while (!allHacked) {
            for (int x = 0; x < mapSize; x++) {
                for (int y = 0; y < mapSize; y++) {
                    if (map.checkCoordinates(x, y) == MapObjectType.HACKED) {
                        for (int x2 = x - 3; x2 <= x + 3; x2++) {
                            for (int y2 = y - 3; y2 <= y + 3; y2++) {
                                try {
                                    if (map.checkCoordinates(x2, y2) == MapObjectType.NORMAL) {
                                        if (map.getCoordinates(x, y).tryHack(map.getCoordinates(x2, y2))) {
                                            map.getLocations()[x2][y2] =
                                                new HackedRobot(map.getCoordinates(x2, y2).getID());
                                            map.getMap()[x2][y2] = MapObjectType.HACKED;
                                            numberOfHackedRobots++;
                                        }
                                    }
                                } catch (ArrayIndexOutOfBoundsException e) { }
                            }
                        }
                    }
                }
            }
            for (int x = 0; x < mapSize; x++) {
                for (int y = 0; y < mapSize; y++) {
                    if (map.checkCoordinates(x, y) == MapObjectType.HACKED
                        || map.checkCoordinates(x, y) == MapObjectType.NORMAL) {
                        int randomNumber = (int) (Math.random() * 3 + 1);
                        switch (randomNumber) {
                            case 1:
                                try {
                                    if (map.checkCoordinates(x - 1, y) == MapObjectType.EMPTY) {
                                        map.getMap()[x - 1][y] = map.getMap()[x][y];
                                        map.getMap()[x][y] = MapObjectType.EMPTY;
                                        map.getLocations()[x - 1][y] = map.getLocations()[x][y];
                                        map.getLocations()[x][y] = null;
                                    }
                                } catch (ArrayIndexOutOfBoundsException e) { }
                            //fix double movement1!!1
                            case 2:
                                try {
                                    if (map.checkCoordinates(x, y + 1) == MapObjectType.EMPTY) {
                                        map.getMap()[x][y + 1] = map.getMap()[x][y];
                                        map.getMap()[x][y] = MapObjectType.EMPTY;
                                        map.getLocations()[x][y + 1] = map.getLocations()[x][y];
                                        map.getLocations()[x][y] = null;
                                    }
                                } catch (ArrayIndexOutOfBoundsException e) { }
                            //fix double movement!!! entwered enums oder 3. array
                            case 3:
                                try {
                                    if (map.checkCoordinates(x + 1, y) == MapObjectType.EMPTY) {
                                        map.getMap()[x + 1][y] = map.getMap()[x][y];
                                        map.getMap()[x][y] = MapObjectType.EMPTY;
                                        map.getLocations()[x + 1][y] = map.getLocations()[x][y];
                                        map.getLocations()[x][y] = null;
                                    }
                                } catch (ArrayIndexOutOfBoundsException e) { }
                            case 4:
                                try {
                                    if (map.checkCoordinates(x, y - 1) == MapObjectType.EMPTY) {
                                        map.getMap()[x][y - 1] = map.getMap()[x][y];
                                        map.getMap()[x][y] = MapObjectType.EMPTY;
                                        map.getLocations()[x][y - 1] = map.getLocations()[x][y];
                                        map.getLocations()[x][y] = null;
                                    }
                                } catch (ArrayIndexOutOfBoundsException e) { }
                        }
                    }
                }
            }
            System.out.println("Day: " + day);
            map.toString();
            if (numberOfHackedRobots == totalRobots) {
                allHacked = true;
            }
            day++;
        }
    }
}
