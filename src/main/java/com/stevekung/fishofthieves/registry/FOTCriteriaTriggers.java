package com.stevekung.fishofthieves.registry;

import com.stevekung.fishofthieves.trigger.ItemUsedOnBlockWithNearbyEntityTrigger;

import net.fabricmc.fabric.mixin.object.builder.CriteriaAccessor;

public class FOTCriteriaTriggers
{
    public static final ItemUsedOnBlockWithNearbyEntityTrigger ITEM_USED_ON_BLOCK_WITH_NEARBY_ENTITY = new ItemUsedOnBlockWithNearbyEntityTrigger();

    public static void init()
    {
        CriteriaAccessor.callRegister(ITEM_USED_ON_BLOCK_WITH_NEARBY_ENTITY);
    }
}