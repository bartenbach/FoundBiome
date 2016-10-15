package net.alureon.foundbiome.command;

import net.alureon.foundbiome.FoundBiome;
import org.bukkit.ChatColor;
import org.bukkit.block.Biome;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandHandler implements CommandExecutor {


    private FoundBiome fb;


    public CommandHandler(FoundBiome fb) {
        this.fb = fb;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (label.equalsIgnoreCase("biome") && sender instanceof Player) {
            Biome biome = ((Player) sender).getLocation().getBlock().getBiome();
            sender.sendMessage(biome.toString());
            sender.sendMessage(biome.name());
            sender.sendMessage(biome.getDeclaringClass().toString());
/*            if (fb.getMapHandler().getPlayerBiomeList((Player)sender).size() == 0) {
                sender.sendMessage(ChatColor.GREEN + "It doesn't look like you've explored much yet");
                return true;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(ChatColor.AQUA);
            for (Biome b : fb.getMapHandler().getPlayerBiomeList((Player)sender)) {
                sb.append(b.name().toLowerCase().replaceAll("_", " "));
                sb.append(", ");
            }
            sb.deleteCharAt(sb.length() - 2);
            sender.sendMessage(ChatColor.GREEN + "You've visited the following biomes:");
            sender.sendMessage(sb.toString());*/
            return true;
        }
        return false;
    }
}


