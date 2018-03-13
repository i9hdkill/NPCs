package me.mrdaniel.npcs.catalogtypes.zombietype;

import java.util.List;
import java.util.Optional;

import javax.annotation.Nonnull;

import org.spongepowered.api.registry.CatalogRegistryModule;

import com.google.common.collect.Lists;

import lombok.Getter;

public class ZombieTypeRegistryModule implements CatalogRegistryModule<ZombieType> {

	@Getter private final List<ZombieType> all;

	public ZombieTypeRegistryModule() {
		this.all = Lists.newArrayList(ZombieTypes.ZOMBIE, ZombieTypes.HUSK, ZombieTypes.BUTCHER, ZombieTypes.FARMER, ZombieTypes.LIBRARIAN, ZombieTypes.PRIEST, ZombieTypes.SMITH);
	}

	@Override
	public Optional<ZombieType> getById(@Nonnull final String id) {
		for (ZombieType type : this.all) { if (type.getId().equalsIgnoreCase(id)) { return Optional.of(type); } }
		return Optional.empty();
	}
}