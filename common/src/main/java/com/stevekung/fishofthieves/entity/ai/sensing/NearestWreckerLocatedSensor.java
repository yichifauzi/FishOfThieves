package com.stevekung.fishofthieves.entity.ai.sensing;

import java.util.Set;

import com.google.common.collect.ImmutableSet;
import com.stevekung.fishofthieves.entity.animal.Wrecker;
import com.stevekung.fishofthieves.registry.FOTMemoryModuleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.memory.MemoryModuleType;
import net.minecraft.world.entity.ai.sensing.Sensor;

public class NearestWreckerLocatedSensor extends Sensor<LivingEntity>
{
    public NearestWreckerLocatedSensor()
    {
        super(20);
    }

    @Override
    public Set<MemoryModuleType<?>> requires()
    {
        return ImmutableSet.of(FOTMemoryModuleTypes.NEAREST_WRECKER_LOCATED);
    }

    @Override
    protected void doTick(ServerLevel level, LivingEntity entity)
    {
        var wreckagePos = Wrecker.getNearestShipwreckOrRuinedPortalPos(level, entity.blockPosition());

        if (wreckagePos != null)
        {
            var distance = entity.distanceToSqr(wreckagePos.getX(), entity.getY(), wreckagePos.getZ());

            if (distance < 1024)
            {
                entity.getBrain().setMemory(FOTMemoryModuleTypes.NEAREST_WRECKER_LOCATED, wreckagePos);
            }
        }
    }
}