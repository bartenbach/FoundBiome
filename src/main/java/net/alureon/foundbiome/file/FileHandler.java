package net.alureon.foundbiome.file;

import net.alureon.foundbiome.FoundBiome;

public class FileHandler {


    private FoundBiome fb;
    private String worldName;
    private boolean broadcast;


    public FileHandler(FoundBiome fb) {
        this.fb = fb;
    }

    public void checkFiles() {
        if (!fb.getDataFolder().exists()) {
            boolean dirsMade = fb.getDataFolder().mkdirs();
            if (!dirsMade) {
                fb.getServer().getLogger().severe("Failed to make plugin directory!");
                fb.getServer().getLogger().severe("This will probably not work correctly.");
            }
        }
        fb.getConfig().options().copyDefaults(true);
        fb.saveConfig();

        this.worldName = fb.getConfig().getString(Paths.worldName);
        this.broadcast = fb.getConfig().getBoolean(Paths.broadcast);
    }

    public String getWorldName() {
        return this.worldName;
    }

    public boolean getBroadcast() {
        return this.broadcast;
    }
}
