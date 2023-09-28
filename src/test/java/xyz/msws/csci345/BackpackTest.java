package xyz.msws.csci345;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import xyz.msws.csci345.assignments.one.Backpack;

public class BackpackTest {

    private final Backpack backpack = new Backpack();

    @Test
    public void insertItemsInMainPocket() {
        backpack.insertItemsInMainPocket(5.0);
        Assertions.assertEquals(5.0, backpack.getWeight(Backpack.Pocket.MAIN));
    }

    @Test
    public void insertItemsInRightPocket() {
        backpack.insertItemsInRightPocket(5.0);
        Assertions.assertEquals(5.0, backpack.getWeight(Backpack.Pocket.RIGHT));
    }

    @Test
    public void insertItemsInLeftPocket() {
        backpack.insertItemsInLeftPocket(5.0);
        Assertions.assertEquals(5.0, backpack.getWeight(Backpack.Pocket.LEFT));
    }

    @Test
    public void removeItemsInMainPocket() {
        backpack.insertItemsInMainPocket(5.0);
        backpack.removeItemsInMainPocket(3.0);
        Assertions.assertEquals(2.0, backpack.getWeight(Backpack.Pocket.MAIN));
    }

    @Test
    public void removeItemsInRightPocket() {
        backpack.insertItemsInRightPocket(5.0);
        backpack.removeItemsInRightPocket(3.0);
        Assertions.assertEquals(2.0, backpack.getWeight(Backpack.Pocket.RIGHT));
    }

    @Test
    public void removeItemsInLeftPocket() {
        backpack.insertItemsInLeftPocket(5.0);
        backpack.removeItemsInLeftPocket(3.0);
        Assertions.assertEquals(2.0, backpack.getWeight(Backpack.Pocket.LEFT));
    }

    @Test
    public void insertItemsInPocket() {
        backpack.insertItemsInPocket(Backpack.Pocket.MAIN, 5.0);
        Assertions.assertEquals(5.0, backpack.getWeight(Backpack.Pocket.MAIN));
    }

    @Test
    public void getWeight() {
        backpack.insertItemsInPocket(Backpack.Pocket.MAIN, 5.0);
        backpack.insertItemsInLeftPocket(5.0);
        backpack.insertItemsInRightPocket(5.0);
        Assertions.assertEquals(5.0, backpack.getWeight(Backpack.Pocket.MAIN));
    }

    @Test
    public void getTotalWeight() {
        backpack.insertItemsInPocket(Backpack.Pocket.MAIN, 5.0);
        backpack.insertItemsInLeftPocket(5.0);
        backpack.insertItemsInRightPocket(5.0);
        Assertions.assertEquals(15.0, backpack.getTotalWeight());
    }

    @Test
    public void verifyOverflowCheck() {
        Assertions.assertFalse(backpack.insertItemsInLeftPocket(100));
    }
}