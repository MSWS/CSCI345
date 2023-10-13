package xyz.msws.csci345.assignments.two;

/**
 * Name: Isaac Boaz
 * Date: 10/13/23
 * Description: A class that represents a backpack with three pockets.
 */

import java.util.ArrayList;
import java.util.List;

public class Backpack {
    //Constants
    private final int MAIN_POCKET_MAX_WEIGHT = 10;
    private final int LEFT_POCKET_MAX_WEIGHT = 5;
    private final int RIGHT_POCKET_MAX_WEIGHT = 5;

    //Fields (Data members)
    private final ArrayList<String> mainPocketItems = new ArrayList<String>();
    private final ArrayList<Double> mainPocketItemWeights = new ArrayList<Double>();
    private final ArrayList<String> rightPocketItems = new ArrayList<String>();
    private final ArrayList<Double> rightPocketItemWeights = new ArrayList<Double>();
    private final ArrayList<String> leftPocketItems = new ArrayList<String>();
    private final ArrayList<Double> leftPocketItemWeights = new ArrayList<Double>();

    //Methods
    protected boolean insertItemInPocket(List<String> items, List<Double> weights, String name, double weight, int maxWeight) {
        if (getPocketTotalWeight(weights) + weight > maxWeight) return false;

        items.add(name);
        weights.add(weight);

        return true;
    }

    public boolean insertItemInMainPocket(String itemName, double itemWeight) {
        return insertItemInPocket(mainPocketItems, mainPocketItemWeights, itemName, itemWeight, MAIN_POCKET_MAX_WEIGHT);
    }

    public boolean insertItemInRightPocket(String itemName, double itemWeight) {
        return insertItemInPocket(rightPocketItems, rightPocketItemWeights, itemName, itemWeight, RIGHT_POCKET_MAX_WEIGHT);
    }

    public boolean insertItemInLeftPocket(String itemName, double itemWeight) {
        return insertItemInPocket(leftPocketItems, leftPocketItemWeights, itemName, itemWeight, LEFT_POCKET_MAX_WEIGHT);
    }

    /**
     * Removes the given itemName from the pocketItems and pocketItemWeights.
     * If the given itemName does not exist in the given pocketItems, returns false.
     * Returns true otherwise.
     *
     * @param pocketItems       List of items to remove from
     * @param pocketItemWeights List of weights to remove from, bases off of index of the itemName in the pocketItems list
     * @param itemName          The name of the item to remove
     * @return True if the item was removed, false if the item was not found
     */
    protected boolean removeItemFromPocket(List<String> pocketItems, List<Double> pocketItemWeights, String itemName) {
        int index = pocketItems.indexOf(itemName);
        if (index == -1) return false;
        pocketItems.remove(index);
        pocketItemWeights.remove(index);

        return true;
    }

    public boolean removeItemFromMainPocket(String itemName) {
        return removeItemFromPocket(mainPocketItems, mainPocketItemWeights, itemName);
    }


    public boolean removeItemFromRightPocket(String itemName) {
        return removeItemFromPocket(rightPocketItems, rightPocketItemWeights, itemName);
    }

    public boolean removeItemFromLeftPocket(String itemName) {
        return removeItemFromPocket(leftPocketItems, leftPocketItemWeights, itemName);
    }

    /**
     * Prints out the given items and their weights in the given pocket.
     *
     * @param pocketItems       Items to print out
     * @param pocketItemWeights Associated weights of the items
     * @param pocketName        Name of the pocket to print out
     */
    protected void listItemsInPocket(List<String> pocketItems, List<Double> pocketItemWeights, String pocketName) {
        System.out.println("Listing items in " + pocketName + " pocket...\n");

        for (int i = 0; i < pocketItems.size(); i++)
            System.out.println("%s (%.2f)".formatted(pocketItems.get(i), pocketItemWeights.get(i)));
    }

    public void listItemsInMainPocket() {
        listItemsInPocket(mainPocketItems, mainPocketItemWeights, "main");
    }

    public void listItemsInRightPocket() {
        listItemsInPocket(rightPocketItems, rightPocketItemWeights, "right");
    }

    public void listItemsInLeftPocket() {
        listItemsInPocket(leftPocketItems, leftPocketItemWeights, "left");
    }

    protected double getPocketTotalWeight(List<Double> weights) {
        double total = 0;
        for (double weight : weights)
            total += weight;
        return total;
    }

    public double getMainPocketTotalWeight() {
        return getPocketTotalWeight(mainPocketItemWeights);
    }

    public double getRightPocketTotalWeight() {
        return getPocketTotalWeight(rightPocketItemWeights);
    }

    public double getLeftPocketTotalWeight() {
        return getPocketTotalWeight(leftPocketItemWeights);
    }

    public void listItemsInBackpack() {
        System.out.println("Listing all backpack items...\n");

        listItemsInLeftPocket();
        listItemsInRightPocket();
        listItemsInMainPocket();
    }


    public double getTotalWeight() {
        double totalWeight = 0.0;

        totalWeight += getMainPocketTotalWeight();
        totalWeight += getLeftPocketTotalWeight();
        totalWeight += getRightPocketTotalWeight();

        return totalWeight;
    }


}
