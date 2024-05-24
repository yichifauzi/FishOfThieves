package com.stevekung.fishofthieves.registry.variant.muha.condition;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.stevekung.fishofthieves.FishOfThieves;
import com.stevekung.fishofthieves.registry.variant.muha.FOTBuiltinRegistries;
import com.stevekung.fishofthieves.registry.variant.muha.FOTRegistries;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.resources.RegistryFileCodec;

public class SpawnConditions
{
    private static final Codec<SpawnCondition> TYPED_CODEC = FOTBuiltinRegistries.SPAWN_CONDITION_TYPE.byNameCodec().dispatch("condition", SpawnCondition::getType, SpawnConditionType::codec);
    public static final Codec<SpawnCondition> DIRECT_CODEC = Codec.lazyInitialized(() -> Codec.withAlternative(TYPED_CODEC, AllOfCondition.INLINE_CODEC));
    public static final Codec<Holder<SpawnCondition>> CODEC = RegistryFileCodec.create(FOTRegistries.SPAWN_CONDITION, DIRECT_CODEC);

    public static final SpawnConditionType INVERTED = register("inverted", InvertedSpawnCondition.CODEC);
    public static final SpawnConditionType ANY_OF = register("any_of", AnyOfCondition.CODEC);
    public static final SpawnConditionType ALL_OF = register("all_of", AllOfCondition.CODEC);

    public static final SpawnConditionType IS_DAY = register("is_day", IsDayCondition.CODEC);
    public static final SpawnConditionType IS_NIGHT = register("is_night", IsNightCondition.CODEC);
    public static final SpawnConditionType IS_RAINING = register("is_raining", IsRainingCondition.CODEC);
    public static final SpawnConditionType SEE_SKY_IN_WATER = register("see_sky_in_water", SeeSkyInWaterCondition.CODEC);
    public static final SpawnConditionType CONTINENTALNESS = register("continentalness", ContinentalnessCondition.CODEC);
    public static final SpawnConditionType PROBABILITY = register("probability", ProbabilityCondition.CODEC);
    public static final SpawnConditionType MATCH_BIOME = register("match_biome", MatchBiomeCondition.CODEC);
    public static final SpawnConditionType MATCH_STRUCTURE = register("match_structure", MatchStructureCondition.CODEC);
    public static final SpawnConditionType MATCH_BLOCKS_IN_RANGE = register("match_blocks_in_range", MatchBlocksInRangeCondition.CODEC);
    public static final SpawnConditionType MATCH_MINIMUM_BLOCKS_IN_RANGE = register("match_minimum_blocks_in_range", MatchMinimumBlocksInRangeCondition.CODEC);
    public static final SpawnConditionType HAS_BEEHIVE = register("has_beehive", HasBeehiveCondition.CODEC);
    public static final SpawnConditionType HEIGHT = register("height", HeightCondition.CODEC);

    public static void init() {}

    private static SpawnConditionType register(String name, MapCodec<? extends SpawnCondition> codec)
    {
        return Registry.register(FOTBuiltinRegistries.SPAWN_CONDITION_TYPE, FishOfThieves.res(name), new SpawnConditionType(codec));
    }
}