package fr.alasdiablo.azbrs.capabilities;

import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class RaceProvider implements ICapabilitySerializable<NBTBase> {

    @CapabilityInject(IRace.class)
    public static final Capability<IRace> RACE_CAPABILITY = null;

    private IRace instance = RACE_CAPABILITY.getDefaultInstance();

    @Override
    public boolean hasCapability(@Nonnull Capability<?> capability, @Nullable EnumFacing facing) {
        return capability == RACE_CAPABILITY;
    }

    @Nullable
    @Override
    public <T> T getCapability(@Nonnull Capability<T> capability, @Nullable EnumFacing facing) {
        return capability == RACE_CAPABILITY ? RACE_CAPABILITY.<T> cast(this.instance) : null;
    }

    @Override
    public NBTBase serializeNBT() {
        return RACE_CAPABILITY.getStorage().writeNBT(RACE_CAPABILITY, this.instance, null);
    }

    @Override
    public void deserializeNBT(NBTBase nbt) {
        RACE_CAPABILITY.getStorage().readNBT(RACE_CAPABILITY, this.instance, null, nbt);
    }
}
