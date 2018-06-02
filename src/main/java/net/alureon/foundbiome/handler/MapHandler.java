package net.alureon.foundbiome.handler;

import net.alureon.foundbiome.FoundBiome;
import org.bukkit.block.Biome;
import org.bukkit.entity.Player;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;

public class MapHandler {


    private final HashMap<Player,ArrayList<Biome>> playerMap = new HashMap<>();
    private FoundBiome fb;


    public MapHandler(FoundBiome fb) {
        this.fb = fb;
    }

    public void addToMap(Player player) {
        ArrayList<Biome> biomes = new ArrayList<>(Biome.values().length); // init arraylist to max size
        JSONParser parser = new JSONParser();
        try {
            // get the player's UUID for the stats file
            String uuid = player.getUniqueId().toString();

            // get the player's json stats file
            File worldFolder = fb.getServer().getWorld(fb.getFileHandler().getWorldName()).getWorldFolder();
            Path worldFolderPath = worldFolder.toPath();
            Path statsFile = worldFolderPath.resolve("advancements").resolve(uuid + ".json");

            if (!statsFile.toFile().exists()) {
                System.out.println("Unable to find stats file for player: " + player.getName());
                System.out.println("Path: " + statsFile.toString());
            }

            Object obj = parser.parse(new FileReader(statsFile.toFile()));
            JSONObject jsonObject = (JSONObject) obj;
            JSONObject achievementObject = (JSONObject) jsonObject.get("minecraft:adventure/adventuring_time");
            JSONObject criteriaObject = (JSONObject) achievementObject.get("criteria");

            // parse biome array and translate
            for (Object o : criteriaObject.keySet()) {
                biomes.add(Biome.valueOf(o.toString().toUpperCase()));
            }
            playerMap.put(player, biomes);
        } catch (FileNotFoundException ex) {
            fb.getLogger().severe("Could not find a stats file for player! (maybe they don't have one? creating new map for them)");
            playerMap.put(player, biomes);
        } catch (ParseException ex) {
            fb.getLogger().severe("Failed to parse player json file!");
            ex.printStackTrace();
        } catch (IOException ex) {
            fb.getLogger().severe("IOException encountered trying to parse file!");
            ex.printStackTrace();
        }
    }

    public ArrayList<Biome> getPlayerBiomeList(Player player) {
        return playerMap.get(player);
    }
}
