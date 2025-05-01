package de.gorkensal.init;

import de.gorkensal.Tsetmod;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class CustomItemGroup {

    // Register the item group with mod id and to say it is a item group
    public static final RegistryKey<ItemGroup> CUSTOM_ITEM_GROUP_KEY = RegistryKey.of(
            Registries.ITEM_GROUP.getKey(), Identifier.of(Tsetmod.MOD_ID, "item_group"));
    // building the item groups name and icon
    public static final ItemGroup CUSTOM_ITEM_GROUP = FabricItemGroup.builder()
            .icon(() -> new ItemStack(ModItems.SUSPICIOUS_SUBSTANCE))
            .displayName(Text.translatable("itemGroup.tsetmod"))
            .build();
    // to register the item gorup in the main
    public static void registerItemGroup() {
        Registry.register(Registries.ITEM_GROUP, CUSTOM_ITEM_GROUP_KEY, CUSTOM_ITEM_GROUP);
        // event to add item to the item group
        ItemGroupEvents.modifyEntriesEvent(CUSTOM_ITEM_GROUP_KEY).register(entries -> {
            entries.add(ModItems.SUSPICIOUS_SUBSTANCE);
            entries.add(ModBlocks.MORITZ_DIRT);
        });
    }
}
