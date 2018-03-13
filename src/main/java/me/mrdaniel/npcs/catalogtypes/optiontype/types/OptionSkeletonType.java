package me.mrdaniel.npcs.catalogtypes.optiontype.types;

import java.util.Optional;

import me.mrdaniel.npcs.catalogtypes.optiontype.OptionType;
import me.mrdaniel.npcs.catalogtypes.skeletontype.SkeletonType;
import me.mrdaniel.npcs.interfaces.mixin.NPCAble;
import me.mrdaniel.npcs.io.NPCFile;
import net.minecraft.entity.monster.EntitySkeleton;

public class OptionSkeletonType extends OptionType<SkeletonType> {

	public OptionSkeletonType() {
		super("SkeletonType", "skeletontype");
	}

	@Override
	public boolean isSupported(final NPCAble npc) {
		return npc instanceof EntitySkeleton;
	}

	@Override
	public void writeToNPC(final NPCAble npc, final SkeletonType value) {
		npc.setNPCSkeletonType(value);
	}

	@Override
	public void writeToFile(final NPCFile file, final SkeletonType value) {
		file.setSkeletonType(value).save();
	}

	@Override
	public Optional<SkeletonType> readFromFile(final NPCFile file) {
		return file.getSkeletonType();
	}
}