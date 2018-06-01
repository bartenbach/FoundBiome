package net.alureon.foundbiome.command;

import net.alureon.foundbiome.FoundBiome;
import net.alureon.foundbiome.util.BiomeFormatter;
import org.bukkit.ChatColor;
import org.bukkit.block.Biome;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class CommandHandler implements CommandExecutor {


    private FoundBiome fb;


    public CommandHandler(FoundBiome fb) {
        this.fb = fb;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (label.equalsIgnoreCase("fb") && sender instanceof Player) {
            if (args.length == 0) {
                sendCommandHelp(sender);
            } else if (args[0].equalsIgnoreCase("current")) {
                sendCurrentBiome(sender);
                return true;
            } else if (args[0].equalsIgnoreCase("seen")) {
                sendSeenBiomes(sender);
                return true;
            } else if (args[0].equalsIgnoreCase("unseen")) {
                getUnseenBiomes(sender);
            } else if (args[0].equalsIgnoreCase("version")) {
                sender.sendMessage(ChatColor.AQUA + fb.getDescription().getVersion());
            }
        }
        return false;
    }

    private void sendCommandHelp(CommandSender sender) {
        sender.sendMessage(ChatColor.GREEN + "FoundBiome Commands");
        sender.sendMessage(ChatColor.AQUA + "/fb seen     " + ChatColor.WHITE + "-  List biomes you've seen");
        sender.sendMessage(ChatColor.AQUA + "/fb current  " + ChatColor.WHITE + "-  Show your current biome");
        sender.sendMessage(ChatColor.AQUA + "/fb unseen   " + ChatColor.WHITE + "-  List biomes you haven't seen");
    }

    private void getUnseenBiomes(CommandSender sender) {
        StringBuilder sb = new StringBuilder();
        sb.append(ChatColor.AQUA);
        ArrayList<Biome> playerBiomes = fb.getMapHandler().getPlayerBiomeList((Player) sender);
        for (Biome b : Biome.values()) {
            if (!playerBiomes.contains(b)) {
                sb.append(BiomeFormatter.formatBiome(b));
                sb.append(", ");
            }
        }
        sb.deleteCharAt(sb.length() - 2);
        sender.sendMessage(ChatColor.GREEN + "You haven't seen the following biomes:");
        sender.sendMessage(sb.toString());
    }

    private void sendSeenBiomes(CommandSender sender) {
        if (fb.getMapHandler().getPlayerBiomeList((Player) sender).size() == 0) {
            sender.sendMessage(ChatColor.GREEN + "It doesn't look like you've explored much yet");
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(ChatColor.AQUA);
        for (Biome b : fb.getMapHandler().getPlayerBiomeList((Player) sender)) {
            sb.append(BiomeFormatter.formatBiome(b));
            sb.append(", ");
        }
        sb.deleteCharAt(sb.length() - 2);
        sender.sendMessage(ChatColor.GREEN + "You've visited the following biomes:");
        sender.sendMessage(sb.toString());
    }

    private void sendCurrentBiome(CommandSender sender) {
        Biome biome = ((Player) sender).getLocation().getBlock().getBiome();
        sender.sendMessage(ChatColor.GREEN + "You're currently in the following biome:");
        sender.sendMessage(ChatColor.AQUA + BiomeFormatter.formatBiome(biome));
    }
}


