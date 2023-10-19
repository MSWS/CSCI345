package xyz.msws.csci345.assignments.three;

/**
 * Name: Isaac Boaz
 * Date: 10/19/23
 * Description: A class that represents a backpack with three pockets; each pocket has its own corresponding weight and max weight.
 */
public class Backpack {
    //Constants
    private final int MAIN_POCKET_MAX_WEIGHT = 10;
    private final int LEFT_POCKET_MAX_WEIGHT = 5;
    private final int RIGHT_POCKET_MAX_WEIGHT = 5;

    //Fields (Data members)
    private Pocket mainPocket, rightPocket, leftPocket;

    //Constructors
    public Backpack() {
        this.mainPocket = new Pocket("Main", MAIN_POCKET_MAX_WEIGHT);
        this.rightPocket = new Pocket("Right", RIGHT_POCKET_MAX_WEIGHT);
        this.leftPocket = new Pocket("Left", LEFT_POCKET_MAX_WEIGHT);
    }

    //Methods
    public boolean insertItemInMainPocket(String itemName, double itemWeight) {
        return mainPocket.insertItemInPocket(itemName, itemWeight);
    }

    public boolean insertItemInRightPocket(String itemName, double itemWeight) {
        return rightPocket.insertItemInPocket(itemName, itemWeight);
    }

    public boolean insertItemInLeftPocket(String itemName, double itemWeight) {
        return leftPocket.insertItemInPocket(itemName, itemWeight);
    }

    public boolean removeItemFromMainPocket(String itemName) {
        return mainPocket.removeItemFromPocket(itemName);
    }

    public boolean removeItemFromRightPocket(String itemName) {
        return rightPocket.removeItemFromPocket(itemName);
    }

    public boolean removeItemFromLeftPocket(String itemName) {
        return leftPocket.removeItemFromPocket(itemName);
    }

    public void listItemsInMainPocket() {
        mainPocket.listItemsInPocket();
    }

    public void listItemsInRightPocket() {
        rightPocket.listItemsInPocket();
    }

    public void listItemsInLeftPocket() {
        leftPocket.listItemsInPocket();
    }

    public double getMainPocketTotalWeight() {
        return mainPocket.getPocketTotalWeight();
    }

    public double getRightPocketTotalWeight() {
        return rightPocket.getPocketTotalWeight();
    }

    public double getLeftPocketTotalWeight() {
        return leftPocket.getPocketTotalWeight();
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
