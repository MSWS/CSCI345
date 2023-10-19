package xyz.msws.csci345.assignments.three;

import java.util.ArrayList;

/**
 * Name: Isaac Boaz
 * Date: 10/19/23
 * Description: A wrapper class for an abstract pocket that holds an arbitrary number of {@link BackpackItem}s.
 * Wraps around a String for its name, and an int for its max weight.
 * Supports duplicate items with the same name.
 * It is expected that the program calls removeItemFromPocket with the same weight as used in
 * insertItemInPocket, though this is not enforced.
 */
public class Pocket {
    private String pocketName;
    private int maxPocketWeight;

    ArrayList<BackpackItem> pocketItems = new ArrayList<>();

    public Pocket(String pocketName, int maxPocketWeight) {
        this.pocketName = pocketName;
        this.maxPocketWeight = maxPocketWeight;
    }

    public boolean insertItemInPocket(String itemName, double itemWeight) {
        if (getPocketTotalWeight() + itemWeight > maxPocketWeight)
            return false;
        pocketItems.add(new BackpackItem(itemName, itemWeight));
        return true;
    }

    public boolean removeItemFromPocket(String itemName) {
        for (var item : pocketItems) {
            if (!item.itemName.equals(itemName))
                continue;
            pocketItems.remove(item);
            return true;
        }
        // Item not found
        return false;
    }

    public double getPocketTotalWeight() {
        double weight = 0;
        for (var item : pocketItems)
            weight += item.itemWeight;
        return weight;
    }

    public void listItemsInPocket() {
        System.out.printf("Listing %s Pocket Items...\n", pocketName);
        for (var item : pocketItems)
            System.out.printf("%s (%.2f)\n", item.itemName, item.itemWeight);
    }
}
