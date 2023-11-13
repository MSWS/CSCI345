package xyz.msws.csci345.assignments.six;

/**
 * Name: Isaac Boaz
 * Date: 11/13/23
 * Description: Represents a timer that can be used to
 * notify listeners after a period of time.
 */
public class Timer extends Notifier {
    private int timePeriod;

    /**
     * Triggers the countdown timer for the internally tracked period.
     */
    public void activate() {
        try {
            Thread.sleep(timePeriod * 1000L);
            notifyListeners("wake up!");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Sets the timer's millisecond period.
     *
     * @param period The period to wait before the timer goes off in milliseconds.
     */
    public void setTimePeriod(int period) {
        timePeriod = period;
    }
}
