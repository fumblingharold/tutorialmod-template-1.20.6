package net.fumblingharold.tutorialmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.fumblingharold.tutorialmod.block.ModBlocks;
import net.fumblingharold.tutorialmod.item.ModItems;
import net.fumblingharold.tutorialmod.util.ModTags;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
  private static final List<ItemConvertible> RUBY_SMELTABLES = List.of(ModItems.RAW_RUBY,
      ModBlocks.RUBY_ORE, ModBlocks.DEEPSLATE_RUBY_ORE, ModBlocks.NETHER_RUBY_ORE,
      ModBlocks.END_STONE_RUBY_ORE);

  public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
    super(output, registriesFuture);
  }

  @Override
  public void generate(RecipeExporter exporter) {
    offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.RUBY,
        RecipeCategory.DECORATIONS, ModBlocks.RUBY_BLOCK);
    ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.RAW_RUBY, 1)
        .pattern("SSS")
        .pattern("SRS")
        .pattern("SSS")
        .input('S', Items.STONE)
        .input('R', ModItems.RUBY)
        .criterion(hasItem(Items.STONE), conditionsFromItem(Items.STONE))
        .criterion(hasItem(ModItems.RUBY), conditionsFromItem(ModItems.RUBY))
        .offerTo(exporter, new Identifier(getRecipeName(ModItems.RAW_RUBY)));


    offerSmelting(exporter, RUBY_SMELTABLES, RecipeCategory.MISC, ModItems.RUBY,
        .7f, 200, "ruby");
    offerBlasting(exporter, RUBY_SMELTABLES, RecipeCategory.MISC, ModItems.RUBY,
        .7f, 100, "ruby");
  }
}