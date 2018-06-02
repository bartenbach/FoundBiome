package net.alureon.foundbiome.listener;


import net.alureon.foundbiome.FoundBiome;
import net.alureon.foundbiome.util.BiomeFormatter;
import net.alureon.foundbiome.util.BiomeLists;
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
            // check for completely disabled biomes and biomes that don't count towards the achievement.
            // it would be nice to announce the ones that are new but non-achievement biomes, but we have no way
            // of tracking them without creating out own additional file.  the problem with this is that the minecraft
            // achievement changes all the time.  at the time of this writing, they just added 4 more biomes to it.
            // this would be a mess to maintain - so we only count achievement biomes.
            if (BiomeLists.getDisabledBiomes().contains(newBiome) || BiomeLists.isNonAchievementBiome(newBiome)) {
                return;
            }
            if (!biomeList.contains(newBiome)) {
                biomeList.add(newBiome);
                String message = ChatColor.GREEN + "You've found a "
                        + ChatColor.AQUA + BiomeFormatter.formatBiome(newBiome) + ChatColor.GREEN + " biome!";
                    event.getPlayer().sendMessage(message);
                if (fb.getFileHandler().getBroadcast()) {
                    for (Player p : fb.getServer().getOnlinePlayers()) {
                        if (p != event.getPlayer()) {
                            String announcement = event.getPlayer().getDisplayName() + ChatColor.GREEN + " found a "
                                    + ChatColor.AQUA + BiomeFormatter.formatBiome(newBiome) + ChatColor.GREEN
                                    + " biome!";
                                p.sendMessage(announcement);
                        }
                    }
                }
            }
        }
    }
}
