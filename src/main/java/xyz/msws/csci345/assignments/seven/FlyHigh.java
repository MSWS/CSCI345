package xyz.msws.csci345.assignments.seven;

/**
 * Name: Isaac Boaz
 * Date: 11/26/23
 * Description: A flight implementation of {@link IFlyable} that
 * has the animal fly high.
 */
public class FlyHigh implements IFlyable {

    /**
     * Indicates that an animal should fly high.
     */
    @Override
    public void Fly() {
        System.out.println(" is Flying high...");
    }
}
