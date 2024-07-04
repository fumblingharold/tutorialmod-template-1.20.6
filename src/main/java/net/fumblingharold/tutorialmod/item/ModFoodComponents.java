package net.fumblingharold.tutorialmod.item;

import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

public class ModFoodComponents {
  public static final FoodComponent TOMATO = new FoodComponent.Builder()
      .nutrition(3)
      .saturationModifier(.25f)
      .statusEffect(
          new StatusEffectInstance(StatusEffects.LUCK, 200), .25f).build();
}