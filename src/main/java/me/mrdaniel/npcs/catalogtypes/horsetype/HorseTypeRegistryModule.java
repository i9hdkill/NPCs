package me.mrdaniel.npcs.catalogtypes.horsetype;

import java.util.List;
import java.util.Optional;

import javax.annotation.Nonnull;

import org.spongepowered.api.registry.CatalogRegistryModule;

import com.google.common.collect.Lists;

import lombok.Getter;

public class HorseTypeRegistryModule implements CatalogRegistryModule<HorseType> {

	@Getter private final List<HorseType> all;

	public HorseTypeRegistryModule() {
		this.all = Lists.newArrayList(HorseTypes.HORSE, HorseTypes.DONKEY, HorseTypes.MULE, HorseTypes.SKELETON, HorseTypes.ZOMBIE);
	}

	@Override
	public Optional<HorseType> getById(@Nonnull final String id) {
		for (HorseType type : this.all) { if (type.getId().equalsIgnoreCase(id)) { return Optional.of(type); } }
		return Optional.empty();
	}
}