package it.enumproject.libs.task;

import it.enumproject.libs.EnumPlugin;
import org.bukkit.Bukkit;

public class TaskBuilder {

    private final EnumPlugin plugin;

    private Runnable runnable;
    private TaskType type;
    private boolean async;
    private int delay;
    private int period;

    public TaskBuilder(EnumPlugin plugin) {
        this.plugin = plugin;
    }

    public TaskBuilder async() {
        this.async = true;
        return this;
    }

    public TaskBuilder type(TaskType type) {
        this.type = type;
        return this;
    }

    public TaskBuilder delay(int delay) {
        this.delay = delay;
        return this;
    }

    public TaskBuilder delay(int delay, int period) {
        this.delay = delay;
        this.period = period;
        return this;
    }

    public TaskBuilder runnable(Runnable runnable) {
        this.runnable = runnable;
        return this;
    }

    public void start() {
        if (type.equals(TaskType.LATER)) {
            if(async) {
                if(delay < 0) {
                    Bukkit.getScheduler().runTaskLaterAsynchronously(plugin, runnable, delay);
                } else {
                    Bukkit.getScheduler().runTaskAsynchronously(plugin, runnable);
                }
                return;
            }
            if(delay < 0) {
                Bukkit.getScheduler().runTaskLater(plugin, runnable, delay);
            } else {
                Bukkit.getScheduler().runTask(plugin, runnable);
            }
            reset();
            return;
        }
        if (type.equals(TaskType.TIMER)) {
            if(async) {
                if(delay < 0) {
                    Bukkit.getScheduler().runTaskTimerAsynchronously(plugin, runnable, delay, period);
                } else {
                    Bukkit.getScheduler().runTaskAsynchronously(plugin, runnable);
                }
                return;
            }
            if(delay < 0) {
                Bukkit.getScheduler().runTaskTimer(plugin, runnable, delay, period);
            } else {
                Bukkit.getScheduler().runTask(plugin, runnable);
            }
            reset();
        }
    }

    public void reset() {
        delay = -1;
        period = -1;
        async = false;
        runnable = null;
        type = null;
    }

}