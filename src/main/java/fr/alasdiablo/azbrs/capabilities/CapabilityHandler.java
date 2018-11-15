package fr.alasdiablo.azbrs.capabilities;

import fr.alasdiablo.azbrs.Azbrs;
import fr.alasdiablo.azbrs.data.Reference;
import fr.alasdiablo.azbrs.network.PacketHandler;
import fr.alasdiablo.azbrs.network.PacketSendRace;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class CapabilityHandler {

    public static final ResourceLocation RACE_CAPABILITY = new ResourceLocation(Reference.MOD_ID, "raceid");
    public static final ResourceLocation GENDER_CAPABILITY = new ResourceLocation(Reference.MOD_ID, "gender");

    @SubscribeEvent
    public void attachCapability(AttachCapabilitiesEvent<Entity> event) {

        if (!(event.getObject() instanceof EntityPlayer)) return;

        event.addCapability(RACE_CAPABILITY, new RaceProvider());
        event.addCapability(GENDER_CAPABILITY, new GenderProvider());
    }

    @SubscribeEvent
    public void onPlayerLogin(net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent event) {
        IGender gender = event.player.getCapability(GenderProvider.GENDER_CAPABILITY, null);
        IRace race = event.player.getCapability(RaceProvider.RACE_CAPABILITY, null);
        event.player.sendMessage(new TextComponentString("your race id is :" + race.getRace() + "\nyour gender type is :" + gender.getGender()));
    }
    @SubscribeEvent
    @SideOnly(Side.SERVER)
    public void onPlayerLoginClient(net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent event) {
        PacketHandler.INSTANCE.sendTo(new PacketSendRace(event.player.getCapability(RaceProvider.RACE_CAPABILITY, null).getRace()), (EntityPlayerMP) event.player);
        event.player.sendMessage(new TextComponentString("wow tu viens de resevoir des donnée"));
        System.out.println("[AZBRS/Debuger]" + "wow tu viens de resevoir des donnée");
        Azbrs.logger.info("[AZBRS/Debuger]" + "wow tu viens de resevoir des donnée");
    }

    @SubscribeEvent
    public void onPlayerClone(PlayerEvent.Clone event) {
        EntityPlayer player = event.getEntityPlayer();
        this.cloneRaceId(event, player);
        this.cloneGender(event, player);
    }

    private void cloneGender(PlayerEvent.Clone event, EntityPlayer player) {
        IGender gender = player.getCapability(GenderProvider.GENDER_CAPABILITY, null);
        IGender oldGender = event.getOriginal().getCapability(GenderProvider.GENDER_CAPABILITY, null);
        gender.setGender(oldGender.getGender());
    }

    private void cloneRaceId(PlayerEvent.Clone event, EntityPlayer player) {
        IRace race = player.getCapability(RaceProvider.RACE_CAPABILITY, null);
        IRace oldRace = event.getOriginal().getCapability(RaceProvider.RACE_CAPABILITY, null);
        race.setRace(oldRace.getRace());
    }
}
