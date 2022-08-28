package robaertschi.minetech.block

import net.minecraft.world.item.BlockItem
import net.minecraft.world.item.CreativeModeTab
import net.minecraft.world.item.Item
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.block.state.BlockBehaviour
import net.minecraft.world.level.material.Material
import net.minecraftforge.registries.DeferredRegister
import net.minecraftforge.registries.ForgeRegistries
import robaertschi.minetech.Minetech
import robaertschi.minetech.item.ModItems
import thedarkcolour.kotlinforforge.forge.registerObject

@Suppress
object ModBlocks {
    val REGISTRY: DeferredRegister<Block> = DeferredRegister.create(ForgeRegistries.BLOCKS, Minetech.ID)

    // the returned ObjectHolderDelegate can be used as a property delegate
    // this is automatically registered by the deferred registry at the correct times
    val EXAMPLE_BLOCK = registerBlock("example_block") {
        Block(BlockBehaviour.Properties.of(Material.METAL))
    }

    private fun registerBlock(name: String, supplier: () -> Block): Block {
        val toReturn by REGISTRY.registerObject(name) {
            supplier.invoke()
        }
        registerBlockItem(name, toReturn)
        return toReturn
    }

    private fun registerBlockItem(name: String, block: Block): Item {
        val item by ModItems.REGISTRY.registerObject(name) {
            BlockItem(block, Item.Properties().tab(CreativeModeTab.TAB_MISC))
        }
        return item
    }

}