package net.alureon.foundbiome.handler;

import net.alureon.foundbiome.FoundBiome;
import net.alureon.foundbiome.file.FileHandler;
import net.alureon.foundbiome.file.Paths;
import org.bukkit.block.Biome;
import org.bukkit.entity.Player;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class MapHandler {


    private final HashMap<Player,ArrayList<Biome>> playerMap = new HashMap<>();
    private FoundBiome fb;


    public MapHandler(FoundBiome fb) {
        this.fb = fb;
    }

    public void addToMap(Player player) {
        ArrayList<Biome> biomes = new ArrayList<Biome>();
        JSONParser parser = new JSONParser();
        try {
            // get the player's UUID for the stats file
            String uuid = player.getUniqueId().toString();

            // get the player's json stats file
            File worldFolder = fb.getServer().getWorld(FileHandler.worldName).getWorldFolder();
            String statFile = worldFolder.getAbsolutePath() + "\\stats\\" + uuid + ".json";
            Object obj = parser.parse(new FileReader(statFile));
            JSONObject jsonObject = (JSONObject) obj;
            JSONObject biomeObject = (JSONObject) jsonObject.get("achievement.exploreAllBiomes");
            JSONArray biomeArray = (JSONArray) biomeObject.get("progress");

            // parse biome array and translate
            for (Object o : biomeArray) {
                // Bukkit biomes are different from this list because...Logic.
                biomes.add(fb.getBiomeTranslation().translateBiome(o.toString().toLowerCase()));
            }
            playerMap.put(player, biomes);
        } catch (FileNotFoundException ex) {
            fb.getLogger().severe("Could not find a stats file for player!");
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
