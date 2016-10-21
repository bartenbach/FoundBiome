package net.alureon.foundbiome.file;


import me.Senneistheboss.abapi.ActionBarAPI;
import net.alureon.foundbiome.FoundBiome;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

public class ActionBarHandler {


    private FoundBiome fb;


    public ActionBarHandler(FoundBiome fb) {
        this.fb = fb;
    }

    public static void sendActionBar(final Player player, final String message, int duration, Plugin instance) {
        ActionBarAPI.send(message, player);

        if (duration >= 0) {
            // Sends empty message at the end of the duration. Allows messages shorter than 3 seconds, ensures precision.
            new BukkitRunnable() {
                @Override
                public void run() {
                    ActionBarAPI.send("", player);
                }
            }.runTaskLater(instance, duration + 1);
        }

        // Re-sends the messages every 3 seconds so it doesn't go away from the player's screen.
        while (duration > 60) {
            duration -= 60;
            int sched = duration % 60;
            new BukkitRunnable() {
                @Override
                public void run() {
                    ActionBarAPI.send(message, player);
                }
            }.runTaskLater(instance, (long) sched);
        }
    }

}
