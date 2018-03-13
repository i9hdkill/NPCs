package me.mrdaniel.npcs.managers.menu;

import javax.annotation.Nonnull;

import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.action.TextActions;
import org.spongepowered.api.text.format.TextColors;

import me.mrdaniel.npcs.catalogtypes.glowcolor.GlowColors;
import me.mrdaniel.npcs.catalogtypes.npctype.NPCTypes;
import me.mrdaniel.npcs.catalogtypes.optiontype.OptionTypes;
import me.mrdaniel.npcs.catalogtypes.rabbittype.RabbitTypes;
import me.mrdaniel.npcs.interfaces.mixin.NPCAble;
import me.mrdaniel.npcs.io.NPCFile;
import me.mrdaniel.npcs.utils.TextUtils;

public class MainPage extends Page {

	private static final Text BUTTONS = Text.builder().append(
			Text.of("   "),
			Text.builder().append(Text.of(TextColors.YELLOW, "[Go To]")).onHover(TextActions.showText(Text.of(TextColors.YELLOW, "Teleport to NPC"))).onClick(TextActions.runCommand("/npc goto")).build(),
			Text.of("   "),
			Text.builder().append(Text.of(TextColors.YELLOW, "[Move]")).onHover(TextActions.showText(Text.of(TextColors.YELLOW, "Teleport NPC to you"))).onClick(TextActions.runCommand("/npc move")).build(),
			Text.of("   "),
			Text.builder().append(Text.of(TextColors.YELLOW, "[Deselect]")).onHover(TextActions.showText(Text.of(TextColors.YELLOW, "Deselect"))).onClick(TextActions.runCommand("/npc deselect")).build(),
			Text.of("   "),
			Text.builder().append(Text.of(TextColors.DARK_GREEN, "[Mount]")).onHover(TextActions.showText(Text.of(TextColors.DARK_GREEN, "Mount"))).onClick(TextActions.runCommand("/npc mount")).build(),
			Text.of("   "),
			Text.builder().append(Text.of(TextColors.GOLD, "[Copy]")).onHover(TextActions.showText(Text.of(TextColors.GOLD, "Copy"))).onClick(TextActions.suggestCommand("/npc copy")).build(),
			Text.of("   "),
			Text.builder().append(Text.of(TextColors.RED, "[Remove]")).onHover(TextActions.showText(Text.of(TextColors.RED, "Remove"))).onClick(TextActions.suggestCommand("/npc remove")).build())
			.build();

	public MainPage(@Nonnull final NPCAble npc) {
		super(npc);
	}

	@Override
	public void updatePage(final NPCAble npc) {
		NPCFile file = npc.getNPCFile();
		int c = 0;

		lines[c++] = BUTTONS;
		lines[++c] = Text.of(TextColors.GOLD, "NPC ID: ", TextColors.RED, file.getId());
		lines[++c] = Text.of(TextColors.GOLD, "Type: ", TextColors.RED, file.getType().orElse(NPCTypes.HUMAN).getName());
		lines[++c] = Text.of(TextColors.GOLD, "Location: ", TextColors.RED, file.getWorldName(), " ", (int)file.getX(), " ", (int)file.getY(), " ", (int)file.getZ());
		++c;

		lines[++c] = Text.builder().append(Text.of(TextColors.GOLD, "Name: ", TextColors.AQUA)).append(TextUtils.toText(file.getName().orElse("None"))).onHover(TextActions.showText(Text.of(TextColors.YELLOW, "Change"))).onClick(TextActions.suggestCommand("/npc name <name>")).build();
		if (OptionTypes.SKIN.isSupported(npc)) { lines[++c] = Text.builder().append(Text.of(TextColors.GOLD, "Skin: ", TextColors.AQUA, file.getSkinName().orElse("None"))).onHover(TextActions.showText(Text.of(TextColors.YELLOW, "Change"))).onClick(TextActions.suggestCommand("/npc skin <name>")).build(); }
		++c;

		lines[++c] = TextUtils.getToggleText("Looking", "/npc looking", file.getLooking());
		lines[++c] = TextUtils.getToggleText("Interact", "/npc interact", file.getInteract());
		lines[++c] = TextUtils.getToggleText("Silent", "/npc silent", file.getSilent());

		lines[++c] = TextUtils.getToggleText("Glowing", "/npc glowing", file.getGlowing());
		lines[++c] = TextUtils.getOptionsText("GlowColor", "/npc glowcolor <color>", file.getGlowColor().orElse(GlowColors.WHITE).getName());
		if (OptionTypes.BABY.isSupported(npc)) { lines[++c] = TextUtils.getToggleText("Baby", "/npc baby", file.getBaby()); }
		if (OptionTypes.SADDLE.isSupported(npc)) { lines[++c] = TextUtils.getToggleText("Saddle", "/npc saddle", file.getSaddle()); }
		if (OptionTypes.HANGING.isSupported(npc)) { lines[++c] = TextUtils.getToggleText("Hanging", "/npc hanging", file.getHanging()); }
		if (OptionTypes.PUMPKIN.isSupported(npc)) { lines[++c] = TextUtils.getToggleText("Pumpkin", "/npc pumpkin", file.getPumpkin()); }
		if (OptionTypes.CHARGED.isSupported(npc)) { lines[++c] = TextUtils.getToggleText("Charged", "/npc charged", file.getCharged()); }
		if (OptionTypes.ANGRY.isSupported(npc)) { lines[++c] = TextUtils.getToggleText("Angry", "/npc angry", file.getAngry()); }
		if (OptionTypes.SIZE.isSupported(npc)) { lines[++c] = TextUtils.getOptionsText("Size", "/npc size <size>", String.valueOf(file.getSize())); }
		if (OptionTypes.SITTING.isSupported(npc)) { lines[++c] = TextUtils.getToggleText("Sit", "/npc sitting", file.getSitting()); }
		if (OptionTypes.CAREER.isSupported(npc)) { lines[++c] = TextUtils.getOptionsText("Career", "/npc career <career>", file.getCareer().map(v -> v.getName()).orElse("None")); }
		if (OptionTypes.HORSEPATTERN.isSupported(npc)) { lines[++c] = TextUtils.getOptionsText("Style", "/npc horsepattern <style>", file.getHorsePattern().map(v -> TextUtils.capitalize(v.getName().toLowerCase())).orElse("None")); }
		if (OptionTypes.HORSECOLOR.isSupported(npc)) { lines[++c] = TextUtils.getOptionsText("Color", "/npc horsecolor <color>", file.getHorseColor().map(v -> TextUtils.capitalize(v.getName().toLowerCase())).orElse("None")); }
		if (OptionTypes.HORSETYPE.isSupported(npc)) { lines[++c] = TextUtils.getOptionsText("Variant", "/npc horsetype <variant>", file.getHorseType().map(v -> TextUtils.capitalize(v.getName().toLowerCase())).orElse("None")); }
		if (OptionTypes.ZOMBIETYPE.isSupported(npc)) { lines[++c] = TextUtils.getOptionsText("Zombie", "/npc zombietype <type>", file.getZombieType().map(v -> TextUtils.capitalize(v.getName().toLowerCase())).orElse("None")); }
		if (OptionTypes.SKELETONTYPE.isSupported(npc)) { lines[++c] = TextUtils.getOptionsText("Skeleton", "/npc skeletontype <type>", file.getSkeletonType().map(v -> TextUtils.capitalize(v.getName())).orElse("None")); }
		if (OptionTypes.CATTYPE.isSupported(npc)) { lines[++c] = TextUtils.getOptionsText("Cat", "/npc cattype <type>", file.getCatType().map(v -> TextUtils.capitalize(v.getId().toLowerCase().replace("ocelot", ""))).orElse("None")); }
		if (OptionTypes.RABBITTYPE.isSupported(npc)) { lines[++c] = TextUtils.getOptionsText("RabbitType", "/npc rabbittype <type>", file.getRabbitType().orElse(RabbitTypes.BROWN).getName()); }
	}
}