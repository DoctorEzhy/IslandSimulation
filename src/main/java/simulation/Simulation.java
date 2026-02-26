package simulation;

import java.util.concurrent.*;

public class Simulation {

    private static ScheduledExecutorService scheduler =
            Executors.newScheduledThreadPool(3);

    private static ExecutorService animalPool =
            Executors.newFixedThreadPool(8);

    public static void start(Island island) {

        scheduler.scheduleAtFixedRate(() -> {
            for (Location[] row : island.getLocations()) {
                for (Location loc : row) {
                    loc.getPlant().grow();
                }
            }
        }, 0, 2, TimeUnit.SECONDS);

        scheduler.scheduleAtFixedRate(() -> {
            for (Location[] row : island.getLocations()) {
                for (Location loc : row) {
                    for (Animal animal : loc.getAnimals().toArray(new Animal[0])) {
                        animalPool.submit(animal);
                    }
                }
            }
        }, 0, 1, TimeUnit.SECONDS);

        scheduler.scheduleAtFixedRate(() -> {
            printStats(island);
        }, 0, 3, TimeUnit.SECONDS);
    }

    public static void simulateTick(Island island) {
        for (Location[] row : island.getLocations()) {
            for (Location loc : row) {
                loc.getPlant().grow();
                for (Animal animal : loc.getAnimals().toArray(new Animal[0])) {
                    animal.run();
                }
            }
        }
    }

    private static void printStats(Island island) {
        int total = 0;

        for (Location[] row : island.getLocations()) {
            for (Location loc : row) {
                total += loc.getAnimals().size();
            }
        }

        System.out.println("Total animals: " + total);
    }

    public static void stop() {
        scheduler.shutdownNow();
        animalPool.shutdownNow();
    }
}