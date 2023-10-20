package org.gillinet.evermight;

import org.gillinet.evermight.items.EItems;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ECreativeTab {
    // Create a Deferred Register to hold CreativeModeTabs which will all be registered under the "evermight" namespace
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Evermight.MODID);

    // Creates a creative tab with the id "evermight:Evermight" for the example item, that is placed after the combat tab
    public static final RegistryObject<CreativeModeTab> EVERMIGHT_TAB = CREATIVE_MODE_TABS.register("evermight_tab", () -> CreativeModeTab.builder()
            .withTabsBefore(CreativeModeTabs.COMBAT)
            .title(Component.translatable("Evermight"))
            .icon(() -> EItems.EXAMPLE_ITEM.get().getDefaultInstance())
            .displayItems((parameters, output) -> {
                output.accept(EItems.EXAMPLE_ITEM.get()); // Add the example item to the tab. For your own tabs, this method is preferred over the event
                output.accept(EItems.EVERMIGHT_SWORD.get());
            }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
