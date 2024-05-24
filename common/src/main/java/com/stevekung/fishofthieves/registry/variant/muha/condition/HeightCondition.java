package com.stevekung.fishofthieves.registry.variant.muha.condition;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.world.entity.LivingEntity;

public record HeightCondition(int min, int max) implements SpawnCondition
{
    //@formatter:off
    public static final MapCodec<HeightCondition> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(
            Codec.INT.fieldOf("min").forGetter(HeightCondition::min),
            Codec.INT.fieldOf("max").forGetter(HeightCondition::max)
    ).apply(instance, HeightCondition::new));
    //@formatter:on

    @Override
    public SpawnConditionType getType()
    {
        return SpawnConditions.HEIGHT;
    }

    @Override
    public boolean test(LivingEntity livingEntity)
    {
        return livingEntity.blockPosition().getY() >= this.min && livingEntity.blockPosition().getY() <= this.max;
    }

    public static HeightCondition.Builder checkHeight(int min, int max)
    {
        return () -> new HeightCondition(min, max);
    }
}