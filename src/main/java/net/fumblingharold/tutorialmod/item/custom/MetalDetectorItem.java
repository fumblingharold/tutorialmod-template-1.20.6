package net.fumblingharold.tutorialmod.item.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.item.TooltipType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.List;

public class MetalDetectorItem extends Item {

  public MetalDetectorItem(Settings settings) {
    super(settings);
  }

  @Override
  public ActionResult useOnBlock(ItemUsageContext context) {
    if (!context.getWorld().isClient()) {
      BlockPos positionClicked = context.getBlockPos();
      PlayerEntity player = context.getPlayer();
      boolean foundBlock = false;

      for (int y = positionClicked.getY(); y > -64; --y) {
        BlockState state = context.getWorld().getBlockState(positionClicked.withY(y));
        if (isValuableBlock(state)) {
          outputValuableCoords(positionClicked.getY() - y, player, state.getBlock());
          foundBlock = true;
          break;
        }
      }

      if (!foundBlock)
        player.sendMessage(Text.literal("No valuables found"), false);
    }

    context.getStack().damage(1, context.getPlayer(),
        EquipmentSlot.MAINHAND);

    return ActionResult.SUCCESS;
  }

  private static boolean isValuableBlock(BlockState state) {
    return state.isOf(Blocks.IRON_ORE) || state.isOf(Blocks.DIAMOND_ORE);
  }

  private static void outputValuableCoords(int depth, PlayerEntity player, Block block) {
    player.sendMessage(Text.literal("Found " + block.asItem() + ' ' + depth + " blocks deep"), false);
  }

  @Override
  public void appendTooltip(ItemStack stack, Item.TooltipContext context, List<Text> tooltip, TooltipType type) {
    tooltip.add(Text.translatable("tooltip.tutorialmod.metal_detector.tooltip"));
  }

}