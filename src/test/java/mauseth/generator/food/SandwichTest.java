package mauseth.generator.food;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class SandwichTest {

    Sandwich sandwich = new Sandwich("Sandwich");

    @Test
    public void hasCondition_returnsTrueWhenRollTwiceIsPassed() {
        Assert.assertTrue(sandwich.hasCondition("Roll Twice"));
    }
    @Test
    public void hasCondition_returnsFalseFor_Roll_Twic() {
        Assert.assertFalse(sandwich.hasCondition("Roll Twic"));
    }

    @Test
    public void hasCondition_returnsFalseFor_RollTwice() {
        Assert.assertFalse(sandwich.hasCondition("RollTwice"));
    }

    @Test
    public void hasCondition_returnsFalseFor_Twice() {
        Assert.assertFalse(sandwich.hasCondition("Twice"));
    }

    @Test
    public void hasCondition_returnsFalseFor_Roll() {
        Assert.assertFalse(sandwich.hasCondition("Roll"));
    }

    @Test
    public void isBread_ReturnsTrueFor_Bread() {
        Assert.assertTrue(sandwich.isBread("Bread"));
    }

    @Test
    public void isBread_ReturnsFalseFor_Bred() {
        Assert.assertFalse(sandwich.isBread("Bred"));
    }

    @Test
    public void isBread_ReturnsFalseFor_Brad() {
        Assert.assertFalse(sandwich.isBread("Brad"));
    }

    @Test
    public void isBread_ReturnsFalseFor_Breed() {
        Assert.assertFalse(sandwich.isBread("Breed"));
    }

    @Test
    public void isBread_ReturnsFalseFor_read() {
        Assert.assertFalse(sandwich.isBread("read"));
    }

    @Test
    public void isMainIngredient_ReturnsTrueFor_Main() {
        Assert.assertTrue(sandwich.isMainIngredient("Main"));
    }

    @Test
    public void isMainIngredient_ReturnsFalseFor_ain() {
        Assert.assertFalse(sandwich.isMainIngredient("ain"));
    }

    @Test
    public void isCheese_ReturnsTrueFor_Cheese() {
        Assert.assertTrue(sandwich.isCheese("Cheese"));
    }

    @Test
    public void isCheese_ReturnsFalseFor_CheeseWithDelimiter() {
        Assert.assertFalse(sandwich.isCheese("Cheese\\|"));
    }

    @Test
    public void isRoughage_ReturnsTrueFor_Roughage() {
        Assert.assertTrue(sandwich.isRoughage("Roughage"));
    }

    @Test
    public void isRoughage_ReturnsFalseFor_Roughag() {
        Assert.assertFalse(sandwich.isRoughage("Roughag"));
    }


    @Test
    public void isSauce_ReturnsTrueFor_Sauce() {
        Assert.assertTrue(sandwich.isSauce("Sauce"));
    }

    @Test
    public void isSauce_ReturnsFalseFor_auce() {
        Assert.assertFalse(sandwich.isSauce("auce"));
    }


    @Test
    public void isWildMagic_ReturnsTrueFor_Wild_Magic() {
        Assert.assertTrue(sandwich.isWildMagic("Wild Magic"));
    }

    @Test
    public void isWildMagic_ReturnsFalseFor_Wild() {
        Assert.assertFalse(sandwich.isWildMagic("Wild"));
    }

    @Test
    public void isWildMagic_ReturnsFalseFor_Magic() {
        Assert.assertFalse(sandwich.isWildMagic("Magic"));
    }
}