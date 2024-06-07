package net.nishenko.modpt.block;


import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.nishenko.modpt.ModPt;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.nishenko.modpt.item.ModItems;

import java.util.function.Supplier;



public class ModBlock {

    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, ModPt.MOD_ID);


    public static final RegistryObject<Block> MANGAL = registryBlock("mangal_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.AMETHYST)
                    .strength(3f).instabreak().randomTicks().noCollission().
                    noOcclusion().sound(SoundType.AMETHYST)),CreativeModeTab.TAB_MISC);

    public static final RegistryObject<Block> VEDRO_KLUB = registryBlock("vedro_klub",
            () -> new Block(BlockBehaviour.Properties.of(Material.DECORATION).strength(3f).instabreak()
                    .randomTicks().noOcclusion().sound(SoundType.AMETHYST)),CreativeModeTab.TAB_MISC);


    public static final RegistryObject<Block> DROVA = registryBlock("drova",
            () -> new Block(BlockBehaviour.Properties.of(Material.DECORATION).strength(3f).instabreak()
                    .randomTicks().noOcclusion().sound(SoundType.STONE)),CreativeModeTab.TAB_MISC);

    public static final RegistryObject<Block> STOL = registryBlock("stol",
            () -> new Block(BlockBehaviour.Properties.of(Material.DECORATION).strength(3f).instabreak()
                    .randomTicks().noOcclusion().sound(SoundType.STONE)),CreativeModeTab.TAB_MISC);




    public  static  <T extends Block>RegistryObject<T> registryBlock(String name, Supplier<T> block, CreativeModeTab tab){
        RegistryObject<T> toReturns = BLOCKS.register(name, block);
        registryBlockItem(name, toReturns, tab);
        return toReturns;
        

    }

    private static <T extends Block> RegistryObject<BlockItem> registryBlockItem(String name, RegistryObject<T> block, CreativeModeTab tab) {

        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
    }

    public  static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);

    }


}
