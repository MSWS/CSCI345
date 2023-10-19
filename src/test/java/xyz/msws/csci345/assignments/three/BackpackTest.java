package xyz.msws.csci345.assignments.three;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BackpackTest {

    private final Backpack backpack = new Backpack();

    @Test
    public void testBackpack() {
        assertNotNull(backpack, "Backpack is null");
        backpack.insertItemInLeftPocket("Left", 1);
        backpack.insertItemInMainPocket("Main", 2);
        backpack.insertItemInRightPocket("Right", 4);
        assertEquals(7, backpack.getTotalWeight(), "Total weight is not 7");
    }

    @Test
    public void testPocketWeight() {
        assertTrue(backpack.insertItemInLeftPocket("First Half-Weight", 2.5));
        assertTrue(backpack.insertItemInLeftPocket("Second Half-Weight", 2.5));
        assertFalse(backpack.insertItemInLeftPocket("Overweight", 2.5), "Overweight item was inserted into left pocket");
        assertEquals(5.0, backpack.getLeftPocketTotalWeight(), "Left pocket weight is not 5.0");

        assertTrue(backpack.insertItemInRightPocket("First Half-Weight", 2.5));
        assertTrue(backpack.insertItemInRightPocket("Second Half-Weight", 2.5));
        assertFalse(backpack.insertItemInRightPocket("Overweight", 2.5), "Overweight item was inserted into right pocket");
        assertEquals(5.0, backpack.getRightPocketTotalWeight(), "Right pocket weight is not 5.0");

        assertTrue(backpack.insertItemInMainPocket("First Half-Weight", 5.0));
        assertTrue(backpack.insertItemInMainPocket("Second Half-Weight", 5.0));
        assertFalse(backpack.insertItemInMainPocket("Overweight", 5.0), "Overweight item was inserted into main pocket");
        assertEquals(10.0, backpack.getMainPocketTotalWeight(), "Main pocket weight is not 10.0");
    }

    @Test
    public void testPocketNaming() {
        assertTrue(backpack.insertItemInLeftPocket("Left-Foo", 1));
        assertTrue(backpack.insertItemInMainPocket("Main-Foo", 1));
        assertTrue(backpack.insertItemInRightPocket("Right-Foo", 1));
        assertFalse(backpack.removeItemFromLeftPocket("Non-Existing"), "Non-Existing item was removed from left pocket");
        assertFalse(backpack.removeItemFromMainPocket("Non-Existing"), "Non-Existing item was removed from main pocket");
        assertFalse(backpack.removeItemFromRightPocket("Non-Existing"), "Non-Existing item was removed from right pocket");
        assertTrue(backpack.removeItemFromLeftPocket("Left-Foo"), "Left-Foo was not removed from left pocket");
        assertTrue(backpack.removeItemFromMainPocket("Main-Foo"), "Main-Foo was not removed from main pocket");
        assertTrue(backpack.removeItemFromRightPocket("Right-Foo"), "Right-Foo was not removed from right pocket");
    }

    @Test
    public void testPocketSeparation() {
        assertTrue(backpack.insertItemInLeftPocket("Left-Foo", 1));
        assertFalse(backpack.removeItemFromMainPocket("Left-Foo"), "Left-Foo was removed from main pocket");
        assertFalse(backpack.removeItemFromRightPocket("Left-Foo"), "Left-Foo was removed from right pocket");

        assertTrue(backpack.insertItemInMainPocket("Main-Foo", 2));
        assertFalse(backpack.removeItemFromLeftPocket("Main-Foo"), "Main-Foo was removed from left pocket");
        assertFalse(backpack.removeItemFromRightPocket("Main-Foo"), "Main-Foo was removed from right pocket");

        assertTrue(backpack.insertItemInRightPocket("Right-Foo", 4));
        assertFalse(backpack.removeItemFromLeftPocket("Right-Foo"), "Right-Foo was removed from left pocket");
        assertFalse(backpack.removeItemFromMainPocket("Right-Foo"), "Right-Foo was removed from main pocket");

        assertEquals(1, backpack.getLeftPocketTotalWeight());
        assertEquals(2, backpack.getMainPocketTotalWeight());
        assertEquals(4, backpack.getRightPocketTotalWeight());

        assertTrue(backpack.removeItemFromLeftPocket("Left-Foo"), "Left-Foo was not removed from left pocket");
        assertTrue(backpack.removeItemFromMainPocket("Main-Foo"), "Main-Foo was not removed from main pocket");
        assertTrue(backpack.removeItemFromRightPocket("Right-Foo"), "Right-Foo was not removed from right pocket");
    }
}