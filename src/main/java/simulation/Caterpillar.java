package simulation;

public class Caterpillar extends Herbivore {

    public Caterpillar(Location location) {
        super(location);
        weight = 0.01;
        foodNeeded = 0.005;
        speed = 0;
        maxPerCell = 1000;
    }

    @Override
    public void move() {
        // Гусеница не двигается
    }

    @Override
    public void reproduce() {
        location.tryReproduce(this);
    }
}
