package org.wolve.eggstractor.mixins;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SpawnEggItem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.wolve.eggstractor.registry.ModEnchants;

import java.io.Console;
import java.util.Objects;
import java.util.Random;

@Mixin(LivingEntity.class)
public class EggstractingMixin {

    @Inject(at = @At("HEAD"), method = "onDeath")
    public void eggKill(DamageSource source, CallbackInfo callbackInfo) {
        if (!(source.getAttacker() instanceof PlayerEntity)) return;
        LivingEntity user = (LivingEntity) source.getAttacker();
        LivingEntity target = (LivingEntity) (Object) this;

        if (user != null && EnchantmentHelper.getLevel(ModEnchants.EGGSTRACT, user.getMainHandStack()) > 0 && !user.getWorld().isClient()) {
            Random r = new Random();
            float n = r.nextFloat()*100;
            System.out.println("Random Value: " + n);
            if(EnchantmentHelper.getLevel(ModEnchants.EGGSTRACT, user.getMainHandStack()) >= 4){
                ItemStack egg = new ItemStack(Objects.requireNonNull(SpawnEggItem.forEntity(target.getType())), 1);
                target.dropStack(egg);
            } else if(n <= (float) EnchantmentHelper.getLevel(ModEnchants.EGGSTRACT, user.getMainHandStack())*0.5)
            {
                ItemStack egg = new ItemStack(Objects.requireNonNull(SpawnEggItem.forEntity(target.getType())), 1);
                target.dropStack(egg);
            }
        }
    }
}
