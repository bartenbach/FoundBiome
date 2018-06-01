package net.alureon.foundbiome.util;

import org.apache.commons.text.WordUtils;
import org.bukkit.block.Biome;

public class BiomeFormatter {

    /**
     * A static method to format biome names for printing them out to a user.
     * Will format MUTATED_EXTREME_HILLS to Mutated Extreme Hills.
     * @param b the biome to translate
     * @return the formatted String
     */
    public static String formatBiome(Biome b) {
        return WordUtils.capitalizeFully(b.name().toLowerCase().replaceAll("_", " "));
    }

}
