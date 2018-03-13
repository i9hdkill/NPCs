package me.mrdaniel.npcs.catalogtypes.skeletontype;

import org.spongepowered.api.CatalogType;
import org.spongepowered.api.util.annotation.CatalogedBy;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@CatalogedBy(SkeletonTypes.class)
public class SkeletonType implements CatalogType {

	@Getter private final String name;
	@Getter private final String id;
	@Getter private final net.minecraft.entity.monster.SkeletonType type;
}