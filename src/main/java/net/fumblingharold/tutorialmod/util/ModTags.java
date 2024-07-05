package net.fumblingharold.tutorialmod.util;

import net.fumblingharold.tutorialmod.TutorialMod;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModTags {
  public static class Blocks {

    public static final TagKey<Block> METAL_DETECTOR_DETECTABLE_BLOCKS =
        createTag("metal_detector_detectable_blocks");

    public static final TagKey<Block> RUBY_ORES = createTag("ruby_ores");

    public static final TagKey<Block> NEEDS_NETHERITE_TOOL = createTag("needs_netherite_tool");

    private static TagKey<Block> createTag(String name) {
      return TagKey.of(RegistryKeys.BLOCK, new Identifier(TutorialMod.MOD_ID, name));
    }
  }

  public static class Items {

    private static TagKey<Item> createTag(String name) {
      return TagKey.of(RegistryKeys.ITEM, new Identifier(TutorialMod.MOD_ID, name));
    }

  }

}