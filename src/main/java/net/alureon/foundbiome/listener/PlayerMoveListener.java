package net.alureon.foundbiome.listener;


import net.alureon.foundbiome.FoundBiome;
import net.alureon.foundbiome.file.ActionBarHandler;
import net.alureon.foundbiome.file.FileHandler;
import org.apache.commons.text.WordUtils;
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

            if (!biomeList.contains(event.getTo().getBlock().getBiome())) {
                biomeList.add(event.getTo().getBlock().getBiome());
                String message = ChatColor.GREEN + "You've found a " + ChatColor.AQUA
                        + WordUtils.capitalize(fb.getBiomeTranslation().translateBiome(event.getTo().getBlock().getBiome()))
                        + ChatColor.GREEN + " biome";

                if (FileHandler.useActionBar) {
                    ActionBarHandler.sendActionBar(event.getPlayer(), message, 120, fb);

                } else {
                    event.getPlayer().sendMessage(message);
                }

                if (FileHandler.broadcast) {
                    for (Player p : fb.getServer().getOnlinePlayers()) {
                        if (p != event.getPlayer()) {
                            String announcement = event.getPlayer().getDisplayName() + ChatColor.GREEN + " found a " + ChatColor.AQUA
                                    + WordUtils.capitalize(fb.getBiomeTranslation().translateBiome(event.getTo().getBlock().getBiome()))
                                    + ChatColor.GREEN + " biome";

                            if (FileHandler.useActionBar) {
                                ActionBarHandler.sendActionBar(p, announcement, 120, fb);
                            } else {
                                p.sendMessage(announcement);
                            }
                        }
                    }
                }
            }
        }
    }
}
