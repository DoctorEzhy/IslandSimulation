package simulation;

public class Snake extends Predator {

    public Snake(Location location) {
        super(location);
        weight = 15;
        foodNeeded = 3;
        speed = 1;
        maxPerCell = 30;

        foodChance.put(Mouse.class, 40);
        foodChance.put(Rabbit.class, 20);
        foodChance.put(Duck.class, 10);
    }

    public void move() { location.randomMove(this, speed); }
    public void reproduce() { location.tryReproduce(this); }
}

