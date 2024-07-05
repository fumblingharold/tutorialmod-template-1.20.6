package net.fumblingharold.tutorialmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.fumblingharold.tutorialmod.TutorialMod;
import net.fumblingharold.tutorialmod.block.ModBlocks;
import net.fumblingharold.tutorialmod.util.ModTags;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
  public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
    super(output, registriesFuture);
  }

  @Override
  protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
    getOrCreateTagBuilder(ModTags.Blocks.RUBY_ORES)
        .add(ModBlocks.RUBY_ORE)
        .add(ModBlocks.DEEPSLATE_RUBY_ORE)
        .add(ModBlocks.NETHER_RUBY_ORE)
        .add(ModBlocks.END_STONE_RUBY_ORE);

    getOrCreateTagBuilder(ModTags.Blocks.METAL_DETECTOR_DETECTABLE_BLOCKS)
        .forceAddTag(ModTags.Blocks.RUBY_ORES)
        .forceAddTag(BlockTags.COAL_ORES)
        .forceAddTag(BlockTags.COPPER_ORES)
        .forceAddTag(BlockTags.IRON_ORES)
        .forceAddTag(BlockTags.GOLD_ORES)
        .forceAddTag(BlockTags.LAPIS_ORES)
        .forceAddTag(BlockTags.REDSTONE_ORES)
        .forceAddTag(BlockTags.DIAMOND_ORES)
        .forceAddTag(BlockTags.EMERALD_ORES);

    getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
        .addTag(ModTags.Blocks.RUBY_ORES)
        .add(ModBlocks.RUBY_BLOCK)
        .add(ModBlocks.RAW_RUBY_BLOCK)
        .add(ModBlocks.SOUND_BLOCK);

    getOrCreateTagBuilder(BlockTags.NEEDS_STONE_TOOL)
        .add(ModBlocks.RUBY_BLOCK)
        .add(ModBlocks.NETHER_RUBY_ORE);

    getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
        .add(ModBlocks.RUBY_BLOCK)
        .add(ModBlocks.RUBY_ORE);

    getOrCreateTagBuilder(BlockTags.NEEDS_DIAMOND_TOOL)
      .add(ModBlocks.DEEPSLATE_RUBY_ORE);

    getOrCreateTagBuilder(ModTags.Blocks.NEEDS_NETHERITE_TOOL)
        .add(ModBlocks.END_STONE_RUBY_ORE);

    getOrCreateTagBuilder(BlockTags.INCORRECT_FOR_WOODEN_TOOL)
        .addTag(ModTags.Blocks.NEEDS_NETHERITE_TOOL);
    getOrCreateTagBuilder(BlockTags.INCORRECT_FOR_STONE_TOOL)
        .addTag(ModTags.Blocks.NEEDS_NETHERITE_TOOL);
    getOrCreateTagBuilder(BlockTags.INCORRECT_FOR_GOLD_TOOL)
        .addTag(ModTags.Blocks.NEEDS_NETHERITE_TOOL);
    getOrCreateTagBuilder(BlockTags.INCORRECT_FOR_IRON_TOOL)
        .addTag(ModTags.Blocks.NEEDS_NETHERITE_TOOL);
    getOrCreateTagBuilder(BlockTags.INCORRECT_FOR_DIAMOND_TOOL)
        .addTag(ModTags.Blocks.NEEDS_NETHERITE_TOOL);
  }
}