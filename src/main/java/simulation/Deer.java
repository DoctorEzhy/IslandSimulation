package simulation;

public class Deer extends Herbivore {

    public Deer(Location location) {
        super(location);
        weight = 300;
        foodNeeded = 50;
        speed = 4;
        maxPerCell = 20;
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
