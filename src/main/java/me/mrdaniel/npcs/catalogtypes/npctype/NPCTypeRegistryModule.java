package me.mrdaniel.npcs.catalogtypes.npctype;

import java.util.List;
import java.util.Optional;

import javax.annotation.Nonnull;

import org.spongepowered.api.registry.CatalogRegistryModule;

import com.google.common.collect.Lists;

import lombok.Getter;

public class NPCTypeRegistryModule implements CatalogRegistryModule<NPCType> {

	@Getter private final List<NPCType> all;

	public NPCTypeRegistryModule() {
		this.all = Lists.newArrayList(NPCTypes.BAT, NPCTypes.BLAZE, NPCTypes.CAVE_SPIDER, NPCTypes.CHICKEN, NPCTypes.COW, NPCTypes.CREEPER,
				NPCTypes.ELDER_GUARDIAN, NPCTypes.ENDER_DRAGON, NPCTypes.ENDERMAN, NPCTypes.ENDERMITE, NPCTypes.EVOCATION_ILLAGER,
				NPCTypes.GHAST, NPCTypes.GIANT, NPCTypes.GUARDIAN, NPCTypes.HORSE, NPCTypes.HUMAN, NPCTypes.ILLUSION_ILLAGER,
				NPCTypes.IRON_GOLEM, NPCTypes.MAGMA_CUBE, NPCTypes.MUSHROOM_COW, NPCTypes.OCELOT, NPCTypes.PARROT,
				NPCTypes.PIG, NPCTypes.PIG_ZOMBIE, NPCTypes.POLAR_BEAR, NPCTypes.RABBIT, NPCTypes.SHEEP, NPCTypes.SHULKER, NPCTypes.SILVERFISH,
				NPCTypes.SKELETON, NPCTypes.SLIME, NPCTypes.SNOWMAN, NPCTypes.SPIDER, NPCTypes.SQUID, NPCTypes.STRAY,
				NPCTypes.VEX, NPCTypes.VILLAGER, NPCTypes.VINDICATION_ILLAGER, NPCTypes.WITCH, NPCTypes.WITHER,
				NPCTypes.WOLF, NPCTypes.ZOMBIE);
	}

	@Override
	public Optional<NPCType> getById(@Nonnull final String id) {
		for (NPCType type : this.all) { if (type.getId().equalsIgnoreCase(id)) { return Optional.of(type); } }
		return Optional.empty();
	}
}