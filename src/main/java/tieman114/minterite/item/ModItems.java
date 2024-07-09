package tieman114.minterite.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.component.type.FoodComponents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import tieman114.minterite.Minterite_Fabric;

public class ModItems {

  // JUMP: Register Mod Items
  public static final Item MINT_LEAVES = registerItem(new Item(new Item.Settings().food(FoodComponents.APPLE)),
      "mint_leaves");

  // Helper methods
  public static Item registerItem(Item item, String id) {
    return Registry.register(Registries.ITEM, Identifier.of(Minterite_Fabric.MOD_ID, id), item);
  }

  public static void registerModItems() {
    // Register the item
    Minterite_Fabric.LOGGER.info("Registering Mod Items for " + Minterite_Fabric.MOD_ID);
    ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS)
        .register((itemGroup) -> itemGroup.add(ModItems.MINT_LEAVES));

  }
}
