package fr.alasdiablo.azbrs.capabilities;

import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagInt;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.Capability.IStorage;

public class GenderStorage implements IStorage<IGender> {

    @Override
    public NBTBase writeNBT(Capability<IGender> capability, IGender instance, EnumFacing side) {
        return new NBTTagInt(instance.getGender());
    }

    @Override
    public void readNBT(Capability<IGender> capability, IGender instance, EnumFacing side, NBTBase nbt) {
        instance.setGender(((NBTTagInt) nbt).getInt());
    }
}
