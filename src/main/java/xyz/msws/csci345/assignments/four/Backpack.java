package xyz.msws.csci345.assignments.four;

import java.util.Iterator;

/**
 * Name: Isaac Boaz
 * Date: 10/31/23
 * Description: A class that represents a "physical" backpack that has three {{@link Pocket}s.
 * Current implementation of this backpack restricts it to three pockets. Note that an arbitrary
 * amount of pockets can be iterated over using the Backpack's {@link Backpack#iterator()} method
 * (or using an enhanced for-loop).
 */
public class Backpack implements Iterable<Pocket>, Iterator<Pocket> {

    // Constants
    /**
     * Note that these are actually DEFAULT weights,
     * and are not guaranteed to be the actual max weights of the backpack's pockets.
     */
    private final static int MAIN_POCKET_MAX_WEIGHT = 10;
    private final static int LEFT_POCKET_MAX_WEIGHT = 5;
    private final static int RIGHT_POCKET_MAX_WEIGHT = 5;

    /**
     * Used for checking if we're done iterating.
     */
    private final int POCKET_QUANTITY = 3;

    //Fields

    /**
     * Used for tracking which pocket we should return for iteration.
     * Internally, pockets go in the order of Left, Main, Right. ie
     * 0 - Left
     * 1 - Main
     * 2 - Right
     */
    private int currentIteratingPocket = 0;

    /**
     * The primary pocket, presumably has a higher max weight than the other pockets.
     */
    private final Pocket mainPocket;

    /**
     * The right pocket, which is not the left pocket.
     */
    private final Pocket rightPocket;

    /**
     * The left pocket, which is not the right pocket.
     */
    private final Pocket leftPocket;

    //Constructors

    /**
     * Default constructor for a Backpack, initializes with the static defaults for {@link Backpack}s.
     * <p>
     * Underyling implementation simply calls {@link Backpack(int, int, int)}
     */
    public Backpack() {
        this(MAIN_POCKET_MAX_WEIGHT, RIGHT_POCKET_MAX_WEIGHT, LEFT_POCKET_MAX_WEIGHT);
    }

    /**
     * Constructs a backpack with the given main, right, and left pocket weights.
     *
     * @param mainPocketMaxWeight  The max weight for the main pocket.
     * @param rightPocketMaxWeight The max weight for the right pocket.
     * @param leftPocketMaxWeight  The max weight for the left pocket.
     */
    public Backpack(int mainPocketMaxWeight, int rightPocketMaxWeight, int leftPocketMaxWeight) {
        mainPocket = new Pocket("Main", mainPocketMaxWeight);
        rightPocket = new Pocket("Right", rightPocketMaxWeight);
        leftPocket = new Pocket("Left", leftPocketMaxWeight);
    }

    //Methods

    /**
     * Attempts to insert the given item into the main pocket.
     * If the item's weight in combination with the existing weight of the
     * items in the pocket would exceed the max weight for the pocket,
     * or if the item's weight is invalid (ie negative), an exception
     * is thrown.
     *
     * @param itemName   The name of the item to insert
     * @param itemWeight The weight of the item to insert
     * @throws Exception If the weight is invalid
     */
    public void insertItemInMainPocket(String itemName, double itemWeight) throws Exception {
        mainPocket.insertItemInPocket(itemName, itemWeight);
    }

    /**
     * Attempts to insert the given item into the right pocket.
     * If the item's weight in combination with the existing weight of the
     * items in the pocket would exceed the max weight for the pocket,
     * or if the item's weight is invalid (ie negative), an exception
     * is thrown.
     *
     * @param itemName   The name of the item to insert
     * @param itemWeight The weight of the item to insert
     * @throws Exception If the weight is invalid
     */
    public void insertItemInRightPocket(String itemName, double itemWeight) throws Exception {
        rightPocket.insertItemInPocket(itemName, itemWeight);
    }

    /**
     * Attempts to insert the given item into the left pocket.
     * If the item's weight in combination with the existing weight of the
     * items in the pocket would exceed the max weight for the pocket,
     * or if the item's weight is invalid (ie negative), an exception
     * is thrown.
     *
     * @param itemName   The name of the item to insert
     * @param itemWeight The weight of the item to insert
     * @throws Exception If the weight is invalid
     */
    public void insertItemInLeftPocket(String itemName, double itemWeight) throws Exception {
        leftPocket.insertItemInPocket(itemName, itemWeight);
    }

    /**
     * Attempts to remove the given item from the main pocket.
     * If the item is found in the pocket, the pocket's total weight
     * is automatically adjusted.
     * If the item is not found in the pocket, an {@link ItemNotFound} exception is thrown.
     *
     * @param itemName The name of the item to remove
     * @throws Exception If the item is not found in the pocket
     */
    public void removeItemFromMainPocket(String itemName) throws Exception {
        mainPocket.removeItemFromPocket(itemName);
    }

    /**
     * Attempts to remove the given item from the right pocket.
     * If the item is found in the pocket, the pocket's total weight
     * is automatically adjusted.
     * If the item is not found in the pocket, an {@link ItemNotFound} exception is thrown.
     *
     * @param itemName The name of the item to remove
     * @throws Exception If the item is not found in the pocket
     */
    public void removeItemFromRightPocket(String itemName) throws Exception {
        rightPocket.removeItemFromPocket(itemName);
    }

    /**
     * Attempts to remove the given item from the left pocket.
     * If the item is found in the pocket, the pocket's total weight
     * is automatically adjusted.
     * If the item is not found in the pocket, an {@link ItemNotFound} exception is thrown.
     *
     * @param itemName The name of the item to remove
     * @throws Exception If the item is not found in the pocket
     */
    public void removeItemFromLeftPocket(String itemName) throws Exception {
        leftPocket.removeItemFromPocket(itemName);
    }

    /**
     * Instructs the {@link Pocket} to call its {@link Pocket#listItemsInPocket()} method.
     * This will print out the items in the main pocket.
     */
    public void listItemsInMainPocket() {
        mainPocket.listItemsInPocket();
    }

    /**
     * Instructs the {@link Pocket} to call its {@link Pocket#listItemsInPocket()} method.
     * This will print out the items in the right pocket.
     */
    public void listItemsInRightPocket() {
        rightPocket.listItemsInPocket();
    }

    /**
     * Instructs the {@link Pocket} to call its {@link Pocket#listItemsInPocket()} method.
     * This will print out the items in the left pocket.
     */
    public void listItemsInLeftPocket() {
        leftPocket.listItemsInPocket();
    }

    /**
     * Returns the total weight associated with the main pocket.
     *
     * @return the total weight associated with the main pocket.
     */
    public double getMainPocketTotalWeight() {
        return mainPocket.getPocketTotalWeight();
    }

    /**
     * Returns the total weight associated with the right pocket.
     *
     * @return the total weight associated with the right pocket.
     */
    public double getRightPocketTotalWeight() {
        return rightPocket.getPocketTotalWeight();
    }

    /**
     * Returns the total weight associated with the left pocket.
     *
     * @return the total weight associated with the left pocket.
     */
    public double getLeftPocketTotalWeight() {
        return leftPocket.getPocketTotalWeight();
    }

    /**
     * Prints out the items in all of the backpack's pockets.
     */
    public void listItemsInBackpack() {
        System.out.println("Listing all backpack items...\n");

        listItemsInLeftPocket();
        listItemsInMainPocket();
        listItemsInRightPocket();
    }

    /**
     * Returns the total weight of all the items in the backpack.
     * This is the same as calling {@link Backpack#getLeftPocketTotalWeight()}, {@link Backpack#getMainPocketTotalWeight()},
     * and {@link Backpack#getRightPocketTotalWeight()} and adding them together.
     *
     * @return the total weight of all the items in the backpack.
     */
    public double getTotalWeight() {
        double totalWeight = 0;

        totalWeight += getLeftPocketTotalWeight();
        totalWeight += getMainPocketTotalWeight();
        totalWeight += getRightPocketTotalWeight();

        return totalWeight;
    }

    /**
     * Returns true if there is another pocket to iterate over.
     *
     * @return true if there is another pocket to iterate over.
     */
    public boolean hasNext() {
        return currentIteratingPocket < POCKET_QUANTITY;
    }

    /**
     * Returns the next pocket to iterate over.
     * Pocketes are ordered as follows:
     * 0 - Left
     * 1 - Main
     * 2 - Right
     *
     * @return the next pocket to iterate over.
     */
    public Pocket next() {
        return switch (currentIteratingPocket++) {
            case 0 -> leftPocket;
            case 1 -> mainPocket;
            case 2 -> rightPocket;
            default -> null;
        };
    }

    /**
     * Returns an iterator for the backpack's pockets.
     *
     * @return an iterator for the backpack's pockets.
     */
    public Iterator<Pocket> iterator() {
        currentIteratingPocket = 0;
        return this;
    }

    /**
     * Exceptions require a cause to be included (that presumably specifies
     * the underlying operation that caused the Exception [insert / remove]).
     *
     */

    /**
     * Super class to allow for easily formatting messages alongside supplying a {@link Throwable} cause.
     * In this project all exceptions are expected to have a Cause, as such this class
     * ensures that all exceptions have a cause. Ideally all constructions of this class
     * should specify an underlying cause, otherwise the cause will be a generic {@link Exception}
     * with the message "Unknown cause".
     */
    public static class CausedException extends Exception {
        /**
         * A default helper constructor to easily format the exception message.
         *
         * @param itemNotFoundException The message to be formatted.
         * @param args                  Optional varargs to format the string according to Java formatting specifications.
         */
        public CausedException(String itemNotFoundException, Object... args) {
            super(itemNotFoundException.formatted(args), new Exception("Unknown cause"));
        }

        /**
         * A helper constructor to easily format the exception message with a Throwable cause.
         *
         * @param itemNotFoundException The message to be formatted.
         * @param cause                 The underlying cause of this exception.
         * @param args                  Optional varargs to format the string according to Java formatting specifications.
         */
        public CausedException(String itemNotFoundException, Throwable cause, Object... args) {
            super(itemNotFoundException.formatted(args), cause);
        }

        /**
         * A helper constructor to easily format the exception message with a String cause.
         *
         * @param itemNotFoundException The message to be formatted.
         * @param cause                 The underlying cause of this exception.
         * @param args                  Optional varargs to format the string according to Java formatting specifications.
         */
        public CausedException(String itemNotFoundException, String cause, Object... args) {
            super(itemNotFoundException.formatted(args), new Exception(cause));
        }
    }

    /**
     * Thrown when an item is not found in a pocket.
     */
    public static class ItemNotFound extends CausedException {
        /**
         * A default helper constructor to easily format the exception message.
         *
         * @param itemNotFoundException The message to be formatted.
         * @param cause                 The underlying cause of this exception.
         * @param args                  Optional varargs to format the string according to Java formatting specifications.
         */
        public ItemNotFound(String itemNotFoundException, Throwable cause, Object... args) {
            super(itemNotFoundException, cause, args);
        }

        /**
         * A helper constructor to easily format the exception message.
         *
         * @param itemNotFoundException The message to be formatted.
         * @param cause                 The underlying cause of this exception.
         * @param args                  Optional varargs to format the string according to Java formatting specifications.
         */
        public ItemNotFound(String itemNotFoundException, String cause, Object... args) {
            super(itemNotFoundException, new Exception(cause), args);
        }
    }

    /**
     * Thrown when an item's weight is invalid (ie non-positive).
     */
    public static class ItemWeightInvalid extends CausedException {
        /**
         * A default helper constructor to easily format the exception message.
         *
         * @param itemNotFoundException The message to be formatted.
         * @param args                  Optional varargs to format the string according to Java formatting specifications.
         */
        public ItemWeightInvalid(String itemNotFoundException, Object... args) {
            super(itemNotFoundException, args);
        }

        /**
         * A default helper constructor to easily format the exception message.
         *
         * @param itemNotFoundException The message to be formatted.
         * @param cause                 The underlying cause of this exception.
         * @param args                  Optional varargs to format the string according to Java formatting specifications.
         */
        public ItemWeightInvalid(String itemNotFoundException, Throwable cause, Object... args) {
            super(itemNotFoundException, cause, args);
        }
    }

    /**
     * Thrown when adding an item weight would exceed the max weight of a pocket
     * due to the item's weight in combination with the existing weight of the items.
     */
    public static class ItemOverweight extends CausedException {
        /**
         * A default helper constructor to easily format the exception message.
         *
         * @param itemNotFoundException The message to be formatted.
         * @param args                  Optional varargs to format the string according to Java formatting specifications.
         */
        public ItemOverweight(String itemNotFoundException, Object... args) {
            super(itemNotFoundException, args);
        }
    }
}