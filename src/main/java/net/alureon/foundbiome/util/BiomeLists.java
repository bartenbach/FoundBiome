package net.alureon.foundbiome.util;

import org.bukkit.block.Biome;

import java.util.Arrays;
import java.util.List;

public class BiomeLists {

    /**
     * These biomes should never be used for anything.  They don't count towards the achievement, and there is
     * no reason to ever announce them.
     */
    private static final List<Biome> completelyDisabledBiomes = Arrays.asList(Biome.SKY, Biome.VOID, Biome.HELL);

    /**
     * Gets the list of disabled biomes.
     * @return the list of disabled biomes.
     */
    public static List<Biome> getDisabledBiomes() {
        return completelyDisabledBiomes;
    }

    /**
     * Gets the list of non-achievement biomes.
     * @return the list of non-achievement biomes.
     */
    public static boolean isNonAchievementBiome(Biome b) {
        return b.name().startsWith("MUTATED");
    }
}
