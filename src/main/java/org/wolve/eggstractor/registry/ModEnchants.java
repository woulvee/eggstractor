package org.wolve.eggstractor.registry;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import net.minecraft.registry.Registry;
import org.wolve.eggstractor.EggstractorEnchantment;
import org.wolve.eggstractor.enchant.Eggstracting;

public class ModEnchants {

    public static Enchantment EGGSTRACT = new Eggstracting();
    public static void registerEnchantments() {
        Registry.register(Registries.ENCHANTMENT, new Identifier(EggstractorEnchantment.MOD_ID, "eggstracting"), EGGSTRACT);
    }

}
