package kascode;

public class Time {

    public static final String AM = "AM";
    public static final String PM = "PM";
    public static final byte DECREMENT = 12;
    public static final byte DEFAULT_HOUR = 0;
    public static final byte DEFAULT_MINUTES = 0;

    private final byte hour;
    private final byte minutes;
    private final byte hour12;
    private final String period;

    public Time (byte hour, byte minutes) {

        if ((hour > 23) || (hour < 0)) {
            hour = DEFAULT_HOUR;
        }

        if ((minutes > 59) || (minutes < 0)) {
            minutes = DEFAULT_MINUTES;
        }

        this.hour = hour;
        this.minutes = minutes;

        if ((hour > 12) || (hour == 0)) {
            hour12 = (byte) Math.abs(hour - Time.DECREMENT);
            period = Time.PM;
        } else {
            hour12 = hour;
            period = Time.AM;
        }
    }

    public String getHour (boolean normalized) {
        if (normalized) {
            return normalize (hour);
        } else {
            return Integer.toString(hour);
        }
    }

    public String getMinutes(boolean normalized) {
        if (normalized) {
            return normalize (minutes);
        } else {
            return Integer.toString(minutes);
        }
    }

    public String getHour12 (boolean normalized) {
        if (normalized) {
            return normalize (hour12);
        } else {
            return Integer.toString(hour12);
        }
    }

    public String getPeriod () {
        return period;
    }

    private static String normalize (byte num) {
        if (num < 10) {
            return "0" + num;
        } else {
            return Byte.toString(num);
        }
    }
}
