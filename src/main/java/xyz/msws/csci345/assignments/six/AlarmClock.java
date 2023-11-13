package xyz.msws.csci345.assignments.six;

/**
 * Name: Isaac Boaz
 * Date: 11/13/23
 * Description: Represents an Alarm Clock with an internal timer.
 * Setting the alarm immediately starts the underlying
 * timer, with {@link Timer#activate()}being called when time is up.
 */
public class AlarmClock {
    private final Timer timer;

    /**
     * The main constructor for an {@link AlarmClock}.
     *
     * @param timer The timer to use for the alarm.
     */
    public AlarmClock(Timer timer) {
        this.timer = timer;
    }

    /**
     * Sets the alarm to go off after the specified period.
     *
     * @param period The period to wait before the alarm goes off in milliseconds.
     */
    public void setAlarm(int period) {
        timer.setTimePeriod(period);
        timer.activate();
    }
}
