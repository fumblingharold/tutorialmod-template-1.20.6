package net.fumblingharold.tutorialmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.fumblingharold.tutorialmod.block.ModBlocks;
import net.fumblingharold.tutorialmod.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Items;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LootPoolEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
  public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
    super(dataOutput, registryLookup);
  }

  @Override
  public void generate() {
    addDrop(ModBlocks.RUBY_BLOCK);
    addDrop(ModBlocks.RAW_RUBY_BLOCK);
    addDrop(ModBlocks.SOUND_BLOCK);

    addDrop(ModBlocks.RUBY_ORE, rubyOreDrops(ModBlocks.RUBY_ORE));
    addDrop(ModBlocks.DEEPSLATE_RUBY_ORE, rubyOreDrops(ModBlocks.DEEPSLATE_RUBY_ORE));
    addDrop(ModBlocks.NETHER_RUBY_ORE, rubyOreDrops(ModBlocks.NETHER_RUBY_ORE));
    addDrop(ModBlocks.END_STONE_RUBY_ORE, rubyOreDrops(ModBlocks.END_STONE_RUBY_ORE));
  }

  public LootTable.Builder rubyOreDrops(Block drop) {
    float minDrops = 0;
    float maxDrops = 0;
    if (drop.equals(ModBlocks.RUBY_ORE)) {
      minDrops = 1;
      maxDrops = 4;
    } else if (drop.equals(ModBlocks.DEEPSLATE_RUBY_ORE)) {
      minDrops = 1;
      maxDrops = 4;
    } else if (drop.equals(ModBlocks.NETHER_RUBY_ORE)) {
    minDrops = 1;
    maxDrops = 3;
  } else if (drop.equals(ModBlocks.END_STONE_RUBY_ORE)) {
    minDrops = 4;
    maxDrops = 8;
  }

    return dropsWithSilkTouch(
        drop,
        (LootPoolEntry.Builder<?>)this.applyExplosionDecay(
            drop,
            ItemEntry.builder(ModItems.RAW_RUBY)
                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(minDrops, maxDrops)))
                .apply(ApplyBonusLootFunction.oreDrops(Enchantments.FORTUNE))
        )
    );
  }

}