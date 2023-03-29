package it.enumproject.libs.task;

import it.enumproject.libs.EnumPlugin;
import org.bukkit.Bukkit;

public class TaskBuilder {

    private final EnumPlugin plugin;

    private Runnable runnable;
    private boolean async;
    private int delay;

    public TaskBuilder(EnumPlugin plugin) {
        this.plugin = plugin;
    }

    public TaskBuilder async() {
        this.async = true;
        return this;
    }

    public TaskBuilder delay(int delay) {
        this.delay = delay;
        return this;
    }

    public TaskBuilder runnable(Runnable runnable) {
        this.runnable = runnable;
        return this;
    }

    public void start() {
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
        delay = -1;
        async = false;
        runnable = null;
    }

}