package me.mrdaniel.npcs.catalogtypes.horsetype;

import org.spongepowered.api.CatalogType;
import org.spongepowered.api.util.annotation.CatalogedBy;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@CatalogedBy(HorseTypes.class)
public class HorseType implements CatalogType {

	@Getter private final String name;
	@Getter private final String id;
	@Getter private final net.minecraft.entity.passive.HorseType type;
}