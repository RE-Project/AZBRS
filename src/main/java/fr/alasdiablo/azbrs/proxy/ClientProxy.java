package fr.alasdiablo.azbrs.proxy;

import fr.alasdiablo.azbrs.event.RaceRenderEvent;
import fr.alasdiablo.azbrs.race.RaceRenderHandler;
import net.minecraftforge.common.MinecraftForge;

public class ClientProxy implements IProxy {

    @Override
    public void preInit() {
    }

    @Override
    public void init() {
        //MinecraftForge.EVENT_BUS.register(new RaceRenderHandler());
        MinecraftForge.EVENT_BUS.register(new RaceRenderEvent());
    }
}
