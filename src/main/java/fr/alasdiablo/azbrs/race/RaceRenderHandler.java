package fr.alasdiablo.azbrs.race;

import fr.alasdiablo.azbrs.Azbrs;
import fr.alasdiablo.azbrs.capabilities.GenderProvider;
import fr.alasdiablo.azbrs.capabilities.IGender;
import fr.alasdiablo.azbrs.capabilities.IRace;
import fr.alasdiablo.azbrs.capabilities.RaceProvider;
import fr.alasdiablo.azbrs.data.Reference;
import fr.alasdiablo.azbrs.race.cyborg.ModelCyborgFemale;
import fr.alasdiablo.azbrs.race.cyborg.ModelCyborgMale;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class RaceRenderHandler {

    RenderLivingBase cyborgMaleRender; // = new RenderCyborgMale(Minecraft.getMinecraft().getRenderManager());
    ModelBase cyborgMaleModel = new ModelCyborgMale(1F);

    RenderLivingBase cyborgFemaleRender;// = new RenderCyborgFemale(Minecraft.getMinecraft().getRenderManager());
    ModelBase cyborgFemaleModel = new ModelCyborgFemale(0.95F);

    boolean hasAMale = false;

    @SideOnly(Side.CLIENT)
    @SubscribeEvent
    public void onPlayerLogsIn(PlayerEvent.PlayerLoggedInEvent event) {
    }




    @SideOnly(Side.CLIENT)
    @SubscribeEvent
    public void preRenderPlayer(RenderPlayerEvent.Pre event) {
        event.getEntity().sendMessage(new TextComponentString("this is a test"));
        EntityPlayer player = (EntityPlayer) event.getEntity();
        IRace race = player.getCapability(RaceProvider.RACE_CAPABILITY, null);
        int raceId = race.getRace();
        IGender gender = player.getCapability(GenderProvider.GENDER_CAPABILITY, null);
        int genderType = gender.getGender();

        Azbrs.logger.info("[AZBRS/Info System]the render system get :\n" + raceId + " for the race\n" + genderType + "for the gender");

        if(genderType == 1) {
            event.setCanceled(true);
            cyborgFemaleRender = new RenderLivingBase<AbstractClientPlayer>(event.getRenderer().getRenderManager(), cyborgFemaleModel, 0.5F){
                @Override
                protected ResourceLocation getEntityTexture(AbstractClientPlayer entity) {
                    return new ResourceLocation(Reference.MOD_ID + ":" + "textures/race/cyborg_female.png");
                }
            };
            cyborgFemaleRender.doRender((AbstractClientPlayer) event.getEntityLiving(), event.getX(), event.getY(), event.getZ(), 0, event.getPartialRenderTick());
        } else if (genderType == 0){
            event.setCanceled(true);
            cyborgMaleRender = new RenderLivingBase<AbstractClientPlayer>(event.getRenderer().getRenderManager(), cyborgMaleModel, 0.5F){
                @Override
                protected ResourceLocation getEntityTexture(AbstractClientPlayer entity) {
                    return new ResourceLocation(Reference.MOD_ID + ":" + "textures/race/cyborg_male.png");
                }
            };
            cyborgMaleRender.doRender((AbstractClientPlayer) event.getEntityLiving(), event.getX(), event.getY(), event.getZ(), 0, event.getPartialRenderTick());
        }
    }
}
