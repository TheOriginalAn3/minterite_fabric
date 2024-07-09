package tieman114.minterite;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.advancement.*;
import net.minecraft.advancement.criterion.ConsumeItemCriterion;
import net.minecraft.advancement.criterion.InventoryChangedCriterion;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.RegistryWrapper.WrapperLookup;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import tieman114.minterite.block.ModBlocks;
import tieman114.minterite.item.ModItems;

public class Minterite_FabricDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator generator) {
		FabricDataGenerator.Pack pack = generator.createPack();
		pack.addProvider(TagProvider::new);
		pack.addProvider(AdvancementsProvider::new);
	}

	//JUMP: Advancements Generator
	private static class AdvancementsProvider extends FabricAdvancementProvider {
		// The MyAdvancementGenerator class is responsible for providing advancement data for the mod.
		protected AdvancementsProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
			super(output, completableFuture);
		}

		@Override
		public void generateAdvancement(WrapperLookup registryLookup, Consumer<AdvancementEntry> consumer) {
			AdvancementEntry rootAdvancement = Advancement.Builder.create()
                    .display(
                            Items.DIRT, // The display icon
                            Text.literal("Your First Dirt Block"), // The title
                            Text.literal("Now make a three by three"), // The description
                            Identifier.of("textures/gui/advancements/backgrounds/adventure.png"), // Background image used
                            AdvancementFrame.TASK, // Options: TASK, CHALLENGE, GOAL
                            true, // Show toast top right
                            true, // Announce to chat
                            false // Hidden in the advancement tab
                    )
                    // The first string used in criterion is the name referenced by other advancements when they want to have 'requirements'
                    .criterion("got_dirt", InventoryChangedCriterion.Conditions.items(Items.DIRT))
                    .build(consumer, "minterite_fabric" + "/root");
 
            AdvancementEntry gotOakAdvancement = Advancement.Builder.create().parent(rootAdvancement)
                    .display(
                            Items.OAK_LOG,
                            Text.literal("Your First Log"),
                            Text.literal("Bare fisted"),
                            null, // children to parent advancements don't need a background set
                            AdvancementFrame.TASK,
                            true,
                            true,
                            false
                    )
                    .rewards(AdvancementRewards.Builder.experience(1000))
                    .criterion("got_wood", InventoryChangedCriterion.Conditions.items(Items.OAK_LOG))
                    .build(consumer, "minterite_fabric" + "/got_wood");
 
            AdvancementEntry eatAppleAdvancement = Advancement.Builder.create().parent(rootAdvancement)
                    .display(
                            Items.APPLE,
                            Text.literal("Apple and Beef"),
                            Text.literal("Ate an apple and beef"),
                            null, // children to parent advancements don't need a background set
                            AdvancementFrame.CHALLENGE,
                            true,
                            true,
                            false
                    )
                    .criterion("ate_apple", ConsumeItemCriterion.Conditions.item(Items.APPLE))
                    .criterion("ate_cooked_beef", ConsumeItemCriterion.Conditions.item(Items.COOKED_BEEF))
                    .build(consumer, "minterite_fabric" + "/ate_apple_and_beef");
		}
		
	}




	//JUMP: Tag Generator
    private static class TagProvider extends FabricTagProvider.ItemTagProvider {
		// The TagKey object that will be used to store the custom item tags.
		private static final TagKey<Item> SMELLY_ITEMS = TagKey.of(RegistryKeys.ITEM, Identifier.of("mymod:smelly_items"));

		// The MyTagGenerator class is responsible for providing item tag data for the mod.
        public TagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
            super(output, completableFuture);
        }

		// This method is responsible for configuring the item tags for the mod.
		// Add custom items here.
		@Override
		protected void configure(RegistryWrapper.WrapperLookup arg) {
			getOrCreateTagBuilder(SMELLY_ITEMS)
				.add(ModItems.MINT_LEAVES)
				.add(ModBlocks.MINT_LEAVES_BLOCK.asItem())
				.add(Items.SLIME_BALL);
		}
	}
}
