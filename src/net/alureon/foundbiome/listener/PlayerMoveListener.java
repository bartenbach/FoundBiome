package net.alureon.foundbiome.listener;


import net.alureon.foundbiome.FoundBiome;
import org.apache.commons.lang.WordUtils;
import org.bukkit.ChatColor;
import org.bukkit.block.Biome;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import java.util.ArrayList;

public class PlayerMoveListener implements Listener {


    private FoundBiome fb;


    public PlayerMoveListener(FoundBiome fb) {
        this.fb = fb;
    }

    @EventHandler (priority = EventPriority.MONITOR, ignoreCancelled = false)
    public void onPlayerMove(PlayerMoveEvent event) {
        if (event.getFrom().getBlock().getBiome() != event.getTo().getBlock().getBiome()) {
            ArrayList<Biome> biomeList = fb.getMapHandler().getPlayerBiomeList(event.getPlayer());
            if (!biomeList.contains(event.getTo().getBlock().getBiome())) {
                biomeList.add(event.getTo().getBlock().getBiome());
                event.getPlayer().sendMessage(ChatColor.GREEN + "You've found a " + ChatColor.AQUA
                        + WordUtils.capitalize(fb.getBiomeTranslation().translateBiome(event.getTo().getBlock().getBiome()))
                        + ChatColor.GREEN + " biome");
            }
        }
    }
}
