package robaertschi.minetech.item

import net.minecraft.world.item.CreativeModeTab
import net.minecraft.world.item.Item
import net.minecraftforge.registries.DeferredRegister
import net.minecraftforge.registries.ForgeRegistries
import robaertschi.minetech.Minetech
import thedarkcolour.kotlinforforge.forge.registerObject

object ModItems {

    val REGISTRY: DeferredRegister<Item> = DeferredRegister.create(ForgeRegistries.ITEMS, Minetech.ID);

    val EXAMPLE_ITEM by REGISTRY.registerObject("example_item") {
        Item(Item.Properties().tab(CreativeModeTab.TAB_MISC))
    }


}