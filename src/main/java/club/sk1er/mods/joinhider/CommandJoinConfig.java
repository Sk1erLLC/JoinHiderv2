package club.sk1er.mods.joinhider;

import club.sk1er.mods.core.ModCore;
import club.sk1er.mods.core.command.ModCoreCommand;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;

public class CommandJoinConfig extends ModCoreCommand {
    @Override
    public String getCommandName() {
        return "joinconfig";
    }

    @Override
    public String getCommandUsage(ICommandSender sender) {
        return getCommandName();
    }

    @Override
    public void processCommand(ICommandSender sender, String[] args) throws CommandException {
        ModCore.getInstance().getGuiHandler().open(HypixelJoinHider.joinConfig.gui());
    }
}
