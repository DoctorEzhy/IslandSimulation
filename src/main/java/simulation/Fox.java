package simulation;

public class Fox extends Predator {

    public Fox(Location location) {
        super(location);
        weight = 8;
        foodNeeded = 2;
        speed = 2;
        maxPerCell = 30;

        foodChance.put(Rabbit.class, 70);
        foodChance.put(Mouse.class, 90);
        foodChance.put(Duck.class, 60);
    }

    public void move() { location.randomMove(this, speed); }
    public void reproduce() { location.tryReproduce(this); }
}
