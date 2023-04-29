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

    /**
     * @param plugin Passa il valore del plugin
     */
    public TaskBuilder(EnumPlugin plugin) {
        this.plugin = plugin;
    }


    // Permette di creare delle task asincrone.
    public TaskBuilder async() {
        this.async = true;
        return this;
    }

    // Il tipo di task che si va a creare.
    public TaskBuilder type(TaskType type) {
        this.type = type;
        return this;
    }

    /**
     * Assegna il delay che ha una task
     * @param delay Il delay che si va ad assegnare
     */
    public TaskBuilder delay(int delay) {
        this.delay = delay;
        return this;
    }

    /**
     * Assegna il delay che ha una task
     * @param delay Il delay che si va ad assegnare
     * @param period Il periodo in cui si va a ripetere la task
     */
    public TaskBuilder delay(int delay, int period) {
        this.delay = delay;
        this.period = period;
        return this;
    }

    /**
     * Si assegnano le azioni che la task va ad eseguire
     * @param runnable Le azioni che vengono eseguite
     */
    public TaskBuilder runnable(Runnable runnable) {
        this.runnable = runnable;
        return this;
    }

    // Starta la task utilizzando tutti i valori che sono stati assegnati precedentemente.
    public void start() {
        if (type.equals(TaskType.LATER)) {
            if (async) {
                Bukkit.getScheduler().runTaskLaterAsynchronously(plugin, runnable, delay * 20L);
            } else {
                Bukkit.getScheduler().runTaskLater(plugin, runnable, delay * 20L);
            }
            reset();
            return;
        }
        if (type.equals(TaskType.TIMER)) {
            if (async) {
                Bukkit.getScheduler().runTaskTimerAsynchronously(plugin, runnable, delay * 20L, period * 20L);
            } else {
                Bukkit.getScheduler().runTaskTimer(plugin, runnable, delay * 20L, period * 20L);
            }
        }
        reset();
    }

    // Reimposta la task allo stato iniziale.
    private void reset() {
        delay = -1;
        period = -1;
        async = false;
        runnable = null;
        type = null;
    }

}