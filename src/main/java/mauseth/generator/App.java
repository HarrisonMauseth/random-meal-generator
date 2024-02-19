package mauseth.generator;


import mauseth.generator.food.Meal;
import mauseth.generator.food.Sandwich;
import mauseth.generator.util.FileHandling;
import mauseth.generator.util.exception.FileHandlingException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class App {
    private static final String FIELD_DELIMITER = "\\|";
    private static final String FILE_BASE_PATH = "src/main/resources/";
    private static final String SANDWICH_FILE = "sandwich.txt";
    private static final String SANDWICH = "Sandwich";
    private static final int CATEGORY_FIELD = 0;
    private Queue<Sandwich> sandwichesToMake = new LinkedList<>();
    private Map<String, List<Meal>> mealsMade = new HashMap<>();

    public static void main(String[] args) throws FileHandlingException {
        App app = new App();
        app.initialize();
        app.run();
    }

    // Import the data and create a sandwich
    private void initialize() throws FileHandlingException {
        List<String> sandwichItems = new ArrayList<>(FileHandling.readContentsOfFile(FILE_BASE_PATH + SANDWICH_FILE));

        Sandwich sandwich = new Sandwich(SANDWICH);

        for (String item : sandwichItems) {
            String[] ingredients = item.split(FIELD_DELIMITER);
            String category = ingredients[CATEGORY_FIELD];
            boolean isCategoryField = true;
            for (String ingredient : ingredients) {
                if (isCategoryField) {
                    isCategoryField = false;
                    continue;
                }
                if (sandwich.isBread(category)) {
                    sandwich.addToBreadOptions(ingredient);
                } else if (sandwich.isMainIngredient(category)) {
                    sandwich.addToMainOptions(ingredient);
                } else if (sandwich.isCheese(category)) {
                    sandwich.addToCheeseOptions(ingredient);
                } else if (sandwich.isRoughage(category)) {
                    sandwich.addToRoughageOptions(ingredient);
                } else if (sandwich.isSauce(category)) {
                    sandwich.addToSauceOptions(ingredient);
                } else if (sandwich.isWildMagic(category)) {
                    sandwich.addToWildMagicOptions(ingredient);
                }
            }
        }
        sandwichesToMake.offer(sandwich);
        System.out.println(sandwich.printRecipe());
    }

    // TODO: Make the sandwich
    public void makeSandwich(Sandwich sandwich) {
        sandwich.makeRecipe();
        System.out.println(sandwich.toString());
        System.out.println(sandwich.printRecipe());
    }

    public void run() {
        // TODO: Create the UI for console program
        while (!sandwichesToMake.isEmpty()) {
            Sandwich sandwich = sandwichesToMake.poll();
            makeSandwich(sandwich);
        }
    }

    // TODO: Create a method that generates a fresh sandwich file

    // TODO: Create a method that modifies an existing sandwich template

    // TODO: Generate Multiple Methods


}