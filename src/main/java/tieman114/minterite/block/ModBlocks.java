package tieman114.minterite.block;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import tieman114.minterite.Minterite_Fabric;

public class ModBlocks {

    public static final Block MINT_LEAVES_BLOCK = registerModBlocks(new Block(AbstractBlock.Settings.create().sounds(BlockSoundGroup.AZALEA_LEAVES)),"mint_leaves_block", true);






    public static Block registerModBlocks(Block block, String name, boolean shouldRegisterItem) {
        // Register the block and its item.
        Identifier id = Identifier.of(Minterite_Fabric.MOD_ID, name);
    
        // Sometimes, you may not want to register an item for the block.
        // Eg: if it's a technical block like `minecraft:air` or `minecraft:end_gateway`
        if (shouldRegisterItem) {
            BlockItem blockItem = new BlockItem(block, new Item.Settings());
            Registry.register(Registries.ITEM, id, blockItem);
        }
    
        return Registry.register(Registries.BLOCK, id, block);
    }

    public static void registerModBlocks() {
        
    }
}
