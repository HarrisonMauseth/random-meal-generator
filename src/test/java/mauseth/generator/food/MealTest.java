package mauseth.generator.food;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class MealTest {

    private Meal meal = new Meal("Meal 1");
    private List<String> randomOptions = new ArrayList<>();

    @Test
    public void addToRecipe_hasSizeOfThreeWhenThreeItemsAreAdded() {
        int initialRecipeSize = meal.getRecipe().size();

        meal.addToRecipe("Sourdough");
        meal.addToRecipe("Chicken");
        meal.addToRecipe("Soup");

        int finishedRecipeSize = meal.getRecipe().size();

        Assert.assertTrue(initialRecipeSize == 0 && finishedRecipeSize == 3);
    }

    @Test
    public void addToRecipe_hasSizeOfZeroWhenNothingIsAdded() {
        int initialRecipeSize = meal.getRecipe().size();
        Assert.assertTrue(initialRecipeSize == 0);
    }

    @Test
    public void addToRecipe_hasSizeOfFourWhenSameFourIngredientsAreAdded() {
        int initialRecipeSize = meal.getRecipe().size();

        meal.addToRecipe("Soup");
        meal.addToRecipe("Soup");
        meal.addToRecipe("Soup");
        meal.addToRecipe("Soup");

        int finishedRecipeSize = meal.getRecipe().size();

        Assert.assertTrue(initialRecipeSize == 0 && finishedRecipeSize == 4);
    }

    @Test
    public void printRecipe_shouldNotChangeRecipeSizeWhenPrintingRecipeString() {
        meal.addToRecipe("Soup");
        meal.addToRecipe("Soup");
        meal.addToRecipe("Soup");
        meal.addToRecipe("Soup");

        int sizeBeforePrinting = meal.getRecipe().size();

        String testForDequeue = meal.printRecipe();

        int sizeAfterPrinting = meal.getRecipe().size();

        Assert.assertEquals(sizeBeforePrinting, sizeAfterPrinting);
    }

    @Test
    public void printRecipe_shouldBeAbleToBeCalledMultipleTimesWithoutRemovingItems() {
        meal.addToRecipe("Sourdough");
        meal.addToRecipe("Chicken");
        meal.addToRecipe("Soup");

        int sizeBeforePrinting = meal.getRecipe().size();

        String firstTestForDequeue = meal.printRecipe();
        String secondTestForDequeue = meal.printRecipe();
        String thirdTestForDequeue = meal.printRecipe();

        int sizeAfterPrinting = meal.getRecipe().size();

        Assert.assertEquals(sizeBeforePrinting, sizeAfterPrinting);
        Assert.assertFalse(meal.getRecipe().isEmpty());
    }

    @Test
    public void printRecipe_shouldBeAbleToBeCalledMultipleTimesWithAndReturnTheSameString() {
        meal.addToRecipe("Sourdough");
        meal.addToRecipe("Chicken");
        meal.addToRecipe("Soup");

        int sizeBeforePrinting = meal.getRecipe().size();

        String firstTestForDequeue = meal.printRecipe();
        String secondTestForDequeue = meal.printRecipe();

        int sizeAfterPrinting = meal.getRecipe().size();

        Assert.assertEquals(firstTestForDequeue, secondTestForDequeue);
    }


    public void printRecipe_shouldReturnEmptyStringWhenRecipeIsEmpty() {
        Assert.assertEquals("", meal.printRecipe());
    }

    public void printRecipe_shouldNotReturnEmptyStringWhenRecipeIsNotEmpty() {
        meal.addToRecipe("Sourdough");
        meal.addToRecipe("Chicken");
        meal.addToRecipe("Soup");
        Assert.assertNotEquals("", meal.printRecipe());
    }

    public void printRecipe_ShouldNotReturnNullWhenCalledOnAnEmptyRecipe() {
        meal.addToRecipe("Sourdough");
        meal.addToRecipe("Chicken");
        meal.addToRecipe("Soup");
        Assert.assertNotNull(meal.printRecipe());
    }


    @Before
    public void fillRandomOptions() {
        randomOptions.add("Index One");
        randomOptions.add("Index Two");
        randomOptions.add("Index Three");
    }

    @Test
    public void getRandomItem_shouldReturnStringFromStringsArray() {
        Assert.assertTrue(randomOptions.contains(meal.getRandomItem(randomOptions)));
        Assert.assertTrue(randomOptions.contains(meal.getRandomItem(randomOptions)));
        Assert.assertTrue(randomOptions.contains(meal.getRandomItem(randomOptions)));
    }

    @Test
    public void getRandomItem_shouldReturnFalseWhenComparedToUnexpectedWord() {
        Assert.assertNotEquals("Nope", meal.getRandomItem(randomOptions));
        Assert.assertNotEquals("Index On", meal.getRandomItem(randomOptions));
        Assert.assertNotEquals("Two", meal.getRandomItem(randomOptions));
        Assert.assertNotEquals("Index", meal.getRandomItem(randomOptions));
    }

    @Test
    public void getRandomItem_shouldReturnDifferentStrings() {
        String index0 = randomOptions.get(0);
        String index1 = randomOptions.get(1);
        String index2 = randomOptions.get(2);

        int countOfIndex0 = 0;
        int countOfIndex1 = 0;
        int countOfIndex2 = 0;
        int unexpectedStringCount = 0;

        for (int i = 0; i < 20; i++) {
            String testString = meal.getRandomItem(randomOptions);
            if (testString.equals(index0)) {
                countOfIndex0++;
            } else if (testString.equals(index1)) {
                countOfIndex1++;
            } else if (testString.equals(index2)) {
                countOfIndex2++;
            } else unexpectedStringCount++;
        }

        Assert.assertTrue(countOfIndex0 > 0
                && countOfIndex1 > 0
                && countOfIndex2 > 0
                && unexpectedStringCount == 0
        );

    }






}