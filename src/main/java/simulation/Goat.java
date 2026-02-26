package simulation;

public class Goat extends Herbivore {

    public Goat(Location location) {
        super(location);
        weight = 60;
        foodNeeded = 10;
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