package simulation;

public class Bear extends Predator {

    public Bear(Location location) {
        super(location);
        weight = 300;
        foodNeeded = 50;
        speed = 2;
        maxPerCell = 5;

        foodChance.put(Deer.class, 80);
        foodChance.put(Boar.class, 50);
        foodChance.put(Rabbit.class, 80);
    }

    public void move() { location.randomMove(this, speed); }
    public void reproduce() { location.tryReproduce(this); }
}
