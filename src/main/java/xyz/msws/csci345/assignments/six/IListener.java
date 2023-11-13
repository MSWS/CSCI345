package xyz.msws.csci345.assignments.six;

/**
 * Name: Isaac Boaz
 * Date: 11/13/23
 * Description: Represents a listener that can be notified of events.
 */
public interface IListener {

    /**
     * Notifies the listener of an event.
     *
     * @param message The message to send to the listener.
     */
    void notify(String message);
}
