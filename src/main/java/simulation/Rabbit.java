package simulation;

public class Rabbit extends Herbivore {
    public Rabbit(Location location) {
        super(location);
        weight = 2;
        foodNeeded = 0.5;
        speed = 2;
        maxPerCell = 150;
    }

    public void move() { location.randomMove(this, speed); }
    public void reproduce() { location.tryReproduce(this); }
}
