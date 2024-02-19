package mauseth.generator.food;

import java.util.List;

public interface RandomMealGeneration {
    boolean hasCondition(String searchTerm);

    void addToRecipe(String ingredient);

    String getRandomItem(List<String> options);

    String printRecipe();

}
