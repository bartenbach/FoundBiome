package net.alureon.foundbiome.listener;


import net.alureon.foundbiome.FoundBiome;
import net.alureon.foundbiome.file.FileHandler;
import net.alureon.foundbiome.util.BiomeFormatter;
import org.bukkit.ChatColor;
import org.bukkit.block.Biome;
import org.bukkit.entity.Player;
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
            Biome newBiome = event.getTo().getBlock().getBiome();
            if (!biomeList.contains(newBiome)) {
                biomeList.add(newBiome);
                String message = ChatColor.GREEN + "You've found a "
                        + ChatColor.AQUA + BiomeFormatter.formatBiome(newBiome) + ChatColor.GREEN + " biome";
                    event.getPlayer().sendMessage(message);

                if (FileHandler.broadcast) {
                    for (Player p : fb.getServer().getOnlinePlayers()) {
                        if (p != event.getPlayer()) {
                            String announcement = event.getPlayer().getDisplayName() + ChatColor.GREEN + " found a "
                                    + ChatColor.AQUA + BiomeFormatter.formatBiome(newBiome) + ChatColor.GREEN
                                    + " biome";
                                p.sendMessage(announcement);
                        }
                    }
                }
            }
        }
    }
}
