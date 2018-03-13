package me.mrdaniel.npcs.catalogtypes.zombietype;

import org.spongepowered.api.CatalogType;
import org.spongepowered.api.util.annotation.CatalogedBy;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@CatalogedBy(ZombieTypes.class)
public class ZombieType implements CatalogType {

	@Getter private final String name;
	@Getter private final String id;
	@Getter private final net.minecraft.entity.monster.ZombieType type;
}
