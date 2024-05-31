package com.stevekung.fishofthieves.entity.condition;

import java.util.function.Predicate;

public interface SpawnCondition extends Predicate<SpawnConditionContext>
{
    SpawnConditionType getType();

    @FunctionalInterface
    interface Builder
    {
        SpawnCondition build();

        default SpawnCondition.Builder invert()
        {
            return InvertedSpawnCondition.invert(this);
        }

        default AnyOfCondition.Builder or(SpawnCondition.Builder condition)
        {
            return AnyOfCondition.anyOf(this, condition);
        }

        default AllOfCondition.Builder and(SpawnCondition.Builder builder)
        {
            return AllOfCondition.allOf(this, builder);
        }
    }
}