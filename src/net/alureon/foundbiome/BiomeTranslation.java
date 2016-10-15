package net.alureon.foundbiome;

import org.bukkit.block.Biome;


public class BiomeTranslation {


    public static Biome translateBiome(String name) {
        switch (name) {


            /* Forest Biomes */
            case "BIRCH_FOREST_HILLS_M":
                return Biome.MUTATED_BIRCH_FOREST_HILLS;
            case "ROOFED_FOREST_M":
                return Biome.MUTATED_ROOFED_FOREST;
            case "FORESTHILLS":
                return Biome.FOREST_HILLS;
            case "FLOWER_FOREST":
                return Biome.MUTATED_FOREST;


            /* Plains Biomes */
            case "SUNFLOWER_PLAINS":
                return Biome.MUTATED_PLAINS;


            /* Desert Biomes */
            case "DESERT_M":
                return Biome.MUTATED_DESERT;
            case "DESERTHILLS":
                return Biome.DESERT_HILLS;


            /* Taiga Biomes */
            case "COLD_TAIGA":
                return Biome.TAIGA_COLD;
            case "MEGA_TAIGA":
                return Biome.REDWOOD_TAIGA;
            case "MEGA_TAIGA_HILLS":
                return Biome.REDWOOD_TAIGA_HILLS;
            case "MEGA_SPRUCE_TAIGA":
                return Biome.MUTATED_REDWOOD_TAIGA;
            case "TAIGA_M":
                return Biome.MUTATED_TAIGA;
            case "TAIGAHILLS":
                return Biome.TAIGA_HILLS;


            /* Jungle Biomes */
            case "JUNGLEHILLS":
                return Biome.JUNGLE_HILLS;
            case "JUNGLEEDGE":
                return Biome.JUNGLE_EDGE;
            case "JUNGLE_M":
                return Biome.MUTATED_JUNGLE;


            /* Mesa Biomes */
            case "MESA_PLATEAU_F":
                return Biome.MESA_ROCK;
            case "MESA_PLATEAU":
                return Biome.MESA_CLEAR_ROCK;
            case "MESA_(BRYCE)":
                return Biome.MUTATED_MESA;
            case "MESA_PLATEAU_F_M":
                return Biome.MUTATED_MESA_ROCK;
            case "MESA_PLATEAU_M":
                return Biome.MUTATED_MESA_CLEAR_ROCK;


            /* Extreme Hills Biomes */
            case "EXTREME_HILLS+":
                return Biome.EXTREME_HILLS_WITH_TREES;
            case "EXTREME_HILLS+_M":
                return Biome.MUTATED_EXTREME_HILLS_WITH_TREES;
            case "EXTREME_HILLS_EDGE":
                return Biome.SMALLER_EXTREME_HILLS;
            case "EXTREME_HILLS_M":
                return Biome.MUTATED_EXTREME_HILLS;


            /* Snow Biomes */
            case "ICE_PLAINS_SPIKES":
                return Biome.MUTATED_ICE_FLATS;
            case "ICE_PLAINS":
                return Biome.ICE_FLATS;
            case "FROZENRIVER":
                return Biome.FROZEN_RIVER;


            /* Savanna Biomes */
            case "SAVANNA_PLATEAU_M":
                return Biome.MUTATED_SAVANNA_ROCK;
            case "SAVANNA_PLATEAU":
                return Biome.SAVANNA_ROCK;
            case "SAVANNA_M":
                return Biome.MUTATED_SAVANNA;


            /* Mushroom Biomes */
            case "MUSHROOMISLAND":
                return Biome.MUSHROOM_ISLAND;
            case "MUSHROOMISLANDSHORE":
                return Biome.MUSHROOM_ISLAND_SHORE;


            /* Miscellaneous Biomes */
            case "THE_END":
                return Biome.VOID;
            case "BEACH":
                return Biome.BEACHES;


            default:
                return Biome.valueOf(name);
        }
    }
}
