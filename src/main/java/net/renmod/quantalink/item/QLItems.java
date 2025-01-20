package net.renmod.quantalink.item;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.renmod.quantalink.Quantalink;
import net.renmod.quantalink.item.custom.LSCPItem;

public class QLItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Quantalink.MOD_ID);

    public static final RegistryObject<Item> EnderPearlDust = ITEMS.register("enderdust",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> HarmonicQuartz = ITEMS.register("harmonic_quartz",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> LSCP = ITEMS.register("lscp_gun",
            () -> new LSCPItem(new Item.Properties().stacksTo(1)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
