package me.mrdaniel.npcs.catalogtypes.optiontype.types;

import java.util.Optional;

import me.mrdaniel.npcs.catalogtypes.optiontype.OptionType;
import me.mrdaniel.npcs.catalogtypes.zombietype.ZombieType;
import me.mrdaniel.npcs.interfaces.mixin.NPCAble;
import me.mrdaniel.npcs.io.NPCFile;
import net.minecraft.entity.monster.EntityZombie;

public class OptionZombieType extends OptionType<ZombieType> {

	public OptionZombieType() {
		super("ZombieType", "zombietype");
	}

	@Override
	public boolean isSupported(final NPCAble npc) {
		return npc instanceof EntityZombie;
	}

	@Override
	public void writeToNPC(final NPCAble npc, final ZombieType value) {
		npc.setNPCZombieType(value);
	}

	@Override
	public void writeToFile(final NPCFile file, final ZombieType value) {
		file.setZombieType(value).save();
	}

	@Override
	public Optional<ZombieType> readFromFile(final NPCFile file) {
		return file.getZombieType();
	}
}