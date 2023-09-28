package xyz.msws.csci345.assignments.one;/*
#  Name:
#  Date:
#  Description:
*/

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        System.out.println("Running the Backpack application...");

        Backpack backpack = new Backpack();

        boolean result = backpack.insertItemsInMainPocket(8);

        if (result == true) {
            System.out.println("Item inserted in main pocket...");
        } else {
            System.out.println("Item could not be inserted in main pocket...");
        }

        result = backpack.insertItemsInRightPocket(4);

        if (result == true) {
            System.out.println("Item inserted in right pocket...");
        } else {
            System.out.println("Item could not be inserted in right pocket...");
        }

        result = backpack.insertItemsInLeftPocket(4);

        if (result == true) {
            System.out.println("Item inserted in left pocket...");
        } else {
            System.out.println("Item could not be inserted in left pocket...");
        }

        double backPackTotalWeight = backpack.getTotalWeight();

        System.out.println("Backpack total weight: " + backPackTotalWeight);

        result = backpack.removeItemsInMainPocket(2);

        if (result == true) {
            System.out.println("Item removed from main pocket...");
        } else {
            System.out.println("Item could not be removed from main pocket...");
        }

        backPackTotalWeight = backpack.getTotalWeight();

        System.out.println("Backpack total weight: " + backPackTotalWeight);

        keyboard.close();
    }
}

