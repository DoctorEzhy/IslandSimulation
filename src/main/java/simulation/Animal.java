package simulation;

import java.util.concurrent.ThreadLocalRandom;

public abstract class Animal implements Runnable {

    protected double weight;
    protected double foodNeeded;
    protected double foodEaten;

    protected int speed;
    protected int maxPerCell;

    protected boolean alive = true;
    protected Location location;

    public Animal(Location location) {
        this.location = location;
    }

    public abstract void eat();
    public abstract void move();
    public abstract void reproduce();

    protected boolean chance(int percent) {
        return ThreadLocalRandom.current().nextInt(100) < percent;
    }

    public void die() {
        alive = false;
        location.removeAnimal(this);
    }

    @Override
    public void run() {
        if (!alive) return;

        eat();
        move();
        reproduce();

        if (foodEaten < foodNeeded) {
            die();
        }
        foodEaten = 0;
    }
}
