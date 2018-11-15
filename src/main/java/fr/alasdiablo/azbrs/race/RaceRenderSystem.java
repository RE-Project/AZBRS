package fr.alasdiablo.azbrs.race;

import fr.alasdiablo.azbrs.capabilities.GenderProvider;
import fr.alasdiablo.azbrs.capabilities.IGender;
import fr.alasdiablo.azbrs.capabilities.IRace;
import fr.alasdiablo.azbrs.capabilities.RaceProvider;
import fr.alasdiablo.azbrs.data.Reference;
import fr.alasdiablo.azbrs.race.cyborg.ModelCyborgFemale;
import fr.alasdiablo.azbrs.race.cyborg.ModelCyborgMale;
import fr.alasdiablo.azbrs.race.human.ModelHumanFemale;
import fr.alasdiablo.azbrs.race.human.ModelHumanMale;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderPlayerEvent;

import java.util.UUID;

public class RaceRenderSystem {

    /**
     * var for the cyborg race
     */
    private RenderLivingBase cyborgMaleRender;
    private ModelBase cyborgMaleModel = new ModelCyborgMale(1.0F);
    private RenderLivingBase cyborgFemaleRender;
    private ModelBase cyborgFemaleModel = new ModelCyborgFemale(0.95F);


    private RenderLivingBase humanMaleRender;
    private ModelBase humanMaleModel = new ModelHumanMale(1.0F);
    private RenderLivingBase humanFemaleRender;
    private ModelBase humanFemaleModel = new ModelHumanFemale(0.95F);

    /**
     * system for make the new player render
     * @param event the event of the render
     */
    public void renderPlayer(RenderPlayerEvent.Pre event) {
        EntityPlayer player = (EntityPlayer) event.getEntity();
        IGender gender = player.getCapability(GenderProvider.GENDER_CAPABILITY, null);
        IRace race = player.getCapability(RaceProvider.RACE_CAPABILITY, null);
        switch (race.getRace()) {
            case 0:
                this.humanRender(event, gender);
                break;
            case 1:
                this.cyborgRender(event, gender);
                break;
            default:
                break;
        }

    }

    /**
     * the system for render the human race
     * @param event the render event
     * @param gender the gender of the player
     */
    private void humanRender(RenderPlayerEvent.Pre event, IGender gender) {
        if (gender.getGender() == 1) {
            event.setCanceled(true);
            this.humanFemaleRender = new RenderLivingBase<AbstractClientPlayer>(event.getRenderer().getRenderManager(), this.humanFemaleModel, 0.5F){
                @Override
                protected ResourceLocation getEntityTexture(AbstractClientPlayer entity) {
                    return entity.getLocationSkin();
                }
            };
            this.humanFemaleRender.doRender((AbstractClientPlayer) event.getEntityLiving(), event.getX(), event.getY(), event.getZ(), 0, event.getPartialRenderTick());
        } else {
            event.setCanceled(true);
            this.humanMaleRender = new RenderLivingBase<AbstractClientPlayer>(event.getRenderer().getRenderManager(), this.humanMaleModel, 0.5F){
                @Override
                protected ResourceLocation getEntityTexture(AbstractClientPlayer entity) {
                    return entity.getLocationSkin();
                }
            };
            this.humanMaleRender.doRender((AbstractClientPlayer) event.getEntityLiving(), event.getX(), event.getY(), event.getZ(), 0, event.getPartialRenderTick());
        }
    }


    /**
     * the system for render the cyborg race
     * @param event the render event
     * @param gender the gender of the player
     */
    private void cyborgRender(RenderPlayerEvent.Pre event, IGender gender) {
        if (gender.getGender() == 1) {
            event.setCanceled(true);
            this.cyborgFemaleRender = new RenderLivingBase<AbstractClientPlayer>(event.getRenderer().getRenderManager(), this.cyborgFemaleModel, 0.5F){
                @Override
                protected ResourceLocation getEntityTexture(AbstractClientPlayer entity) {
                    return new ResourceLocation(Reference.MOD_ID + ":" + "textures/race/cyborg_female.png");
                }
            };
            this.cyborgFemaleRender.doRender((AbstractClientPlayer) event.getEntityLiving(), event.getX(), event.getY(), event.getZ(), 0, event.getPartialRenderTick());
        } else {
            event.setCanceled(true);
            this.cyborgMaleRender = new RenderLivingBase<AbstractClientPlayer>(event.getRenderer().getRenderManager(), this.cyborgMaleModel, 0.5F){
                @Override
                protected ResourceLocation getEntityTexture(AbstractClientPlayer entity) {
                    return new ResourceLocation(Reference.MOD_ID + ":" + "textures/race/cyborg_male.png");
                }
            };
            this.cyborgMaleRender.doRender((AbstractClientPlayer) event.getEntityLiving(), event.getX(), event.getY(), event.getZ(), 0, event.getPartialRenderTick());
        }
    }

    /**
     * make the render of the player
     * @param renderLivingBase the player render
     * @param modelBase the player model
     * @param event the render event
     * @param textureName the texture name
     */
    private void render(RenderLivingBase renderLivingBase, ModelBase modelBase, RenderPlayerEvent.Pre event, String textureName) {
        event.setCanceled(true);
        renderLivingBase = new RenderLivingBase<AbstractClientPlayer>(event.getRenderer().getRenderManager(), modelBase, 0.5F){
            @Override
            protected ResourceLocation getEntityTexture(AbstractClientPlayer entity) {
                return new ResourceLocation(Reference.MOD_ID + ":" + "textures/race/" + textureName + ".png");
            }
        };
        renderLivingBase.doRender((AbstractClientPlayer) event.getEntityLiving(), event.getX(), event.getY(), event.getZ(), 0, event.getPartialRenderTick());
    }
}
