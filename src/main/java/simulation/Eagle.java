package simulation;

public class Eagle extends Predator {

    public Eagle(Location location) {
        super(location);
        weight = 6;
        foodNeeded = 1;
        speed = 3;
        maxPerCell = 20;

        foodChance.put(Mouse.class, 90);
        foodChance.put(Rabbit.class, 30);
        foodChance.put(Duck.class, 80);
    }

    public void move() { location.randomMove(this, speed); }
    public void reproduce() { location.tryReproduce(this); }
}
