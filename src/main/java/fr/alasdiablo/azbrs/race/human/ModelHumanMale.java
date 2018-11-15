package fr.alasdiablo.azbrs.race.human;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelHumanMale extends ModelBiped {


    ModelRenderer head;
    ModelRenderer body;
    ModelRenderer rightarm;
    ModelRenderer leftarm;
    ModelRenderer rightleg;
    ModelRenderer leftleg;

    public ModelHumanMale(float scale) {
        //super(scale, false);
        super(scale, 0, 64, 64);

        textureWidth = 64;
        textureHeight = 64;

        head = new ModelRenderer(this, 64, 0);
        head.addBox(-4F, -8F, -4F, 8, 8, 8);
        head.setRotationPoint(0F, 0F, 0F);
        head.setTextureSize(64, 64);
        head.mirror = true;
        setRotation(head, 0F, 0F, 0F);
        body = new ModelRenderer(this, 16 + 64, 16);
        body.addBox(-4F, 0F, -2F, 8, 12, 4);
        body.setRotationPoint(0F, 0F, 0F);
        body.setTextureSize(64, 64);
        body.mirror = true;
        setRotation(body, 0F, 0F, 0F);
        rightarm = new ModelRenderer(this, 40 + 64, 16);
        rightarm.addBox(-3F, -2F, -2F, 4, 12, 4);
        rightarm.setRotationPoint(0F, 0F, 0F);
        rightarm.setTextureSize(64, 64);
        rightarm.mirror = false;
        setRotation(rightarm, 0F, 0F, 0F);
        leftarm = new ModelRenderer(this, 40 + 64, 16);
        leftarm.addBox(-1F, -2F, -2F, 4, 12, 4);
        leftarm.setRotationPoint(0F, 0F, 0F);
        leftarm.setTextureSize(64, 64);
        leftarm.mirror = false;
        setRotation(leftarm, 0F, 0F, 0F);
        rightleg = new ModelRenderer(this, 64, 16);
        rightleg.addBox(-2F, 0F, -2F, 4, 12, 4);
        rightleg.setRotationPoint(0F, 0F, 0F);
        rightleg.setTextureSize(64, 64);
        rightleg.mirror = false;
        setRotation(rightleg, 0F, 0F, 0F);
        leftleg = new ModelRenderer(this, 64, 16);
        leftleg.addBox(-2F, 0F, -2F, 4, 12, 4);
        leftleg.setRotationPoint(0F, 0F, 0F);
        leftleg.setTextureSize(64, 64);
        leftleg.mirror = false;
        setRotation(leftleg, 0F, 0F, 0F);

        bipedHeadwear.showModel = false;

        bipedBody.addChild(body);
        bipedHead.addChild(head);
        bipedLeftArm.addChild(leftarm);
        bipedRightArm.addChild(rightarm);
        bipedLeftLeg.addChild(leftleg);
        bipedRightLeg.addChild(rightleg);

    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    }

    private void setRotation(ModelRenderer model, float x, float y, float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }
}
