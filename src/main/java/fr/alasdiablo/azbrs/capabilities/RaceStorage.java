package fr.alasdiablo.azbrs.capabilities;

import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagInt;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability.IStorage;
import net.minecraftforge.common.capabilities.Capability;

public class RaceStorage implements IStorage<IRace> {

    @Override
    public NBTBase writeNBT(Capability<IRace> capability, IRace instance, EnumFacing side) {
        return new NBTTagInt(instance.getRace());
    }

    @Override
    public void readNBT(Capability<IRace> capability, IRace instance, EnumFacing side, NBTBase nbt) {
        instance.setRace(((NBTTagInt) nbt).getInt());
    }
}
