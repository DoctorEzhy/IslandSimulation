package simulation;

public class Island {

    private final int WIDTH = 100;
    private final int HEIGHT = 20;

    private Location[][] locations = new Location[WIDTH][HEIGHT];

    public Island() {
        for (int i = 0; i < WIDTH; i++) {
            for (int j = 0; j < HEIGHT; j++) {
                locations[i][j] = new Location();
            }
        }
    }

    public Location[][] getLocations() {
        return locations;
    }
}
