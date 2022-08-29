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

/**
 * @since 0.1.0
 * This Object holds all Blocks of this Mod.
 */
@Suppress("MemberVisibilityCanBePrivate", "unused")
object ModBlocks {

    val REGISTRY: DeferredRegister<Block> = DeferredRegister.create(ForgeRegistries.BLOCKS, Minetech.ID)


    val EXAMPLE_BLOCK = registerBlock("example_block") {
        Block(BlockBehaviour.Properties.of(Material.METAL))
    }

    /**
     * @author RoBaertschi
     * @since 0.1.0
     * @param name The registration string.
     * @param supplier The Supplier which provides the Block.
     * @return The registered Block.
     */
    fun registerBlock(name: String, supplier: () -> Block): Block {
        val toReturn by REGISTRY.registerObject(name) {
            supplier.invoke()
        }
        registerBlockItem(name, toReturn)
        return toReturn
    }

    /**
     * @author RoBaertschi
     * @since 0.1.0
     * @param name The registration string.
     * @param block The block for which the BlockItem is registered.
     * @return Returns the BlockItem.
     */
    fun registerBlockItem(name: String, block: Block): BlockItem {
        val item by ModItems.REGISTRY.registerObject(name) {
            BlockItem(block, Item.Properties().tab(CreativeModeTab.TAB_MISC))
        }
        return item
    }

}