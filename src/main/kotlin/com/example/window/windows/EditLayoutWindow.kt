package com.example.window.windows

import com.example.guitextures.GuiItems
import com.example.guitextures.GuiTextures
import com.example.window.AlternativeWindow
import org.bukkit.ChatColor.stripColor
import xyz.xenondevs.invui.gui.Gui
import xyz.xenondevs.invui.item.Item
import xyz.xenondevs.invui.window.Window
import xyz.xenondevs.nova.world.item.DefaultGuiItems

class EditLayoutWindow : AlternativeWindow() {
    override fun createWindow(): Window.Builder.Normal.Split {
        window = Window.split()
            .setTitle(GuiTextures.EDIT_LAYOUT_WINDOW.component)
            .setUpperGui(createUpperGui())
            .setLowerGui(createLowerGui())

        return window!!
    }

    override fun createUpperGui(): Gui.Builder<*, *> {

        upperGui = Gui.normal()
            .setStructure(
                arrayListOf(
                    ". . . . . . . . .",
                    ". . . . . . . . .",
                    ". . . . . . . . .",
                    "j j j j j j j j j",
                    ". . . . . . . . .",
                    "s d h f b i . a o",
                )
            )
            .addIngredient('j', GuiItems.NOT_CLICKABLE.createItemBuilder()
                .addLoreLines(menu?.getItem(35)?.lore() ?: emptyList()), 35
            )
            .addIngredient('h', GuiItems.NOT_CLICKABLE.createItemBuilder(), 35)
            .addIngredient('d', GuiItems.DELETE_LAYOUT.createItemBuilder()
                .addLoreLines(menu?.getItem(48)?.lore() ?: emptyList()), 48
            )
            .addIngredient('s', GuiItems.SAVE_LAYOUT.createItemBuilder()
                .addLoreLines(menu?.getItem(50)?.lore() ?: emptyList()), 50
            )
            .addIngredient('f', GuiItems.APPLY_LAYOUT.createItemBuilder()
                .addLoreLines(menu?.getItem(52)?.lore() ?: emptyList()), 52
            )
            .addIngredient('b', GuiItems.BACK.createItemBuilder()
                .addLoreLines(menu?.getItem(49)?.lore() ?: emptyList()), 49
            )
            .addIngredient('i', GuiItems.IMPORT_LAYOUT.createItemBuilder()
                .addLoreLines(menu?.getItem(53)?.lore() ?: emptyList()), 53
            )
            .addIngredient('a', GuiItems.ARMOR_LAYOUT.createItemBuilder()
                .addLoreLines(menu?.getItem(47)?.lore() ?: emptyList()), 47
            )
            .addIngredient('o', GuiItems.OFFHAND_LAYOUT.createItemBuilder()
                .addLoreLines(menu?.getItem(46)?.lore() ?: emptyList()), 46
            )

        return upperGui!!
    }
    override fun createLowerGui(): Gui.Builder<*, *> {
        lowerGui = Gui.normal()
            .setStructure(
                arrayListOf(
                    ". . . . . . . . .",
                    ". . . . . . . . .",
                    ". . . . . . . . .",
                    ". . . . . . . . .",
                )
            )
        return lowerGui!!
    }
}