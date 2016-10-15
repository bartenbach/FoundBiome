package net.alureon.foundbiome;


import net.alureon.foundbiome.command.CommandHandler;
import net.alureon.foundbiome.handler.MapHandler;
import net.alureon.foundbiome.listener.PlayerJoinListener;
import net.alureon.foundbiome.listener.PlayerMoveListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

/*  Attribute Only (Public) License
        Version 0.a3, July 11, 2011
    Copyright (C) 2016 Blake Bartenbach <blakebartenbach@gmail.com> (@ialureon)
    Anyone is allowed to copy and distribute verbatim or modified
    copies of this license document and altering is allowed as long
    as you attribute the author(s) of this license document / files.
    ATTRIBUTE ONLY PUBLIC LICENSE
    TERMS AND CONDITIONS FOR COPYING, DISTRIBUTION AND MODIFICATION
      1. Attribute anyone attached to the license document.
         * Do not remove pre-existing attributes.
         Plausible attribution methods:
            1. Through comment blocks.
            2. Referencing on a site, wiki, or about page.
      2. Do whatever you want as long as you don't invalidate 1.
@license AOL v.a3 <http://aol.nexua.org>*/

public class FoundBiome extends JavaPlugin {


    private final PlayerJoinListener joinListener = new PlayerJoinListener(this);
    private final PlayerMoveListener moveListener = new PlayerMoveListener(this);
    private final CommandHandler commandHandler = new CommandHandler(this);
    private final MapHandler mapHandler = new MapHandler(this);


    public void onEnable() {
        PluginManager pm = Bukkit.getServer().getPluginManager();
        pm.registerEvents(joinListener, this);
        pm.registerEvents(moveListener, this);
        getCommand("biome").setExecutor(commandHandler);
    }

    public MapHandler getMapHandler() {
        return mapHandler;
    }

}
