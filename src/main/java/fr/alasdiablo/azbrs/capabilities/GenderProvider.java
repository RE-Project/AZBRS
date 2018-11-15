package fr.alasdiablo.azbrs.capabilities;

import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class GenderProvider implements ICapabilitySerializable<NBTBase> {

    @CapabilityInject(IGender.class)
    public static final Capability<IGender> GENDER_CAPABILITY = null;

    private IGender instance = GENDER_CAPABILITY.getDefaultInstance();

    @Override
    public boolean hasCapability(@Nonnull Capability<?> capability, @Nullable EnumFacing facing) {
        return capability == GENDER_CAPABILITY;
    }

    @Nullable
    @Override
    public <T> T getCapability(@Nonnull Capability<T> capability, @Nullable EnumFacing facing) {
        return capability == GENDER_CAPABILITY ? GENDER_CAPABILITY.<T> cast(this.instance) : null;
    }

    @Override
    public NBTBase serializeNBT() {
        return GENDER_CAPABILITY.getStorage().writeNBT(GENDER_CAPABILITY, this.instance, null);
    }

    @Override
    public void deserializeNBT(NBTBase nbt) {
        GENDER_CAPABILITY.getStorage().readNBT(GENDER_CAPABILITY, this.instance, null, nbt);
    }
}
