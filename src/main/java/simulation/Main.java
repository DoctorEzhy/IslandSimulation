package simulation;

public class Main {

    public static void main(String[] args) {

        Island island = new Island();

        Location[][] locations = island.getLocations();

        locations[0][0].addAnimal(new Wolf(locations[0][0]));
        locations[0][0].addAnimal(new Rabbit(locations[0][0]));
        locations[0][0].addAnimal(new Rabbit(locations[0][0]));
        locations[0][0].addAnimal(new Fox(locations[0][0]));
        locations[0][0].addAnimal(new Mouse(locations[0][0]));
        locations[0][0].addAnimal(new Bear(locations[0][0]));
        locations[0][0].addAnimal(new Boar(locations[0][0]));
        locations[0][0].addAnimal(new Duck(locations[0][0]));
        locations[0][0].addAnimal(new Caterpillar(locations[0][0]));

        Simulation.start(island);
    }
}
