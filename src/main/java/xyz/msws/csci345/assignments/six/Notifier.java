package xyz.msws.csci345.assignments.six;

import java.util.ArrayList;
import java.util.List;

public class Notifier {
    private final List<IListener> listeners = new ArrayList<>();

    public void notifyListeners(String message) {
        for (IListener listener : listeners)
            listener.notify(message);
    }

    public void registerListener(IListener listener) {
        listeners.add(listener);
    }
}
