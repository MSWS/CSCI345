package xyz.msws.csci345.assignments.four;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Name: Isaac Boaz
 * Date: 10/31/23
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
    private final ArrayList<BackpackItem> pocketItems;

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

    //Methods

    /**
     * Attempts to insert a {@link BackpackItem} corresponding to the given parameters into the pocket.
     * Creates a new {@link BackpackItem} object using the given parameters.
     * <p>
     * If the item weight is less than 0, throws an {@link Backpack.ItemWeightInvalid} exception.
     * If adding the item would cause the pocket's maximum weight to be exceeded, throws a
     * {@link Backpack.ItemOverweight} exception.
     *
     * @param itemName   The name of the item to be inserted.
     * @param itemWeight The weight of the item to be inserted.
     * @throws Exception If the item weight is less than 0, throws an {@link Backpack.ItemWeightInvalid} exception.
     *                   If adding the item would cause the pocket's maximum weight to be exceeded,
     *                   throws a {@link Backpack.ItemOverweight} exception.
     */
    public void insertItemInPocket(String itemName, double itemWeight) throws Exception {
        // Slightly reduce line clutter by storing identical suffixes in a variable.
        String suffix = "Item name: %s Item weight: %.2f".formatted(itemName, itemWeight);

        if (itemWeight < 0) // If the item weight is less than 0, throw an exception.
            throw new Backpack.ItemWeightInvalid("Invalid weight exception. " + suffix);

        if (getPocketTotalWeight() + itemWeight > maxPocketWeight)
            // Adding the item would cause the pocket's maximum weight to be exceeded, throw an exception.
            throw new Backpack.ItemOverweight(
                    "Weight exceeded exception. Current pocket weight: %.2f Maximum pocket weight: %d " + suffix,
                    new Exception("Insert"),
                    getPocketTotalWeight(), maxPocketWeight);

        // Weight would not be exceeded, add the item to the pocket.
        pocketItems.add(new BackpackItem(itemName, itemWeight));
    }

    /**
     * Attempts to remove a {@link BackpackItem} with the same name as the given parameter from the pocket.
     * <p>
     * If no item with the given name is found, throws a {@link Backpack.ItemNotFound} exception.
     *
     * @param itemName The name of the item to be removed.
     * @throws Exception If no item with the given name is found, throws a {@link Backpack.ItemNotFound} exception.
     */
    public void removeItemFromPocket(String itemName) throws Exception {
        if (pocketItems.removeIf(item -> item.itemName.equals(itemName))) return;

        // Since removeIf returns true if we removed the item, we can assume that if we reach this point,
        // the item was not found. Thus, we throw an exception.

        throw new Backpack.ItemNotFound("Item not found exception. Item name: %s", "Remove", itemName);
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
}