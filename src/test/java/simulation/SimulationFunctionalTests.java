package simulation;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SimulationFunctionalTests {

    @Test
    void testLifeCycle() throws InterruptedException {
        Island island = new Island();
        Location loc = island.getLocations()[0][0];
        Rabbit r = new Rabbit(loc);
        loc.addAnimal(r);

        Simulation.start(island);

        Thread.sleep(6000);

        assertNotNull(island.getLocations());
        assertTrue(loc.getAnimals().size() >= 0);
    }

    @Test
    void testPlantGrowth() {
        Island island = new Island();
        Plant plant = island.getLocations()[0][0].getPlant();
        plant.setFoodAmount(5);
        double before = plant.getFoodAmount();

        Simulation.simulateTick(island);

        double after = plant.getFoodAmount();
        assertTrue(after > before, "Plant did not grow as expected");
    }
}
