package fr.alasdiablo.azbrs.test;

import fr.alasdiablo.azbrs.capabilities.GenderProvider;
import fr.alasdiablo.azbrs.capabilities.IGender;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.text.TextComponentString;

public class GenderCommand  extends CommandBase {

    @Override
    public String getName() {
        return "gender";
    }

    @Override
    public String getUsage(ICommandSender sender) {
        return "gender <gender id>";
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
        IGender gender = sender.getCommandSenderEntity().getCapability(GenderProvider.GENDER_CAPABILITY, null);
        int newGenderType = Integer.parseInt(args[0]);
        gender.setGender(newGenderType);
        sender.sendMessage(new TextComponentString("\u00A72your gender was chang"));
    }
}