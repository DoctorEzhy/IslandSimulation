package simulation;

import java.util.HashMap;
import java.util.Map;

public class Duck extends Herbivore {

    private Map<Class<? extends Animal>, Integer> extraFoodChance = new HashMap<>();

    public Duck(Location location) {
        super(location);
        weight = 1;
        foodNeeded = 0.3;
        speed = 4;
        maxPerCell = 200;

        extraFoodChance.put(Caterpillar.class, 90);
    }

    @Override
    public void eat() {
        super.eat();

        for (Animal animal : location.getAnimals()) {
            if (animal instanceof Caterpillar) {
                int chance = extraFoodChance.get(Caterpillar.class);
                if (chance(chance)) {
                    foodEaten += animal.weight;
                    animal.die();
                    break;
                }
            }
        }
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

