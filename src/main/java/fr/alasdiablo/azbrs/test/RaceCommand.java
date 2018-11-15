package fr.alasdiablo.azbrs.test;

import fr.alasdiablo.azbrs.capabilities.IRace;
import fr.alasdiablo.azbrs.capabilities.RaceProvider;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.text.TextComponentString;

public class RaceCommand extends CommandBase {

    @Override
    public String getName() {
        return "race";
    }

    @Override
    public String getUsage(ICommandSender sender) {
        return "race <race id>";
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
        IRace race = sender.getCommandSenderEntity().getCapability(RaceProvider.RACE_CAPABILITY, null);
        int newRaceId = Integer.parseInt(args[0]);
        race.setRace(newRaceId);
        sender.sendMessage(new TextComponentString("\u00A72your race was chang"));
    }
}
