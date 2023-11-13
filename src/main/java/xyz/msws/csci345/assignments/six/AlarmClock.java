package xyz.msws.csci345.assignments.six;

public class AlarmClock {
    private final Timer timer;

    public AlarmClock(Timer timer) {
        this.timer = timer;
    }

    public void setAlarm(int period) {
        timer.setTimePeriod(period);
        timer.activate();
    }

}
