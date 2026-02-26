package simulation;

public abstract class Herbivore extends Animal {

    public Herbivore(Location location) {
        super(location);
    }

    @Override
    public void eat() {
        Plant plant = location.getPlant();
        if (plant != null) {
            foodEaten += plant.consume(5);
        }
    }
}
