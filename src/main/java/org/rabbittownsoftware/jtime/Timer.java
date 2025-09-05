package main.java.org.rabbittownsoftware.jtime;

/**
 * Timer is a simple stopwatch utility for measuring elapsed time,
 * cooldowns, and delays in games.
 */
@SuppressWarnings("unused")
public class Timer
{
    private float duration;   // how long before timer completes (seconds)
    private float elapsed;    // how much has passed
    private boolean running;

    public Timer(float duration)
    {
        if (duration <= 0) throw new IllegalArgumentException("Duration must be > 0");
        this.duration = duration;
        this.elapsed = 0;
        this.running = false;
    }

    /** Start or restart the timer. */
    public void start()
    {
        this.elapsed = 0;
        this.running = true;
    }

    /** Update the timer by deltaTime. */
    public void update(float deltaTime)
    {
        if (!running) return;
        elapsed += deltaTime;
    }

    /** @return true if the timer has finished. */
    public boolean isFinished()
    {
        return running && elapsed >= duration;
    }

    /** Stop the timer early. */
    public void stop() { running = false; }

    /** @return progress from 0.0 → 1.0. */
    public float getProgress()
    {
        return Math.min(elapsed / duration, 1.0f);
    }
}
