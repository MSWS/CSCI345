package xyz.msws.csci345.assignments.six;

/**
 * Name: Isaac Boaz
 * Date: 11/13/23
 * Description: Represents a listener that prints the message it receives.
 */
public class TimerListener implements IListener {
    private final String name;

    /**
     * Creates a new listener with the specified name.
     *
     * @param name The name of the thing that is listening.
     */
    public TimerListener(String name) {
        this.name = name;
    }

    /**
     * Prints the message it receives.
     *
     * @param message The message to print.
     */
    @Override
    public void notify(String message) {
        System.out.printf("%s: %s\n", name, message);
    }
}
