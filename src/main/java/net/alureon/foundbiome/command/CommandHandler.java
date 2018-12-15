package net.alureon.foundbiome.command;

import net.alureon.foundbiome.FoundBiome;
import net.alureon.foundbiome.util.BiomeFormatter;
import net.alureon.foundbiome.util.BiomeLists;
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
        ArrayList<Biome> playerBiomes = fb.getMapHandler().getPlayerBiomeList((Player) sender);
        int i = 0;
        for (Biome b : Biome.values()) {
            /*
            A lot of biomes are disabled here.  We don't show them because they don't count towards the achievement and
            cannot be tracked without creating extra files.
             */
            if (!playerBiomes.contains(b) && !BiomeLists.getDisabledBiomes().contains(b)
                    && !b.name().startsWith("MUTATED") && !BiomeLists.isNonAchievementBiome(b)) {
                appendColoredBiome(sb, b, i);
                i++;
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
        int i = 0;
        for (Biome b : fb.getMapHandler().getPlayerBiomeList((Player) sender)) {
            appendColoredBiome(sb, b, i);
            i++;
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

    /**
     * For the sake of readability (there are quite a few biomes to print out), this method takes a number.
     * As long as the number increments, it will return a different color every time it is called, alternating
     * between Aqua and Dark Aqua.  It will append the colored biome to the provided StringBuilder object.
     * @param sb The StringBuilder to append to.
     * @param b The Biome whose name will be appended.
     * @param color A number, which if even will return a dark aqua string. If odd, aqua.
     */
    private void appendColoredBiome(StringBuilder sb, Biome b, int color) {
        if (color % 2 == 0) {
            sb.append(ChatColor.DARK_AQUA);
        } else {
            sb.append(ChatColor.AQUA);
        }
        sb.append(BiomeFormatter.formatBiome(b));
        sb.append(ChatColor.WHITE);
        sb.append(", ");
    }
}


