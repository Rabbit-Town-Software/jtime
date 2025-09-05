package main.java.org.rabbittownsoftware.jtime;

/**
 * TimeSystem handles the simulation of in-game time progression,
 * including pausing, resetting, and checking time-based triggers.
 *
 * <p>
 * It is flexible enough for RPGs, simulations, and games
 * needing a consistent day/night cycle or timed events.
 * </p>
 */
@SuppressWarnings("unused")
public class TimeSystem
{
    private int hours, minutes, seconds, days;
    private final float progressionRate; // real seconds → game seconds
    private boolean paused;

    /**
     * Constructs a new TimeSystem.
     *
     * @param progressionRate How many in-game seconds pass per real-world second.
     */
    public TimeSystem(float progressionRate)
    {
        this.progressionRate = progressionRate;
        reset();
    }

    /**
     * Updates the in-game time.
     *
     * @param realDelta Seconds elapsed in real-world time since last update.
     */
    public void update(float realDelta)
    {
        if (paused) return;

        float inGameSeconds = realDelta * progressionRate;
        addSeconds((int) inGameSeconds);
    }

    private void addSeconds(int s)
    {
        seconds += s;

        minutes += seconds / 60;
        seconds %= 60;

        hours += minutes / 60;
        minutes %= 60;

        days += hours / 24;
        hours %= 24;
    }

    /** Sets the current in-game time. */
    public void setTime(int h, int m, int s)
    {
        if (h < 0 || h > 23 || m < 0 || m > 59 || s < 0 || s > 59)
            throw new IllegalArgumentException("Invalid time.");

        this.hours = h;
        this.minutes = m;
        this.seconds = s;
    }

    /** @return Current time formatted as "HH:MM:SS". */
    public String getCurrentTime()
    {
        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }

    /** @return Current day count. */
    public int getDays() { return days; }

    /** Pause/unpause time progression. */
    public void setPaused(boolean paused) { this.paused = paused; }
    public boolean isPaused() { return paused; }

    /** Reset time back to 00:00:00, day 0. */
    public void reset()
    {
        hours = 0;
        minutes = 0;
        seconds = 0;
        days = 0;
        paused = false;
    }

    /** Run a callback when the given hour is reached. */
    public void onHourChange(int targetHour, Runnable callback)
    {
        if (hours == targetHour) callback.run();
    }
}
