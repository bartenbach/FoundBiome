package net.alureon.foundbiome;

import org.apache.commons.collections4.bidimap.DualHashBidiMap;
import org.bukkit.block.Biome;


public class BiomeTranslation {


    private DualHashBidiMap<String, Biome> biomeMap = new DualHashBidiMap<>();


    public BiomeTranslation() {
        biomeMap.put("ocean", Biome.OCEAN);
        biomeMap.put("plains", Biome.PLAINS);
        biomeMap.put("desert", Biome.DESERT);
        biomeMap.put("extreme hills", Biome.EXTREME_HILLS);
        biomeMap.put("forest", Biome.FOREST);
        biomeMap.put("taiga", Biome.TAIGA);
        biomeMap.put("swampland", Biome.SWAMPLAND);
        biomeMap.put("river", Biome.RIVER);
        biomeMap.put("hell", Biome.HELL);
        biomeMap.put("the end", Biome.SKY);
        biomeMap.put("frozenocean", Biome.FROZEN_OCEAN);
        biomeMap.put("frozenriver", Biome.FROZEN_RIVER);
        biomeMap.put("ice plains", Biome.ICE_FLATS);
        biomeMap.put("ice mountains", Biome.ICE_MOUNTAINS);
        biomeMap.put("mushroomisland", Biome.MUSHROOM_ISLAND);
        biomeMap.put("mushroomislandshore", Biome.MUSHROOM_ISLAND_SHORE);
        biomeMap.put("beach", Biome.BEACHES);
        biomeMap.put("deserthills", Biome.DESERT_HILLS);
        biomeMap.put("foresthills", Biome.FOREST_HILLS);
        biomeMap.put("taigahills", Biome.TAIGA_HILLS);
        biomeMap.put("extreme hills edge", Biome.SMALLER_EXTREME_HILLS);
        biomeMap.put("jungle", Biome.JUNGLE);
        biomeMap.put("junglehills", Biome.JUNGLE_HILLS);
        biomeMap.put("jungleedge", Biome.JUNGLE_EDGE);
        biomeMap.put("deep ocean", Biome.DEEP_OCEAN);
        biomeMap.put("stone beach", Biome.STONE_BEACH);
        biomeMap.put("cold beach", Biome.COLD_BEACH);
        biomeMap.put("birch forest", Biome.BIRCH_FOREST);
        biomeMap.put("birch forest hills", Biome.BIRCH_FOREST_HILLS);
        biomeMap.put("roofed forest", Biome.ROOFED_FOREST);
        biomeMap.put("cold taiga", Biome.TAIGA_COLD);
        biomeMap.put("cold taiga hills", Biome.TAIGA_COLD_HILLS);
        biomeMap.put("mega taiga", Biome.REDWOOD_TAIGA);
        biomeMap.put("mega taiga hills", Biome.REDWOOD_TAIGA_HILLS);
        biomeMap.put("extreme hills+", Biome.EXTREME_HILLS_WITH_TREES);
        biomeMap.put("savanna", Biome.SAVANNA);
        biomeMap.put("savanna plateau", Biome.SAVANNA_ROCK);
        biomeMap.put("mesa", Biome.MESA);
        biomeMap.put("mesa plateau f", Biome.MESA_ROCK);
        biomeMap.put("mesa plateau", Biome.MESA_CLEAR_ROCK);
        biomeMap.put("the void", Biome.VOID);
        biomeMap.put("sunflower plains", Biome.MUTATED_PLAINS);
        biomeMap.put("desert m", Biome.MUTATED_DESERT);
        biomeMap.put("extreme hills m", Biome.MUTATED_EXTREME_HILLS);
        biomeMap.put("flower forest", Biome.MUTATED_FOREST);
        biomeMap.put("taiga m", Biome.MUTATED_TAIGA);
        biomeMap.put("swampland m", Biome.MUTATED_SWAMPLAND);
        biomeMap.put("ice plains spikes", Biome.MUTATED_ICE_FLATS);
        biomeMap.put("jungle m", Biome.MUTATED_JUNGLE);
        biomeMap.put("jungleedge m", Biome.MUTATED_JUNGLE_EDGE);
        biomeMap.put("birch forest m", Biome.MUTATED_BIRCH_FOREST);
        biomeMap.put("birch forest hills m", Biome.MUTATED_BIRCH_FOREST_HILLS);
        biomeMap.put("roofed forest m", Biome.MUTATED_ROOFED_FOREST);
        biomeMap.put("cold taiga m", Biome.MUTATED_TAIGA_COLD);
        biomeMap.put("mega spruce taiga", Biome.MUTATED_REDWOOD_TAIGA);
        biomeMap.put("redwood taiga hills m", Biome.MUTATED_REDWOOD_TAIGA_HILLS);
        biomeMap.put("extreme hills+ m", Biome.MUTATED_EXTREME_HILLS_WITH_TREES);
        biomeMap.put("savanna m", Biome.MUTATED_SAVANNA);
        biomeMap.put("savanna plateau m", Biome.MUTATED_SAVANNA_ROCK);
        biomeMap.put("mesa (bryce)", Biome.MUTATED_MESA);
        biomeMap.put("mesa plateau f m", Biome.MUTATED_MESA_ROCK);
        biomeMap.put("mesa plateau m", Biome.MUTATED_MESA_CLEAR_ROCK);
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
