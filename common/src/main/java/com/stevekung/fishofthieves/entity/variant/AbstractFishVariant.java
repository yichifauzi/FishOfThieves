package com.stevekung.fishofthieves.entity.variant;

import java.util.Optional;
import java.util.function.Predicate;
import java.util.function.Supplier;

import org.jetbrains.annotations.Nullable;
import com.stevekung.fishofthieves.spawn.SpawnConditionContext;
import net.minecraft.resources.ResourceLocation;

public class AbstractFishVariant
{
    private final Supplier<Predicate<SpawnConditionContext>> condition;
    private final ResourceLocation texture;
    @Nullable
    private final ResourceLocation glowTexture;

    protected AbstractFishVariant(Supplier<Predicate<SpawnConditionContext>> condition, ResourceLocation texture, ResourceLocation glowTexture)
    {
        this.condition = condition;
        this.texture = texture;
        this.glowTexture = glowTexture;
    }

    public Predicate<SpawnConditionContext> getCondition()
    {
        return this.condition.get();
    }

    public ResourceLocation getTexture()
    {
        return this.texture;
    }

    public Optional<ResourceLocation> getGlowTexture()
    {
        return Optional.ofNullable(this.glowTexture);
    }
}