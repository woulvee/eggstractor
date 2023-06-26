package org.wolve.eggstractor;

import net.fabricmc.api.ModInitializer;
import org.wolve.eggstractor.registry.ModEnchants;

public class EggstractorEnchantment implements ModInitializer {

    public static final String MOD_ID = "eggstractor";

    @Override
    public void onInitialize(){
        ModEnchants.registerEnchantments();
    }
}
