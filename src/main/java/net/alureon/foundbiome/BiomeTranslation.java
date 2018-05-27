package net.alureon.foundbiome;

import org.apache.commons.collections4.bidimap.DualHashBidiMap;
import org.bukkit.block.Biome;


public class BiomeTranslation {


    private DualHashBidiMap<String, Biome> biomeMap = new DualHashBidiMap<>();


    public BiomeTranslation() {
        biomeMap.put("ocean", Biome.OCEAN);
        biomeMap.put("plains", Biome.PLAINS);
        biomeMap.put("desert", Biome.DESERT);
        biomeMap.put("extreme_hills", Biome.EXTREME_HILLS);
        biomeMap.put("forest", Biome.FOREST);
        biomeMap.put("taiga", Biome.TAIGA);
        biomeMap.put("swampland", Biome.SWAMPLAND);
        biomeMap.put("river", Biome.RIVER);
        biomeMap.put("hell", Biome.HELL);
        biomeMap.put("the_end", Biome.SKY);
        biomeMap.put("frozenocean", Biome.FROZEN_OCEAN);
        biomeMap.put("frozenriver", Biome.FROZEN_RIVER);
        biomeMap.put("ice_plains", Biome.ICE_FLATS);
        biomeMap.put("ice_mountains", Biome.ICE_MOUNTAINS);
        biomeMap.put("mushroomisland", Biome.MUSHROOM_ISLAND);
        biomeMap.put("mushroomislandshore", Biome.MUSHROOM_ISLAND_SHORE);
        biomeMap.put("beach", Biome.BEACHES);
        biomeMap.put("deserthills", Biome.DESERT_HILLS);
        biomeMap.put("forest_hills", Biome.FOREST_HILLS);
        biomeMap.put("taigahills", Biome.TAIGA_HILLS);
        biomeMap.put("extreme_hills_edge", Biome.SMALLER_EXTREME_HILLS);
        biomeMap.put("jungle", Biome.JUNGLE);
        biomeMap.put("junglehills", Biome.JUNGLE_HILLS);
        biomeMap.put("jungleedge", Biome.JUNGLE_EDGE);
        biomeMap.put("deep_ocean", Biome.DEEP_OCEAN);
        biomeMap.put("stone_beach", Biome.STONE_BEACH);
        biomeMap.put("cold_beach", Biome.COLD_BEACH);
        biomeMap.put("birch_forest", Biome.BIRCH_FOREST);
        biomeMap.put("birch_forest_hills", Biome.BIRCH_FOREST_HILLS);
        biomeMap.put("roofed_forest", Biome.ROOFED_FOREST);
        biomeMap.put("cold_taiga", Biome.TAIGA_COLD);
        biomeMap.put("cold_taiga_hills", Biome.TAIGA_COLD_HILLS);
        biomeMap.put("mega_taiga", Biome.REDWOOD_TAIGA);
        biomeMap.put("mega_taiga_hills", Biome.REDWOOD_TAIGA_HILLS);
        biomeMap.put("extreme_hills+", Biome.EXTREME_HILLS_WITH_TREES);
        biomeMap.put("savanna", Biome.SAVANNA);
        biomeMap.put("savanna_plateau", Biome.SAVANNA_ROCK);
        biomeMap.put("mesa", Biome.MESA);
        biomeMap.put("mesa_plateau_f", Biome.MESA_ROCK);
        biomeMap.put("mesa_plateau", Biome.MESA_CLEAR_ROCK);
        biomeMap.put("the_void", Biome.VOID);
        biomeMap.put("sunflower_plains", Biome.MUTATED_PLAINS);
        biomeMap.put("desert_m", Biome.MUTATED_DESERT);
        biomeMap.put("extreme_hills_m", Biome.MUTATED_EXTREME_HILLS);
        biomeMap.put("flower_forest", Biome.MUTATED_FOREST);
        biomeMap.put("taiga_m", Biome.MUTATED_TAIGA);
        biomeMap.put("swampland_m", Biome.MUTATED_SWAMPLAND);
        biomeMap.put("ice_plains_spikes", Biome.MUTATED_ICE_FLATS);
        biomeMap.put("jungle_m", Biome.MUTATED_JUNGLE);
        biomeMap.put("jungleedge_m", Biome.MUTATED_JUNGLE_EDGE);
        biomeMap.put("birch_forest_m", Biome.MUTATED_BIRCH_FOREST);
        biomeMap.put("birch_forest_hills_m", Biome.MUTATED_BIRCH_FOREST_HILLS);
        biomeMap.put("roofed_forest_m", Biome.MUTATED_ROOFED_FOREST);
        biomeMap.put("cold_taiga_m", Biome.MUTATED_TAIGA_COLD);
        biomeMap.put("mega_spruce_taiga", Biome.MUTATED_REDWOOD_TAIGA);
        biomeMap.put("redwood_taiga_hills_m", Biome.MUTATED_REDWOOD_TAIGA_HILLS);
        biomeMap.put("extreme_hills+_m", Biome.MUTATED_EXTREME_HILLS_WITH_TREES);
        biomeMap.put("savanna_m", Biome.MUTATED_SAVANNA);
        biomeMap.put("savanna_plateau_m", Biome.MUTATED_SAVANNA_ROCK);
        biomeMap.put("mesa_(bryce)", Biome.MUTATED_MESA);
        biomeMap.put("mesa_plateau_f_m", Biome.MUTATED_MESA_ROCK);
        biomeMap.put("mesa_plateau_m", Biome.MUTATED_MESA_CLEAR_ROCK);
    }


    public Biome translateBiome(String name) {
        return biomeMap.get(name);
    }

    public String translateBiome(Biome biome) {
        return biomeMap.getKey(biome);
    }

    public DualHashBidiMap getBiomeMap() {
        return biomeMap;
    }
}
