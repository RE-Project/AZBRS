package fr.alasdiablo.azbrs.event;

import fr.alasdiablo.azbrs.Azbrs;
import fr.alasdiablo.azbrs.capabilities.RaceProvider;
import fr.alasdiablo.azbrs.network.PacketHandler;
import fr.alasdiablo.azbrs.network.PacketSendRace;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;

public class RaceRenderEventMP {

    @SubscribeEvent
    public void onPreRenderPlayer(PlayerEvent.PlayerLoggedInEvent event) {
        PacketHandler.INSTANCE.sendTo(new PacketSendRace(event.player.getCapability(RaceProvider.RACE_CAPABILITY, null).getRace()), (EntityPlayerMP) event.player);
        event.player.sendMessage(new TextComponentString("wow tu viens de resevoir des donnée"));
        System.out.println("[AZBRS/Debuger]" + "wow tu viens de resevoir des donnée");
        Azbrs.logger.info("[AZBRS/Debuger]" + "wow tu viens de resevoir des donnée");
    }
}
