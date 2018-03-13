package me.mrdaniel.npcs.catalogtypes.optiontype.types;

import java.util.Optional;

import me.mrdaniel.npcs.catalogtypes.horsetype.HorseType;
import me.mrdaniel.npcs.catalogtypes.optiontype.OptionType;
import me.mrdaniel.npcs.interfaces.mixin.NPCAble;
import me.mrdaniel.npcs.io.NPCFile;
import net.minecraft.entity.passive.EntityHorse;

public class OptionHorseType extends OptionType<HorseType> {

	public OptionHorseType() {
		super("HorseType", "horsetype");
	}

	@Override
	public boolean isSupported(final NPCAble npc) {
		return npc instanceof EntityHorse;
	}

	@Override
	public void writeToNPC(final NPCAble npc, final HorseType value) {
		npc.setNPCHorseType(value);
	}

	@Override
	public void writeToFile(final NPCFile file, final HorseType value) {
		file.setHorseType(value);
	}

	@Override
	public Optional<HorseType> readFromFile(final NPCFile file) {
		return file.getHorseType();
	}
}