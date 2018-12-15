package net.alureon.foundbiome.util;

import org.bukkit.block.Biome;

import java.util.Arrays;
import java.util.List;

public class BiomeLists {

    /**
     * These biomes should never be used for anything.  They don't count towards the achievement, and there is
     * no reason to ever announce them.
     */
    private static final List<Biome> completelyDisabledBiomes = Arrays.asList(Biome.THE_VOID, Biome.MOUNTAIN_EDGE, Biome.DEEP_WARM_OCEAN);

    /**
     * Gets the list of disabled biomes.
     * @return the list of disabled biomes.
     */
    public static List<Biome> getDisabledBiomes() {
        return completelyDisabledBiomes;
    }

    /**
     * Checks if the biome is needed for the achievement.
     * @return true if the biome DOES NOT contribute to the vanilla achievement.
     */
    public static boolean isNonAchievementBiome(Biome b) {
    	switch(b) {
		case BADLANDS:
			return false;
		case BADLANDS_PLATEAU:
			return false;
		case BEACH:
			return false;
		case BIRCH_FOREST:
			return false;
		case BIRCH_FOREST_HILLS:
			return false;
		case COLD_OCEAN:
			return false;
		case DARK_FOREST:
			return false;
		case DARK_FOREST_HILLS:
			return true;
		case DEEP_COLD_OCEAN:
			return false;
		case DEEP_FROZEN_OCEAN:
			return false;
		case DEEP_LUKEWARM_OCEAN:
			return false;
		case DEEP_OCEAN:
			return true;
		case DEEP_WARM_OCEAN:
			return true;
		case DESERT:
			return false;
		case DESERT_HILLS:
			return false;
		case DESERT_LAKES:
			return true;
		case END_BARRENS:
			return true;
		case END_HIGHLANDS:
			return true;
		case END_MIDLANDS:
			return true;
		case ERODED_BADLANDS:
			return true;
		case FLOWER_FOREST:
			return true;
		case FOREST:
			return false;
		case FROZEN_OCEAN:
			return true;
		case FROZEN_RIVER:
			return false;
		case GIANT_SPRUCE_TAIGA:
			return true;
		case GIANT_SPRUCE_TAIGA_HILLS:
			return true;
		case GIANT_TREE_TAIGA:
			return false;
		case GIANT_TREE_TAIGA_HILLS:
			return false;
		case GRAVELLY_MOUNTAINS:
			return true;
		case ICE_SPIKES:
			return true;
		case JUNGLE:
			return false;
		case JUNGLE_EDGE:
			return false;
		case JUNGLE_HILLS:
			return false;
		case LUKEWARM_OCEAN:
			return false;
		case MODIFIED_BADLANDS_PLATEAU:
			return true;
		case MODIFIED_GRAVELLY_MOUNTAINS:
			return true;
		case MODIFIED_JUNGLE:
			return true;
		case MODIFIED_JUNGLE_EDGE:
			return true;
		case MODIFIED_WOODED_BADLANDS_PLATEAU:
			return true;
		case MOUNTAINS:
			return false;
		case MOUNTAIN_EDGE:
			return true;
		case MUSHROOM_FIELDS:
			return false;
		case MUSHROOM_FIELD_SHORE:
			return false;
		case NETHER:
			return true;
		case OCEAN:
			return true;
		case PLAINS:
			return false;
		case RIVER:
			return false;
		case SAVANNA:
			return false;
		case SAVANNA_PLATEAU:
			return false;
		case SHATTERED_SAVANNA:
			return true;
		case SHATTERED_SAVANNA_PLATEAU:
			return true;
		case SMALL_END_ISLANDS:
			return true;
		case SNOWY_BEACH:
			return false;
		case SNOWY_MOUNTAINS:
			return false;
		case SNOWY_TAIGA:
			return false;
		case SNOWY_TAIGA_HILLS:
			return false;
		case SNOWY_TAIGA_MOUNTAINS:
			return true;
		case SNOWY_TUNDRA:
			return false;
		case STONE_SHORE:
			return false;
		case SUNFLOWER_PLAINS:
			return true;
		case SWAMP:
			return false;
		case SWAMP_HILLS:
			return true;
		case TAIGA:
			return false;
		case TAIGA_HILLS:
			return false;
		case TAIGA_MOUNTAINS:
			return true;
		case TALL_BIRCH_FOREST:
			return true;
		case TALL_BIRCH_HILLS:
			return true;
		case THE_END:
			return true;
		case THE_VOID:
			return true;
		case WARM_OCEAN:
			return false;
		case WOODED_BADLANDS_PLATEAU:
			return false;
		case WOODED_HILLS:
			return false;
		case WOODED_MOUNTAINS:
			return false;
		default:
			return true;
    	}
    }
}
