package xyz.msws.csci345.assignments.six;

public class TimerListener implements IListener {
    private final String name;

    public TimerListener(String name) {
        this.name = name;
    }

    @Override
    public void notify(String message) {
        System.out.printf("%s: %s\n", name, message);
    }
}
