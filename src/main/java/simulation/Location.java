package simulation;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Location {

    private List<Animal> animals = new CopyOnWriteArrayList<>();
    private Plant plant = new Plant();

    public List<Animal> getAnimals() {
        return animals;
    }

    public Plant getPlant() {
        return plant;
    }

    public void addAnimal(Animal animal) {
        animals.add(animal);
    }

    public void removeAnimal(Animal animal) {
        animals.remove(animal);
    }

    public void randomMove(Animal animal, int speed) {
    }

    public void tryReproduce(Animal animal) {
        long count = animals.stream()
                .filter(a -> a.getClass() == animal.getClass())
                .count();

        if (count >= 2) {
            try {
                Animal baby = animal.getClass()
                        .getConstructor(Location.class)
                        .newInstance(this);
                animals.add(baby);
            } catch (Exception ignored) {}
        }
    }
}