package tieman114.minterite.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import tieman114.minterite.Minterite_Fabric;
import tieman114.minterite.block.ModBlocks;

public class ModItemGroups {

    // JUMP: Register Item Groups
    public static final ItemGroup MINTERITE_ITEM_GROUP = Registry.register(Registries.ITEM_GROUP,
            RegistryKey.of(Registries.ITEM_GROUP.getKey(),
                    Identifier.of(Minterite_Fabric.MOD_ID, "mint_leaves")),
            FabricItemGroup.builder()
                    .displayName(Text.translatable("itemGroup.minterite_fabric"))
                    .icon(() -> new ItemStack(ModItems.MINT_LEAVES))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.MINT_LEAVES);
                        entries.add(ModBlocks.MINT_LEAVES_BLOCK);
                    }).build());

    // Helper methods
    public static void registerItemGroups() {
        Minterite_Fabric.LOGGER.info("Registering Item Groups for " + Minterite_Fabric.MOD_ID);
        // Registry.register(Registries.ITEM_GROUP, CUSTOM_ITEM_GROUP_KEY,
        // CUSTOM_ITEM_GROUP);

    }

}
