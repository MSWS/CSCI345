package xyz.msws.csci345.assignments.five;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Name: Isaac Boaz
 * Date: 11/06/23
 * Description: A pocket which holds {@link BackpackItem}s. Each pocket has its own maximum weight.
 */
public class Pocket implements Iterable<BackpackItem> {
    // Constants

    /**
     * The name of the pocket.
     */
    private final String pocketName;

    /**
     * The maximum cumulative weight of items that the pocket can hold.
     */
    private final int maxPocketWeight;

    /**
     * Internal list of {@link BackpackItem}s in the pocket.
     */
    private final List<BackpackItem> pocketItems;

    // Constructor

    /**
     * Creates a new pocket with the given name and maximum weight.
     * Initializes the internal list of {@link BackpackItem}s to an empty list.
     *
     * @param pocketName      The name of the pocket.
     * @param maxPocketWeight The maximum cumulative weight of items that the pocket can hold.
     */
    public Pocket(String pocketName, int maxPocketWeight) {
        this.pocketName = pocketName;
        this.maxPocketWeight = maxPocketWeight;
        this.pocketItems = new ArrayList<>();
    }

    /**
     * Constructs a deep clone of the pocket with the same name,
     * max weight, and items.
     *
     * @param pocket The pocket to clone
     */
    public Pocket(Pocket pocket) {
        this.pocketName = pocket.pocketName;
        this.maxPocketWeight = pocket.maxPocketWeight;
        this.pocketItems = new ArrayList<>(pocket.pocketItems);
    }

    //Methods

    /**
     * Attempts to insert a {@link BackpackItem} corresponding to the given parameters into the pocket.
     * Creates a new {@link BackpackItem} object using the given parameters.
     * <p>
     * If the item weight is less than 0, throws an {@link ItemWeightInvalidException} exception.
     * If adding the item would cause the pocket's maximum weight to be exceeded, throws a
     * {@link ItemOverweightException} exception.
     *
     * @param itemName   The name of the item to be inserted.
     * @param itemWeight The weight of the item to be inserted.
     * @throws ItemOverweightException    If adding the item would cause the pocket's maximum weight to be exceeded.
     * @throws ItemWeightInvalidException If the item weight is less than 0.
     */
    public void insertItemInPocket(String itemName, double itemWeight) throws ItemOverweightException, ItemWeightInvalidException {
        // Slightly reduce line clutter by storing identical suffixes in a variable.
        String suffix = "Item name: %s Item weight: %.2f".formatted(itemName, itemWeight);

        if (itemWeight < 0) // If the item weight is less than 0, throw an exception.
            throw new ItemWeightInvalidException("Invalid weight exception. " + suffix);

        if (getPocketTotalWeight() + itemWeight > maxPocketWeight)
            // Adding the item would cause the pocket's maximum weight to be exceeded, throw an exception.
            throw new ItemOverweightException("Weight exceeded exception. Current pocket weight: %.2f Maximum pocket weight: %d " + suffix, new Exception("Insert"), getPocketTotalWeight(), maxPocketWeight);

        // Weight would not be exceeded, add the item to the pocket.
        pocketItems.add(new BackpackItem(itemName, itemWeight));
    }

    /**
     * Attempts to remove a {@link BackpackItem} with the same name as the given parameter from the pocket.
     * <p>
     * If no item with the given name is found, throws a {@link ItemNotFoundException} exception.
     *
     * @param itemName The name of the item to be removed.
     * @throws ItemNotFoundException If no item with the given name is found.
     */
    public void removeItemFromPocket(String itemName) throws ItemNotFoundException {
        if (pocketItems.removeIf(item -> item.itemName.equals(itemName))) return;

        // Since removeIf returns true if we removed the item, we can assume that if we reach this point,
        // the item was not found. Thus, we throw an exception.

        throw new ItemNotFoundException("Item not found exception. Item name: %s", "Remove", itemName);
    }

    /**
     * Calculates and returns the total weight of all the items in the Pocket.
     * This is the same as summing all of the {@link BackpackItem#itemWeight}s in the pocket.
     *
     * @return the total weight of all the items in the pocket.
     */
    public double getPocketTotalWeight() {
        double totalWeight = 0;

        for (BackpackItem item : pocketItems)
            totalWeight += item.itemWeight;

        return totalWeight;
    }

    /**
     * Lists all the items in the pocket along with their corresponding weights.
     */
    public void listItemsInPocket() {
        System.out.println("Listing " + pocketName + " Pocket Items...");

        for (BackpackItem item : pocketItems)
            System.out.println("Item name: " + item.itemName + " Item weight: " + item.itemWeight);
    }

    /**
     * Returns an iterator for the pocket's items.
     *
     * @return an iterator for the pocket's items.
     */
    public Iterator<BackpackItem> iterator() {
        return pocketItems.iterator();
    }

    /**
     * Compares two pockets for equality, two pockets are considered
     * equal if they have the same name, maximum weight, and items.
     * Items are considered equal if they have the same name and weight.
     *
     * @param obj The object to compare to.
     * @return true if the pockets are equal, false otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Pocket other)) return false;
        if (obj == this) return true;
        if (!other.pocketName.equals(this.pocketName)) return false;
        if (other.maxPocketWeight != this.maxPocketWeight) return false;

        // By default, #equals checks object references.
        // Since we didn't implement BackpackItem#equals, we can't use this.
        // if (!other.pocketItems.equals(this.pocketItems)) return false;

        // Instead we have to manually check each item.
        if (other.pocketItems.size() != this.pocketItems.size()) return false;
        for (int i = 0; i < this.pocketItems.size(); i++) {
            BackpackItem a = this.pocketItems.get(i);
            BackpackItem b = other.pocketItems.get(i);
            if (!a.itemName.equals(b.itemName)) return false;
            if (a.itemWeight != b.itemWeight) return false;
        }

        return true;
    }

    /**
     * Returns a deep clone of the pocket.
     *
     * @return a deep clone of the pocket.
     * @throws CloneNotSupportedException if the pocket cannot be cloned.
     */
    @Override
    public Object clone() throws CloneNotSupportedException {
        return new Pocket(this);
    }
}