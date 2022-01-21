package com.stevekung.fishofthieves.utils;

import java.util.Objects;
import java.util.Optional;
import java.util.function.Predicate;

import net.minecraft.core.BlockPos;
import net.minecraft.core.QuartPos;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Climate;
import net.minecraft.world.level.biome.OverworldBiomeBuilder;
import net.minecraft.world.level.biome.TerrainShaper;
import net.minecraft.world.level.levelgen.feature.StructureFeature;

public class TerrainUtils
{
    public static Continentalness getContinentalness(ServerLevel level, BlockPos blockPos)
    {
        var continentalness = Climate.unquantizeCoord(TerrainUtils.getTargetPoint(level, blockPos).continentalness());
        var overworldBiomeBuilder = new OverworldBiomeBuilder();
        return Continentalness.byName(overworldBiomeBuilder.getDebugStringForContinentalness(continentalness));
    }

    public static PeakTypes getPeakTypes(ServerLevel level, BlockPos blockPos)
    {
        var weirdness = Climate.unquantizeCoord(TerrainUtils.getTargetPoint(level, blockPos).weirdness());
        var peakTypes = TerrainShaper.peaksAndValleys(weirdness);
        return PeakTypes.byName(OverworldBiomeBuilder.getDebugStringForPeaksAndValleys(peakTypes));
    }

    public static boolean isInBiome(ServerLevel level, BlockPos blockPos, ResourceKey<Biome> biomeKey)
    {
        return Objects.equals(level.getBiomeName(blockPos), Optional.of(biomeKey));
    }

    public static boolean isInFeature(ServerLevel level, BlockPos blockPos, StructureFeature<?> structureFeature)
    {
        return level.structureFeatureManager().getStructureWithPieceAt(blockPos, structureFeature).isValid();
    }

    public static Biome.BiomeCategory getBiomeCategory(ServerLevel level, BlockPos blockPos)
    {
        return level.getBiome(blockPos).getBiomeCategory();
    }

    public static Optional<BlockPos> lookForBlock(BlockPos blockPos, int range, Predicate<BlockPos> posFilter)
    {
        return BlockPos.findClosestMatch(blockPos, range, range, posFilter);
    }

    public static boolean lookForBlocksWithSize(BlockPos blockPos, int range, int maxSize, Predicate<BlockPos> posFilter)
    {
        var size = 0;

        for (var blockPos2 : BlockPos.withinManhattan(blockPos, range, range, range))
        {
            if (!posFilter.test(blockPos2))
            {
                continue;
            }
            if (++size >= maxSize)
            {
                return true;
            }
        }
        return false;
    }

    private static Climate.TargetPoint getTargetPoint(ServerLevel level, BlockPos blockPos)
    {
        var chunkX = QuartPos.fromBlock(blockPos.getX());
        var chunkY = QuartPos.fromBlock(blockPos.getY());
        var chunkZ = QuartPos.fromBlock(blockPos.getZ());
        return level.getChunkSource().getGenerator().climateSampler().sample(chunkX, chunkY, chunkZ);
    }
}