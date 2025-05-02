package de.gorkensal.init;

import de.gorkensal.Tsetmod;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public class ModItems {
    // Item creation
    public static final Item SUSPICIOUS_SUBSTANCE = register("suspicious_substance", Item::new, new Item.Settings());
    // TO initialize the class in the main

    //item metohde
    public static Item register(String name, Function<Item.Settings, Item> itemfactory, Item.Settings settings) {

        RegistryKey<Item> itemkey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Tsetmod.MOD_ID, name));

        Item item = itemfactory.apply(settings.registryKey(itemkey));

        Registry.register(Registries.ITEM, itemkey, item);

        return item;

    }
    public static void initialize() {
    }
}
