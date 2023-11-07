package xyz.msws.csci345.assignments.five;/*
#  Name:
#  Date:
#  Description:
*/

import java.util.Scanner;

public class Program
{
    public static void main(String[] args)
    {
        Scanner keyboard = new Scanner(System.in);

        System.out.println("Running the Backpack application...\n");

        try
        {
            Pocket foo = new Pocket("foo", 10);
            Pocket bar = new Pocket("foo", 10);
            foo.insertItemInPocket("a", 2);
            foo.insertItemInPocket("b", 2);
            foo.insertItemInPocket("b", 2);

            bar.insertItemInPocket("a", 2);
            bar.insertItemInPocket("b", 2);
            bar.insertItemInPocket("a", 2);
            System.out.println("Foo = bar: " + foo.equals(bar));
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
            String exceptionMessage = ex.getMessage();
            String exceptionCauseMessage = ex.getCause().getMessage();

            if (exceptionCauseMessage == "Insert")
            {
                System.out.println(exceptionMessage);
            }
            else if (exceptionCauseMessage == "Remove")
            {
                System.out.println(exceptionMessage);
            }
        }

        keyboard.close();
    }
}
