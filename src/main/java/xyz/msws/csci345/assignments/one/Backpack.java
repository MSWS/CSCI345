package xyz.msws.csci345.assignments.one;

/**
 * Name: Isaac Boaz
 * Date: 09/27/23
 * Description: Wrapper for a backpack that has {@see Pocket}s.
 */
public class Backpack {
    /**
     * Represents a pocket type from the backpack.
     * Each pocket has its own associated weight and max weight.
     */
    public enum Pocket {
        MAIN, LEFT, RIGHT;
    }

    // Needed to fulfill the assignment requirements
    public static final double LEFT_POCKET_MAX_WEIGHT = 5, RIGHT_POCKET_MAX_WEIGHT = 5, MAIN_POCKET_MAX_WEIGHT = 10;

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
     * Gets the corresponding pocket's max weight
     *
     * @param pocket Pocket to get the max weight of
     * @return Max weight of the pocket
     */
    public double getMaxWeight(Pocket pocket) {
        return switch (pocket) {
            case LEFT -> LEFT_POCKET_MAX_WEIGHT;
            case RIGHT -> RIGHT_POCKET_MAX_WEIGHT;
            case MAIN -> MAIN_POCKET_MAX_WEIGHT;
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
        if (weight > getMaxWeight(pocket)) return false; // Too heavy!
        if (weight < 0) return false; // Too light! Are you putting helium in it?!
        switch (pocket) {
            case LEFT -> leftPocketWeight = weight;
            case RIGHT -> rightPocketWeight = weight;
            case MAIN -> mainPocketWeight = weight;
        }
        return true;
    }
}
