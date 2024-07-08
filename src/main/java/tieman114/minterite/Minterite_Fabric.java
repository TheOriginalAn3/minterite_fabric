package tieman114.minterite;

import net.fabricmc.api.ModInitializer;
import tieman114.minterite.block.ModBlocks;
import tieman114.minterite.item.ModItemGroups;
import tieman114.minterite.item.ModItems;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Minterite_Fabric implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final String MOD_ID = "minterite_fabric";
    public static final Logger LOGGER = LoggerFactory.getLogger("minterite_fabric");

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		ModItemGroups.registerItemGroups();
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

		LOGGER.info("Hello Fabric world!");
	}
}