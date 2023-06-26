package org.wolve.eggstractor.enchant;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;

public class Eggstracting extends Enchantment {
    public Eggstracting(){
        super(Enchantment.Rarity.VERY_RARE, EnchantmentTarget.WEAPON, new EquipmentSlot[] {EquipmentSlot.MAINHAND});
    }

    @Override
    public int getMinPower(int level) {
        return 26+level*2;
    }

    @Override
    public int getMaxPower(int level) {
        return getMinPower(level)+20;
    }

    @Override
    public int getMaxLevel() {
        return 3;
    }

    @Override
    public boolean isAvailableForEnchantedBookOffer() {
        return false;
    }
}
