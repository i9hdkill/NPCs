package me.mrdaniel.npcs.catalogtypes.zombietype;

public class ZombieTypes {

	public static final ZombieType ZOMBIE = new ZombieType("Zombie", "zombie", net.minecraft.entity.monster.ZombieType.NORMAL);
	public static final ZombieType HUSK = new ZombieType("Husk", "husk", net.minecraft.entity.monster.ZombieType.HUSK);
	public static final ZombieType BUTCHER = new ZombieType("Butcher", "butcher", net.minecraft.entity.monster.ZombieType.VILLAGER_BUTCHER);
	public static final ZombieType FARMER = new ZombieType("Farmer", "farmer", net.minecraft.entity.monster.ZombieType.VILLAGER_FARMER);
	public static final ZombieType LIBRARIAN = new ZombieType("Librarian", "librarian", net.minecraft.entity.monster.ZombieType.VILLAGER_LIBRARIAN);
	public static final ZombieType SMITH = new ZombieType("Smith", "smith", net.minecraft.entity.monster.ZombieType.VILLAGER_SMITH);
	public static final ZombieType PRIEST = new ZombieType("Priest", "priest", net.minecraft.entity.monster.ZombieType.VILLAGER_PRIEST);
}