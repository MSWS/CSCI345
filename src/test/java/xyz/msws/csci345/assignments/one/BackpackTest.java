package xyz.msws.csci345.assignments.one;

import org.junit.jupiter.api.Test;
import xyz.msws.csci345.assignments.one.Backpack;

import static org.junit.jupiter.api.Assertions.*;

public class BackpackTest {

    private final Backpack backpack = new Backpack();

    @Test
    public void insertItemsInMainPocket() {
        assertTrue(backpack.insertItemsInMainPocket(5.0));
        assertEquals(5.0, backpack.getWeight(Backpack.Pocket.MAIN));
    }

    @Test
    public void insertItemsInRightPocket() {
        assertTrue(backpack.insertItemsInRightPocket(4.0));
        assertEquals(4.0, backpack.getWeight(Backpack.Pocket.RIGHT));
    }

    @Test
    public void insertItemsInLeftPocket() {
        assertTrue(backpack.insertItemsInLeftPocket(3.0));
        assertEquals(3.0, backpack.getWeight(Backpack.Pocket.LEFT));
    }

    @Test
    public void removeItemsInMainPocket() {
        assertTrue(backpack.insertItemsInMainPocket(5.0));
        assertTrue(backpack.removeItemsInMainPocket(3.0));
        assertEquals(2.0, backpack.getWeight(Backpack.Pocket.MAIN));
    }

    @Test
    public void removeItemsInRightPocket() {
        assertTrue(backpack.insertItemsInRightPocket(5.0));
        assertTrue(backpack.removeItemsInRightPocket(3.0));
        assertEquals(2.0, backpack.getWeight(Backpack.Pocket.RIGHT));
    }

    @Test
    public void removeItemsInLeftPocket() {
        assertTrue(backpack.insertItemsInLeftPocket(5.0));
        assertTrue(backpack.removeItemsInLeftPocket(3.0));
        assertEquals(2.0, backpack.getWeight(Backpack.Pocket.LEFT));
    }

    @Test
    public void insertItemsInPocket() {
        assertTrue(backpack.insertItemsInPocket(Backpack.Pocket.MAIN, 5.0));
        assertEquals(5.0, backpack.getWeight(Backpack.Pocket.MAIN));
    }

    @Test
    public void getWeight() {
        assertTrue(backpack.insertItemsInPocket(Backpack.Pocket.MAIN, 5.0));
        assertTrue(backpack.insertItemsInLeftPocket(5.0));
        assertTrue(backpack.insertItemsInRightPocket(5.0));
        assertEquals(5.0, backpack.getWeight(Backpack.Pocket.MAIN));
    }

    @Test
    public void getTotalWeight() {
        assertTrue(backpack.insertItemsInPocket(Backpack.Pocket.MAIN, 5.0));
        assertTrue(backpack.insertItemsInLeftPocket(5.0));
        assertTrue(backpack.insertItemsInRightPocket(5.0));
        assertEquals(15.0, backpack.getTotalWeight());
    }

    @Test
    public void verifyOverflowCheck() {
        assertFalse(backpack.insertItemsInLeftPocket(100));
    }

    @Test
    public void verifyOverflowCheck2() {
        assertFalse(backpack.insertItemsInRightPocket(100));
    }

    @Test
    public void verifyOverflowCheck3() {
        assertFalse(backpack.insertItemsInMainPocket(100));
    }

    @Test
    public void verifyUnderflowCheck() {
        assertTrue(backpack.insertItemsInMainPocket(7.0));
        assertFalse(backpack.removeItemsInLeftPocket(8));
    }
}