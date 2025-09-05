package main.java.org.rabbittownsoftware.jtime;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Scheduler allows delayed callbacks in real or game time.
 */
@SuppressWarnings("unused")
public class Scheduler
{
    private static class Task
    {
        float timeRemaining;
        final Runnable callback;

        Task(float delay, Runnable callback)
        {
            this.timeRemaining = delay;
            this.callback = callback;
        }
    }

    private final List<Task> tasks = new ArrayList<>();

    /** Schedule a task after X seconds (real time). */
    public void schedule(float delaySeconds, Runnable callback)
    {
        tasks.add(new Task(delaySeconds, callback));
    }

    /** Update scheduler each frame. */
    public void update(float deltaTime)
    {
        Iterator<Task> it = tasks.iterator();
        while (it.hasNext())
        {
            Task task = it.next();
            task.timeRemaining -= deltaTime;
            if (task.timeRemaining <= 0)
            {
                task.callback.run();
                it.remove();
            }
        }
    }
}
