package xyz.msws.csci345.assignments.five;

/**
 * Name: Isaac Boaz
 * Date: 11/06/23
 * Description: This class represents an arbitrary item that can be placed in a {@link Pocket}.
 *     Each item has a weight associated with it that should be non-negative.
 *     Though creation of an item with a negative weight is not prevented on creation, it will
 *     throw a {@link ItemWeightInvalidException} exception
 *     when attempting to insert it into a {@link Pocket}.
 *     <p>
 *     Fields are public for ease of use.
 */
public class BackpackItem {
    public String itemName;
    public double itemWeight;

    /**
     * Constructs a new {@link BackpackItem} with the given name and weight.
     *
     * @param itemName   The name of the item.
     * @param itemWeight The weight of the item. Should be non-negative.
     */
    public BackpackItem(String itemName, double itemWeight) {
        this.itemName = itemName;
        this.itemWeight = itemWeight;
    }

    /**
     * Returns true if the name and weight of the item are equal.
     *
     * @param obj The object to compare to.
     * @return True if the name and weight of the item are equal.
     */
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof BackpackItem other)) return false;
        if (!other.itemName.equals(itemName)) return false;
        if (other.itemWeight != itemWeight) return false;
        return true;
    }
}