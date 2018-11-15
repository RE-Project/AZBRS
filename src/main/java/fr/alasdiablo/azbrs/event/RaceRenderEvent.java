package fr.alasdiablo.azbrs.event;

import fr.alasdiablo.azbrs.race.RaceRenderSystem;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class RaceRenderEvent {

    private RaceRenderSystem raceRenderSystem = new RaceRenderSystem();

    @SideOnly(Side.CLIENT)
    @SubscribeEvent
    public void onPreRenderPlayer(RenderPlayerEvent.Pre event) {
        raceRenderSystem.renderPlayer(event);
    }
}
