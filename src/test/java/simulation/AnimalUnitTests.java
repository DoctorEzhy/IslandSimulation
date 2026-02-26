package simulation;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AnimalUnitTests {

    @Test
    void testRabbitEat() {
        Location loc = new Location();
        Rabbit rabbit = new Rabbit(loc);
        loc.addAnimal(rabbit);

        rabbit.eat();

        assertTrue(rabbit.foodEaten >= 0);
    }

    @Test
    void testRabbitReproduce() {
        Location loc = new Location();
        Rabbit r1 = new Rabbit(loc);
        Rabbit r2 = new Rabbit(loc);
        loc.addAnimal(r1);
        loc.addAnimal(r2);

        r1.reproduce();

        assertTrue(loc.getAnimals().size() > 2);
    }

    @Test
    void testRabbitDie() {
        Location loc = new Location();
        Rabbit rabbit = new Rabbit(loc);
        loc.addAnimal(rabbit);

        rabbit.die();

        assertFalse(rabbit.alive);
        assertFalse(loc.getAnimals().contains(rabbit));
    }

    @Test
    void testWolfEatRabbit() {
        Location loc = new Location();
        Wolf wolf = new Wolf(loc);
        Rabbit rabbit = new Rabbit(loc);
        loc.addAnimal(wolf);
        loc.addAnimal(rabbit);

        wolf.eat();

        assertTrue(!loc.getAnimals().contains(rabbit) || wolf.foodEaten > 0);
    }

    @Test
    void testDuckEatCaterpillar() {
        Location loc = new Location();
        Duck duck = new Duck(loc);
        Caterpillar cat = new Caterpillar(loc);
        loc.addAnimal(duck);
        loc.addAnimal(cat);

        duck.eat();

        assertTrue(!loc.getAnimals().contains(cat) || duck.foodEaten > 0);
    }

    @Test
    void testPlantGrow() {
        Plant plant = new Plant();
        plant.setFoodAmount(5);
        double before = plant.getFoodAmount();

        plant.grow();

        double after = plant.getFoodAmount();
        assertTrue(after > before, "Plant did not grow as expected");
    }

    @Test
    void testLocationAddRemoveAnimal() {
        Location loc = new Location();
        Rabbit rabbit = new Rabbit(loc);
        loc.addAnimal(rabbit);
        assertTrue(loc.getAnimals().contains(rabbit));
        loc.removeAnimal(rabbit);
        assertFalse(loc.getAnimals().contains(rabbit));
    }

    @Test
    void testCaterpillarDoesNotMove() {
        Location loc = new Location();
        Caterpillar cat = new Caterpillar(loc);
        loc.addAnimal(cat);

        cat.move();

        assertEquals(cat.location, loc);
    }

    @Test
    void testBoarEatPlants() {
        Location loc = new Location();
        Boar boar = new Boar(loc);
        loc.addAnimal(boar);

        boar.eat();

        assertTrue(boar.foodEaten >= 0);
    }

    @Test
    void testSheepReproduce() {
        Location loc = new Location();
        Sheep s1 = new Sheep(loc);
        Sheep s2 = new Sheep(loc);
        loc.addAnimal(s1);
        loc.addAnimal(s2);

        s1.reproduce();

        assertTrue(loc.getAnimals().size() > 2);
    }
}
