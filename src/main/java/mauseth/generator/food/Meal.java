package mauseth.generator.food;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ThreadLocalRandom;

public class Meal implements RandomMealGeneration {
    private final String mealType;
    private final LocalDate dateCreated;
    private Queue<String> recipe = new LinkedList<>();

    public Meal(String mealType, Queue<String> recipe) {
        this.mealType = mealType;
        this.recipe = recipe;
        dateCreated = LocalDate.now();
    }

    public Meal(String mealType) {
        this.mealType = mealType;
        dateCreated = LocalDate.now();
    }

    @Override
    public String toString() {
        return mealType
                + " created on "
                + dateCreated.getMonthValue() + "/"
                + dateCreated.getDayOfMonth() + "/"
                + dateCreated.getYear();
    }

    @Override
    public void addToRecipe(String ingredient) {
        recipe.offer(ingredient);
    }

    @Override
    public String printRecipe() {
        boolean isFirstItem = true;
        String ingredients = "";
        for (String ingredient : recipe) {
            if (isFirstItem) {
                isFirstItem = false;
                ingredients += System.lineSeparator();
            }
            ingredients += "  - " + ingredient + System.lineSeparator();
        }
        return ingredients;
    }

    public String getRandomItem(List<String> options) {
        int index = ThreadLocalRandom.current().nextInt(0, options.size());
        return options.get(index);
    }

    @Override
    public boolean hasCondition(String searchTerm) {
        return false;
    }

    public Queue<String> getRecipe() {
        return recipe;
    }

    public String getMealType() {
        return mealType;
    }
}
