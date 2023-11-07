package xyz.msws.csci345.assignments.five;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BackpackTest {

    private final Backpack backpack = new Backpack();

    @Test
    public void testBackpack() throws ItemOverweightException, ItemWeightInvalidException {
        assertNotNull(backpack, "Backpack is null");
        backpack.insertItemInLeftPocket("Left", 1);
        backpack.insertItemInMainPocket("Main", 2);
        backpack.insertItemInRightPocket("Right", 4);
        assertEquals(7, backpack.getTotalWeight(), "Total weight is not 7");
    }

    @Test
    public void testPocketWeight() throws ItemOverweightException, ItemWeightInvalidException {
        backpack.insertItemInLeftPocket("First Half-Weight", 2.5);
        backpack.insertItemInLeftPocket("Second Half-Weight", 2.5);

        assertThrows(ItemOverweightException.class, () -> backpack.insertItemInLeftPocket("Overweight", 2.5), "Overweight item was inserted into left pocket");
        assertEquals(5.0, backpack.getLeftPocketTotalWeight(), "Left pocket weight is not 5.0");

        backpack.insertItemInRightPocket("First Half-Weight", 2.5);
        backpack.insertItemInRightPocket("Second Half-Weight", 2.5);
        assertThrows(ItemOverweightException.class, () -> backpack.insertItemInRightPocket("Overweight", 2.5), "Overweight item was inserted into right pocket");
        assertEquals(5.0, backpack.getRightPocketTotalWeight(), "Right pocket weight is not 5.0");

        backpack.insertItemInMainPocket("First Half-Weight", 5.0);
        backpack.insertItemInMainPocket("Second Half-Weight", 5.0);
        assertThrows(ItemOverweightException.class, () -> backpack.insertItemInMainPocket("Overweight", 5.0), "Overweight item was inserted into main pocket");
        assertEquals(10.0, backpack.getMainPocketTotalWeight(), "Main pocket weight is not 10.0");
    }

    @Test
    public void testPocketNaming() throws ItemOverweightException, ItemWeightInvalidException, ItemNotFoundException {
        backpack.insertItemInLeftPocket("Left-Foo", 1);
        backpack.insertItemInMainPocket("Main-Foo", 1);
        backpack.insertItemInRightPocket("Right-Foo", 1);

        assertThrows(ItemNotFoundException.class, () -> backpack.removeItemFromLeftPocket("Non-Existing"), "Non-Existing item was removed from left pocket");
        assertThrows(ItemNotFoundException.class, () -> backpack.removeItemFromMainPocket("Non-Existing"), "Non-Existing item was removed from main pocket");
        assertThrows(ItemNotFoundException.class, () -> backpack.removeItemFromRightPocket("Non-Existing"), "Non-Existing item was removed from right pocket");

        backpack.removeItemFromLeftPocket("Left-Foo");
        backpack.removeItemFromMainPocket("Main-Foo");
        backpack.removeItemFromRightPocket("Right-Foo");
    }

    @Test
    public void testPocketSeparation() throws ItemOverweightException, ItemWeightInvalidException, ItemNotFoundException {
        backpack.insertItemInLeftPocket("Left-Foo", 1);

        assertThrows(ItemNotFoundException.class, () -> backpack.removeItemFromMainPocket("Left-Foo"), "Left-Foo was removed from main pocket");
        assertThrows(ItemNotFoundException.class, () -> backpack.removeItemFromRightPocket("Left-Foo"), "Left-Foo was removed from right pocket");

        backpack.insertItemInMainPocket("Main-Foo", 2);

        assertThrows(ItemNotFoundException.class, () -> backpack.removeItemFromLeftPocket("Main-Foo"), "Main-Foo was removed from left pocket");
        assertThrows(ItemNotFoundException.class, () -> backpack.removeItemFromRightPocket("Main-Foo"), "Main-Foo was removed from right pocket");

        backpack.insertItemInRightPocket("Right-Foo", 4);

        assertThrows(ItemNotFoundException.class, () -> backpack.removeItemFromLeftPocket("Right-Foo"), "Right-Foo was removed from left pocket");
        assertThrows(ItemNotFoundException.class, () -> backpack.removeItemFromMainPocket("Right-Foo"), "Right-Foo was removed from main pocket");

        assertEquals(1, backpack.getLeftPocketTotalWeight());
        assertEquals(2, backpack.getMainPocketTotalWeight());
        assertEquals(4, backpack.getRightPocketTotalWeight());

        backpack.removeItemFromLeftPocket("Left-Foo");
        backpack.removeItemFromMainPocket("Main-Foo");
        backpack.removeItemFromRightPocket("Right-Foo");
    }

    @Test
    public void testBackpackItemEquality() {
        BackpackItem foo = new BackpackItem("Foo", 1);
        BackpackItem bar = new BackpackItem("Bar", 1);
        assertNotEquals(foo, bar, "Foo is equal to bar");

        foo = new BackpackItem("Foo", 2);
        bar = new BackpackItem("Foo", 1);
        assertNotEquals(foo, bar, "Foo is equal to bar");

        foo = new BackpackItem("Foo", 1);
        bar = new BackpackItem("Foo", 1);
        assertEquals(foo, bar, "Foo is not equal to bar");
    }

    @Test
    public void testPocketEquality() throws CloneNotSupportedException, ItemOverweightException, ItemWeightInvalidException {
        Pocket foo = new Pocket("Foo", 10);
        Pocket bar = new Pocket("Bar", 10);
        assertNotEquals(foo, bar, "Foo is equal to bar");

        foo = new Pocket("Foo", 10);
        bar = new Pocket("Foo", 5);
        assertNotEquals(foo, bar, "Foo is equal to bar");

        foo = new Pocket("Foo", 10);
        bar = new Pocket("Foo", 10);
        assertEquals(foo, bar, "Foo is not equal to bar");

        foo = new Pocket("Foo", 10);
        bar = new Pocket(foo);
        assertNotSame(foo, bar, "Foo is same instance as bar");
        assertEquals(foo, bar, "Foo is not equal to bar");

        foo = new Pocket("Foo", 10);
        bar = (Pocket) foo.clone();
        assertNotSame(foo, bar, "Foo is same instance as bar");
        assertEquals(foo, bar, "Foo is not equal to bar");

        foo = new Pocket("Foo", 10);
        bar = new Pocket("Foo", 10);
        foo.insertItemInPocket("Foo", 1);
        assertNotEquals(foo, bar, "Foo is equal to bar");
    }

    @Test
    public void testPocketCardinality() throws ItemOverweightException, ItemWeightInvalidException {
        Pocket foo = new Pocket("Foo", 10);
        Pocket bar = new Pocket("Foo", 10);

        foo.insertItemInPocket("Foo", 1);
        foo.insertItemInPocket("Foo", 1);
        foo.insertItemInPocket("Bar", 1);

        bar.insertItemInPocket("Foo", 1);
        bar.insertItemInPocket("Bar", 1);
        bar.insertItemInPocket("Bar", 1);

        assertNotEquals(foo, bar, "Foo is equal to bar");

        foo = new Pocket("Foo", 10);
        bar = new Pocket("Foo", 10);

        foo.insertItemInPocket("Foo", 1);
        foo.insertItemInPocket("Foo", 1);
        foo.insertItemInPocket("Bar", 1);

        bar.insertItemInPocket("Foo", 1);
        bar.insertItemInPocket("Bar", 1);
        bar.insertItemInPocket("Foo", 1);

        assertEquals(foo, bar, "Foo is not equal to bar");
    }
}