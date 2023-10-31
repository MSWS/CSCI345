package xyz.msws.csci345.assignments.four;

/**
 * Name: Isaac Boaz
 * Date: 10/31/23
 * Description: This class represents an arbitrary item that can be placed in a {@link Pocket}.
 * Each item has a weight associated with it that should be non-negative.
 * Though creation of an item with a negative weight is not prevented on creation, it will
 * throw an exception when attempting to insert it into a {@link Pocket}.
 * <p>
 * Fields are public for ease of use.
 */
public class BackpackItem {
    public String itemName;
    public double itemWeight;

    public BackpackItem(String itemName, double itemWeight) {
        this.itemName = itemName;
        this.itemWeight = itemWeight;
    }
}