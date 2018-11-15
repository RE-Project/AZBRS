package fr.alasdiablo.azbrs.network;

import fr.alasdiablo.azbrs.capabilities.IRace;
import fr.alasdiablo.azbrs.capabilities.RaceProvider;
import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class PacketSendRace implements IMessage {

    private int raceId;

    @Override
    public void fromBytes(ByteBuf buf) {
        raceId = buf.readInt();
    }

    @Override
    public void toBytes(ByteBuf buf) {
        buf.writeInt(raceId);
    }

    public PacketSendRace(int id) {
        this.raceId = id;
    }

    public static class Handler implements IMessageHandler<PacketSendRace, IMessage> {
        @Override
        public IMessage onMessage(PacketSendRace message, MessageContext ctx) {
            FMLCommonHandler.instance().getWorldThread(ctx.netHandler).addScheduledTask(() -> handle(message, ctx));
            return null;
        }

        private void handle(PacketSendRace message, MessageContext ctx) {
            EntityPlayerSP player = Minecraft.getMinecraft().player;
            IRace race = player.getCapability(RaceProvider.RACE_CAPABILITY, null);
            race.setRace(message.raceId);
        }
    }
}
