package lll1234.time;

public class TimeInterval {
    private static final int SECONDS_IN_MINUTE = 60;
    private static final int MINUTES_IN_HOUR = 60;
    private int seconds;
    private int minutes;
    private int hours;

    public TimeInterval(int totalSeconds) {
        this.hours = totalSeconds / 3600;
        this.minutes = totalSeconds % 3600 / 60;
        this.seconds = totalSeconds % 3600 % 60;
    }

    public TimeInterval(int seconds, int minutes, int hours) {
        this.seconds = seconds;
        this.minutes = minutes;
        this.hours = hours;
    }

    public int totalSeconds() {
        return seconds + minutes * SECONDS_IN_MINUTE + hours * SECONDS_IN_MINUTE * MINUTES_IN_HOUR;
    }

    public TimeInterval sum(TimeInterval second) {
        return new TimeInterval(totalSeconds() + second.totalSeconds());
    }

    @Override
    public String toString() {
        return "TimeInterval hours= " + hours + " minutes= " + minutes + " seconds= " + seconds;
    }
}
