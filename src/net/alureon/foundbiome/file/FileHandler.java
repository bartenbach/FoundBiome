package net.alureon.foundbiome.file;

import net.alureon.foundbiome.FoundBiome;

public class FileHandler {


    private FoundBiome fb;


    public FileHandler(FoundBiome fb) {
        this.fb = fb;
    }

    public void checkFiles() {
        if (!fb.getDataFolder().exists()) {
            fb.getDataFolder().mkdirs();
        }
        fb.getConfig().options().copyDefaults(true);
        fb.saveDefaultConfig();
    }
}
