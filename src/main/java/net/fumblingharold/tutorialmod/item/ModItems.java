package net.fumblingharold.tutorialmod.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fumblingharold.tutorialmod.TutorialMod;
import net.fumblingharold.tutorialmod.item.custom.MetalDetectorItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

  public static final Item RUBY = registerItem("ruby", new Item(new Item.Settings()));
  public static final Item RAW_RUBY = registerItem("raw_ruby", new Item(new Item.Settings()));
  public static final Item TOMATO = registerItem("tomato", new Item(
      new Item.Settings().food(ModFoodComponents.TOMATO)));
  public static final Item COAL_BRIQUETTE = registerItem("coal_briquette", new Item(
      new Item.Settings()));

  public static final Item METAL_DETECTOR = registerItem("metal_detector",
      new MetalDetectorItem(new Item.Settings().maxDamage(64)));

  public static void addItemsToIngredientsItemGroup(FabricItemGroupEntries entries) {
    entries.add(RUBY);
    entries.add(RAW_RUBY);
  }

  private static Item registerItem (String name, Item item) {
    return Registry.register(Registries.ITEM, new Identifier(TutorialMod.MOD_ID, name), item);
  }

  public static void registerModItems() {
    TutorialMod.LOGGER.info("Registering Mod Items for " + TutorialMod.MOD_ID);

    ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientsItemGroup);
  }

}