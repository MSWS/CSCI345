package xyz.msws.csci345.assignments.three;

/**
 * Name: Isaac Boaz
 * Date: 10/19/23
 * Description: A wrapper class for an abstract item that can be inserted into a {@link Backpack}.
 * Wraps around a String for its name, and a double for its weight.
 * Both fields are publicly accessible.
 */
public class BackpackItem {
    public String itemName;
    public double itemWeight;

    public BackpackItem(String itemName, double itemWeight) {
        this.itemName = itemName;
        this.itemWeight = itemWeight;
    }
}
