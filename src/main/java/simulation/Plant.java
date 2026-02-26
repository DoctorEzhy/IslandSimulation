package simulation;

public class Plant {

    private double foodAmount = 10; // пример
    private double growthRate = 2;

    public void grow() {
        foodAmount += growthRate;
    }

    public double consume(double amount) {
        double eaten = Math.min(amount, foodAmount);
        foodAmount -= eaten;
        return eaten;
    }

    public void setFoodAmount(double amount) {
        this.foodAmount = amount;
    }

    public double getFoodAmount() {
        return foodAmount;
    }
}

