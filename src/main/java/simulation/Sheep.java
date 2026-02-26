package simulation;

public class Sheep extends Herbivore {

    public Sheep(Location location) {
        super(location);
        weight = 70;
        foodNeeded = 15;
        speed = 3;
        maxPerCell = 140;
    }

    @Override
    public void move() {
        location.randomMove(this, speed);
    }

    @Override
    public void reproduce() {
        location.tryReproduce(this);
    }
}
