//package me.mrdaniel.npcs.commands.wip;
//
//import javax.annotation.Nonnull;
//
//import org.spongepowered.api.command.CommandException;
//import org.spongepowered.api.command.args.CommandContext;
//import org.spongepowered.api.entity.living.Living;
//import org.spongepowered.api.entity.living.player.Player;
//import org.spongepowered.api.text.Text;
//import org.spongepowered.api.text.format.TextColors;
//
//import me.mrdaniel.npcs.NPCs;
//import me.mrdaniel.npcs.commands.NPCCommand;
//import me.mrdaniel.npcs.data.WalkingData;
//
//public class CommandWalkPosAdd extends NPCCommand {
//
//	public CommandWalkPosAdd(@Nonnull final NPCs npcs) {
//		super(npcs);
//	}
//
//	@Override
//	public void execute(final Player player, final Living npc, final CommandContext args) throws CommandException {
//		WalkingData data = npc.get(WalkingData.class).orElseThrow(() -> new CommandException(Text.of(TextColors.RED, "You must make the selected NPC walk first.")));
//
//		data.addWalkPosition(player.getLocation().getPosition());
//		npc.offer(data);
//
//		player.sendMessage(Text.of(TextColors.YELLOW, "You added a Walk Position to the selected NPC."));
//	}
//}