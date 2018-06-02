package net.alureon.foundbiome;


import net.alureon.foundbiome.command.CommandHandler;
import net.alureon.foundbiome.file.FileHandler;
import net.alureon.foundbiome.handler.MapHandler;
import net.alureon.foundbiome.listener.PlayerJoinListener;
import net.alureon.foundbiome.listener.PlayerMoveListener;
import net.alureon.foundbiome.util.JarUtils;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

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
    private final FileHandler fh = new FileHandler(this);


    public void onEnable() {
        loadJar();
        fh.checkFiles();
        PluginManager pm = Bukkit.getServer().getPluginManager();
        pm.registerEvents(joinListener, this);
        pm.registerEvents(moveListener, this);
        getCommand("fb").setExecutor(commandHandler);
    }

    public MapHandler getMapHandler() {
        return mapHandler;
    }

    private void loadJar() {
        try {
            final File[] libs = new File[]{
                    new File(getDataFolder(), "commons-collections4-4.1.jar")
            };
            for (final File lib : libs) {
                if (!lib.exists()) {
                    JarUtils.extractFromJar(lib.getName(), lib.getAbsolutePath());
                }
            }
            for (final File lib : libs) {
                if (!lib.exists()) {
                    getLogger().warning(
                            "There was a critical error loading FoundBiome - Could not find lib: " + lib.getName());
                    Bukkit.getServer().getPluginManager().disablePlugin(this);
                    return;
                }
                addClassPath(JarUtils.getJarUrl(lib));
            }
        } catch (final Exception e) {
            this.getServer().getLogger().severe("Failed to load libs!");
            e.printStackTrace();
        }
    }

    private void addClassPath(final URL url) throws IOException {
        final URLClassLoader sysloader = (URLClassLoader) ClassLoader.getSystemClassLoader();
        final Class<URLClassLoader> sysclass = URLClassLoader.class;
        try {
            final Method method = sysclass.getDeclaredMethod("addURL", new Class[]{URL.class});
            method.setAccessible(true);
            method.invoke(sysloader, new Object[]{url});
        } catch (final Throwable t) {
            t.printStackTrace();
            throw new IOException("Error adding " + url + " to system classloader");
        }
    }

    public FileHandler getFileHandler() {
        return this.fh;
    }

}
