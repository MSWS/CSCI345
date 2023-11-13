package xyz.msws.csci345.assignments.six;

import java.util.ArrayList;
import java.util.List;

/**
 * Name: Isaac Boaz
 * Date: 11/13/23
 * Description: A base class to hold listeners and notify them of events.
 */
public class Notifier {
    private final List<IListener> listeners = new ArrayList<>();

    /**
     * Notifies all listeners of an event.
     *
     * @param message The message to send to the listeners.
     */
    public void notifyListeners(String message) {
        for (IListener listener : listeners)
            listener.notify(message);
    }

    /**
     * Registers a listener to be notified of events.
     *
     * @param listener The listener to register.
     */
    public void registerListener(IListener listener) {
        listeners.add(listener);
    }
}
