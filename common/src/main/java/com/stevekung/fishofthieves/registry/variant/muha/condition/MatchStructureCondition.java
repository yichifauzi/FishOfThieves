package com.stevekung.fishofthieves.registry.variant.muha.condition;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.HolderSet;
import net.minecraft.core.RegistryCodecs;
import net.minecraft.core.registries.Registries;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.levelgen.structure.Structure;

public record MatchStructureCondition(HolderSet<Structure> structures) implements SpawnCondition
{
    public static final MapCodec<MatchStructureCondition> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(RegistryCodecs.homogeneousList(Registries.STRUCTURE).fieldOf("structures").forGetter(MatchStructureCondition::structures)).apply(instance, MatchStructureCondition::new));

    @Override
    public SpawnConditionType getType()
    {
        return SpawnConditions.MATCH_STRUCTURE;
    }

    @Override
    public boolean test(LivingEntity livingEntity)
    {
        return ((ServerLevel) livingEntity.level()).structureManager().getStructureWithPieceAt(livingEntity.blockPosition(), this.structures).isValid();
    }

    public static Builder hasStructure(HolderSet<Structure> structures)
    {
        return () -> new MatchStructureCondition(structures);
    }
}