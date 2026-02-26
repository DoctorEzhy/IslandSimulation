package simulation;

import java.util.HashMap;
import java.util.Map;

public abstract class Predator extends Animal {

    protected Map<Class<? extends Animal>, Integer> foodChance = new HashMap<>();

    public Predator(Location location) {
        super(location);
    }

    @Override
    public void eat() {
        for (Animal animal : location.getAnimals()) {
            if (animal != this && foodChance.containsKey(animal.getClass())) {
                if (chance(foodChance.get(animal.getClass()))) {
                    foodEaten += animal.weight;
                    animal.die();
                    break;
                }
            }
        }
    }
}