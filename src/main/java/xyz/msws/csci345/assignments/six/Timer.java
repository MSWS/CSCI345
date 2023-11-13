package xyz.msws.csci345.assignments.six;

public class Timer extends Notifier {
    private int timePeriod;

    public void activate() {
        try {
            Thread.sleep(timePeriod * 1000L);
            notifyListeners("wake up!");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void setTimePeriod(int period) {
        timePeriod = period;
    }
}
