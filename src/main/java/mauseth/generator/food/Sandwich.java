package mauseth.generator.food;

import java.util.ArrayList;
import java.util.List;

public class Sandwich extends Meal {
    private final String BREAD = "Bread";
    private final String MAIN_INGREDIENT = "Main";
    private final String CHEESE = "Cheese";
    private final String ROUGHAGE = "Roughage";
    private final String SAUCE = "Sauce";
    private final String WILD_MAGIC = "Wild Magic";
    private final String ROLL_TWICE = "Roll Twice";
    private List<String> breadOptions = new ArrayList<>();
    private List<String> mainOptions = new ArrayList<>();
    private List<String> cheeseOptions = new ArrayList<>();
    private List<String> roughageOptions = new ArrayList<>();
    private List<String> sauceOptions = new ArrayList<>();
    private List<String> wildMagicOptions = new ArrayList<>();

    @Override
    public boolean hasCondition(String searchTerm) {
        return searchTerm.equalsIgnoreCase(ROLL_TWICE);
    }

    public void makeRecipe() {
        rollForIngredients(breadOptions, false);
        rollForIngredients(mainOptions, false);
        rollForIngredients(cheeseOptions, false);
        rollForIngredients(roughageOptions, true);
        rollForIngredients(sauceOptions, false);
        rollForIngredients(wildMagicOptions,false);
    }

    public void rollForIngredients (List<String> possibleOptions, boolean rollsTwiceByDefault) {
        boolean hasRolledAllIngredients = false;
        String firstItemToAdd = "";
        String secondItemToAdd = "";
        while (!hasRolledAllIngredients) {
            if (!possibleOptions.isEmpty()) {
                firstItemToAdd = getRandomItem(possibleOptions);
                secondItemToAdd = getRandomItem(possibleOptions);
                if (!firstItemToAdd.equalsIgnoreCase(ROLL_TWICE)) {
                    addToRecipe(firstItemToAdd);
                    System.out.println("Added: " + firstItemToAdd);
                    if (!rollsTwiceByDefault) {
                        break;
                    }
                } else System.out.println("First roll resulted in an additional roll: " + firstItemToAdd);
                if (rollsTwiceByDefault) {
                    if (!secondItemToAdd.equalsIgnoreCase(ROLL_TWICE)) {
                        addToRecipe(secondItemToAdd);
                        System.out.println("Added: " + firstItemToAdd);
                        hasRolledAllIngredients = true;
                    } else System.out.println("Second roll resulted in an additional: " + secondItemToAdd);
                }
            }
        }
    }

    public Sandwich(String mealType) {
        super(mealType);
    }

    public boolean isBread(String searchTerm) {
        return searchTerm.equalsIgnoreCase(BREAD);
    }

    public boolean isMainIngredient(String searchTerm) {
        return searchTerm.equalsIgnoreCase(MAIN_INGREDIENT);
    }

    public boolean isCheese(String searchTerm) {
        return searchTerm.equalsIgnoreCase(CHEESE);
    }

    public boolean isRoughage(String searchTerm) {
        return searchTerm.equalsIgnoreCase(ROUGHAGE);
    }

    public boolean isSauce(String searchTerm) {
        return searchTerm.equalsIgnoreCase(SAUCE);
    }

    public boolean isWildMagic(String searchTerm) {
        return searchTerm.equalsIgnoreCase(WILD_MAGIC);
    }

    public List<String> getBreadOptions() {
        return breadOptions;
    }

    public void addToBreadOptions(String breadOptions) {
        this.breadOptions.add(breadOptions);
    }

    public List<String> getMainOptions() {
        return mainOptions;
    }

    public void addToMainOptions(String mainOptions) {
        this.mainOptions.add(mainOptions);
    }

    public List<String> getCheeseOptions() {
        return cheeseOptions;
    }

    public void addToCheeseOptions(String cheeseOptions) {
        this.cheeseOptions.add(cheeseOptions);
    }

    public List<String> getRoughageOptions() {
        return roughageOptions;
    }

    public void addToRoughageOptions(String roughageOptions) {
        this.roughageOptions.add(roughageOptions);
    }

    public List<String> getSauceOptions() {
        return sauceOptions;
    }

    public void addToSauceOptions(String sauceOptions) {
        this.sauceOptions.add(sauceOptions);
    }

    public List<String> getWildMagicOptions() {
        return wildMagicOptions;
    }

    public void addToWildMagicOptions(String wildMagicOptions) {
        this.wildMagicOptions.add(wildMagicOptions);
    }

}
