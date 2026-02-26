package simulation;

public class Mouse extends Herbivore {

    public Mouse(Location location) {
        super(location);
        weight = 0.05;
        foodNeeded = 0.01;
        speed = 1;
        maxPerCell = 500;
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
