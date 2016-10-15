package net.alureon.foundbiome.listener;


import net.alureon.foundbiome.FoundBiome;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinListener implements Listener {


    private FoundBiome fb;


    public PlayerJoinListener(FoundBiome fb) {
        this.fb = fb;
    }


    @EventHandler (priority = EventPriority.MONITOR, ignoreCancelled = false)
    public void onPlayerJoin(PlayerJoinEvent event) {
        fb.getMapHandler().addToMap(event.getPlayer());
    }

}
