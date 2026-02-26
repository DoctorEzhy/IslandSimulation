package simulation;

public class Wolf extends Predator {

    public Wolf(Location location) {
        super(location);
        weight = 50;
        foodNeeded = 8;
        speed = 3;
        maxPerCell = 30;

        foodChance.put(Rabbit.class, 60);
        foodChance.put(Mouse.class, 80);
        foodChance.put(Deer.class, 15);
        foodChance.put(Goat.class, 60);
        foodChance.put(Sheep.class, 70);
    }

    public void move() { location.randomMove(this, speed); }
    public void reproduce() { location.tryReproduce(this); }
}
