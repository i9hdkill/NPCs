package me.mrdaniel.npcs.catalogtypes.skeletontype;

import java.util.List;
import java.util.Optional;

import javax.annotation.Nonnull;

import org.spongepowered.api.registry.CatalogRegistryModule;

import com.google.common.collect.Lists;

import lombok.Getter;

public class SkeletonTypeRegistryModule implements CatalogRegistryModule<SkeletonType> {

	@Getter private final List<SkeletonType> all;

	public SkeletonTypeRegistryModule() {
		this.all = Lists.newArrayList(SkeletonTypes.SKELETON, SkeletonTypes.STRAY, SkeletonTypes.WITHER);
	}

	@Override
	public Optional<SkeletonType> getById(@Nonnull final String id) {
		for (SkeletonType type : this.all) { if (type.getId().equalsIgnoreCase(id)) { return Optional.of(type); } }
		return Optional.empty();
	}
}
