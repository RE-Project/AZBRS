package fr.alasdiablo.azbrs.proxy;

import fr.alasdiablo.azbrs.event.RaceRenderEventMP;
import net.minecraftforge.common.MinecraftForge;

public class ServerProxy implements IProxy {

    @Override
    public void preInit() {
        MinecraftForge.EVENT_BUS.register(new RaceRenderEventMP());
    }

    @Override
    public void init() {
    }
}
