package simulation;

public class Boar extends Herbivore {

    public Boar(Location location) {
        super(location);
        weight = 150;
        foodNeeded = 20;
        speed = 2;
        maxPerCell = 50;
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
