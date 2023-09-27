package xyz.msws.csci345.assignments.one;

/**
 * Name: Isaac Boaz
 * Date: 09/27/23
 * Description: Assignment 1 for CSCI 345
 */
public class Backpack {
    /**
     * Represents a pocket type from the backpack.
     * Each pocket has its own associated weight and max weight.
     */
    public enum Pocket {
        MAIN(10), LEFT(5), RIGHT(5);

        private final double maxWeight;

        Pocket(double maxWeight) {
            this.maxWeight = maxWeight;
        }
    }

    // Needed to fulfill the assignment requirements, but not used
    public static final double LEFT_POCKET_MAX_WEIGHT = Pocket.LEFT.maxWeight, RIGHT_POCKET_MAX_WEIGHT = Pocket.RIGHT.maxWeight, MAIN_POCKET_MAX_WEIGHT = Pocket.MAIN.maxWeight;

    // We could potentially use a map or enum to store the weights, but that would not meet the requirements of the assignment
    private double mainPocketWeight, leftPocketWeight, rightPocketWeight;

    public boolean insertItemsInMainPocket(double weight) {
        return insertItemsInPocket(Pocket.MAIN, weight);
    }

    public boolean insertItemsInRightPocket(double weight) {
        return insertItemsInPocket(Pocket.RIGHT, weight);
    }

    public boolean insertItemsInLeftPocket(double weight) {
        return insertItemsInPocket(Pocket.LEFT, weight);
    }

    public boolean removeItemsInMainPocket(double weight) {
        return insertItemsInPocket(Pocket.MAIN, -weight);
    }

    public boolean removeItemsInRightPocket(double weight) {
        return insertItemsInPocket(Pocket.RIGHT, -weight);
    }

    public boolean removeItemsInLeftPocket(double weight) {
        return insertItemsInPocket(Pocket.LEFT, -weight);
    }

    /**
     * Simple utility wrapper for modifying items into a pocket.
     *
     * @param weight Weight of the item to insert. If negative, the item will be removed.
     * @param pocket Pocket to insert the item into
     * @return True if the item was inserted, false if the item could not be inserted due to weight restrictions
     */
    public boolean insertItemsInPocket(Pocket pocket, double weight) {
        return setWeight(pocket, getWeight(pocket) + weight);
    }

    public double getWeight(Pocket pocket) {
        return switch (pocket) {
            case LEFT -> leftPocketWeight;
            case RIGHT -> rightPocketWeight;
            case MAIN -> mainPocketWeight;
        };
    }

    /**
     * Gets the total weight of the backpack from all pockets.
     *
     * @return Total weight of the backpack
     */
    public double getTotalWeight() {
        double total = 0;
        for (Pocket pocket : Pocket.values())
            total += getWeight(pocket);
        return total;
    }

    /**
     * Sets the weight of a pocket, checking for weight restrictions.
     *
     * @param pocket Pocket to set the weight of
     * @param weight Weight to set the pocket to
     * @return True if the weight was set, false if the weight was not set due to weight restrictions
     */
    private boolean setWeight(Pocket pocket, double weight) {
        if (weight > pocket.maxWeight) return false; // Too heavy!
        if (weight < 0) return false; // Too light! Are you putting helium in it?!
        switch (pocket) {
            case LEFT -> leftPocketWeight = weight;
            case RIGHT -> rightPocketWeight = weight;
            case MAIN -> mainPocketWeight = weight;
        }
        return true;
    }
}
