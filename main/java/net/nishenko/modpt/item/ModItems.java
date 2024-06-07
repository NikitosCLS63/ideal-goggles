package net.nishenko.modpt.item;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.nishenko.modpt.ModPt;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import java.util.Random;

import static net.minecraft.world.item.Tiers.STONE;

public abstract class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, ModPt.MOD_ID);


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);

    }

    public static final RegistryObject<Item> FISH = ITEMS.register("fish",
            () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));


    public static final RegistryObject<Item> SHAHLIK = ITEMS.register("shahlik",
            () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC)
                    .food(new FoodProperties.Builder().saturationMod(6).saturationMod(0.8f).build())));


    public static final RegistryObject<Item> VODKA = ITEMS.register("vodka",
            () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC).food(new FoodProperties.Builder().
                    saturationMod(2).saturationMod(0.2f)
                        .effect(() -> {
                            Random random = new Random();
                            if (random.nextFloat() < 0.65f) { // 75% вероятность
                            return new MobEffectInstance(MobEffects.CONFUSION, 200, 1);
                                } else {
                            return null; // Нет эффекта
                            }
                        }, 1.0f).build())));


    public  static  final RegistryObject<Item> GRABLI  = ITEMS.register("grabli",
            () ->  new ShearsItem((new Item.Properties()).
                durability(238).tab(CreativeModeTab.TAB_MISC)));

    public  static final RegistryObject<Item> SHAMPUR = ITEMS.register("shampur", () ->
            new SwordItem(STONE, 555, -0.4F,
                (new Item.Properties()).tab(CreativeModeTab.TAB_MISC)));

}


    //public  static  final Item.Properties TOOL_MATERIAL_GRABLI = .addToolMaterial("grabli", )
    //public static final RegistryObject<Item> GRABLI = DeferredRegister.create("Grabli",
        //    () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_TOOLS).durability(100)));





