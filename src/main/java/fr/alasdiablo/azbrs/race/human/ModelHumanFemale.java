package fr.alasdiablo.azbrs.race.human;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelHumanFemale extends ModelBiped {

    ModelRenderer rightbreast1;
    ModelRenderer rightbreast2;
    ModelRenderer leftbreast1;
    ModelRenderer leftbreast2;
    ModelRenderer head;
    ModelRenderer body;
    ModelRenderer rightarm;
    ModelRenderer leftarm;
    ModelRenderer rightleg;
    ModelRenderer leftleg;

    public ModelHumanFemale(float scale) {
        //super(scale, false);
        super(scale, 0, 64, 64);

        textureWidth = 64;
        textureHeight = 64;


        rightbreast1 = new ModelRenderer(this, 20 + 64, 21);
        rightbreast1.addBox(-3F, 2.5F, -1.75F, 2, 2, 1);
        rightbreast1.setRotationPoint(0F, 0F, 0F);
        rightbreast1.setTextureSize(64, 64);
        rightbreast1.mirror = true;
        setRotation(rightbreast1, -0.1919862F, 0F, 0F);
        rightbreast2 = new ModelRenderer(this, 20 + 64, 23);
        rightbreast2.addBox(-3F, 1.9F, -4.4F, 2, 1, 1);
        rightbreast2.setRotationPoint(0F, 0F, 0F);
        rightbreast2.setTextureSize(64, 64);
        rightbreast2.mirror = true;
        setRotation(rightbreast2, 0.6108652F, 0F, 0F);
        leftbreast1 = new ModelRenderer(this, 24 + 64, 21);
        leftbreast1.addBox(1F, 2.5F, -1.8F, 2, 2, 1);
        leftbreast1.setRotationPoint(0F, 0F, 0F);
        leftbreast1.setTextureSize(64, 64);
        leftbreast1.mirror = true;
        setRotation(leftbreast1, -0.1919862F, 0F, 0F);
        leftbreast2 = new ModelRenderer(this, 24 + 64, 23);
        leftbreast2.addBox(1F, 1.9F, -4.4F, 2, 1, 1);
        leftbreast2.setRotationPoint(0F, 0F, 0F);
        leftbreast2.setTextureSize(64, 64);
        leftbreast2.mirror = true;
        setRotation(leftbreast2, 0.6108652F, 0F, 0F);
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
        rightarm.mirror = true;
        setRotation(rightarm, 0F, 0F, 0F);
        leftarm = new ModelRenderer(this, 40 + 64, 16);
        leftarm.addBox(-1F, -2F, -2F, 4, 12, 4);
        leftarm.setRotationPoint(0F, 0F, 0F);
        leftarm.setTextureSize(64, 64);
        leftarm.mirror = true;
        setRotation(leftarm, 0F, 0F, 0F);
        rightleg = new ModelRenderer(this, 64, 16);
        rightleg.addBox(-2F, 0F, -2F, 4, 12, 4);
        rightleg.setRotationPoint(0F, 0F, 0F);
        rightleg.setTextureSize(64, 64);
        rightleg.mirror = true;
        setRotation(rightleg, 0F, 0F, 0F);
        leftleg = new ModelRenderer(this, 64, 16);
        leftleg.addBox(-2F, 0F, -2F, 4, 12, 4);
        leftleg.setRotationPoint(0F, 0F, 0F);
        leftleg.setTextureSize(64, 64);
        leftleg.mirror = true;
        setRotation(leftleg, 0F, 0F, 0F);

        bipedHeadwear.showModel = false;

        bipedBody.addChild(body);
        bipedBody.addChild(leftbreast1);
        bipedBody.addChild(leftbreast2);
        bipedBody.addChild(rightbreast1);
        bipedBody.addChild(rightbreast2);
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
