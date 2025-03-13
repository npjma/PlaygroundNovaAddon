package com.example.window.windows

import com.example.guitextures.GuiItems
import com.example.guitextures.GuiTextures
import com.example.window.AlternativeWindow
import org.bukkit.ChatColor.stripColor
import xyz.xenondevs.invui.gui.Gui
import xyz.xenondevs.invui.item.Item
import xyz.xenondevs.invui.window.Window
import xyz.xenondevs.nova.world.item.DefaultGuiItems

class PlaygroundWindow : AlternativeWindow() {
    override fun createWindow(): Window.Builder.Normal.Split {
        window = Window.split()
            .setTitle(GuiTextures.PLAYGROUND_WINDOW.component)
            .setUpperGui(createUpperGui())
            .setLowerGui(createLowerGui())

        return window!!
    }

    override fun createUpperGui(): Gui.Builder<*, *> {
        upperGui = Gui.normal()
            .setStructure(
                arrayListOf(
                    ". . . . . . . . .",
                    ". . . h i c . . .",
                    ". . . s s s . . .",
                    ". . . g e p . . .",
                    ". . . . . . . . ."
                )
            )
            .addIngredient('h', GuiItems.HEADS.createItemBuilder(), 20)
            .addIngredient('i', GuiItems.ITEMS.createItemBuilder(), 23)
            .addIngredient('c', GuiItems.CUSTOM_ITEMS.createItemBuilder(), 24)
            .addIngredient(
                's', GuiItems.SYSTEMS.createItemBuilder()
                    .addLoreLines(menu?.getItem(22)?.lore() ?: emptyList()), 22
            )
            .addIngredient('g', GuiItems.GROUPS.createItemBuilder(), 13)
            .addIngredient('e', GuiItems.SETTINGS.createItemBuilder(), 21)
            .addIngredient('p', GuiItems.PROTOOLS.createItemBuilder(), 33)


        return upperGui!!
    }

    override fun createLowerGui(): Gui.Builder<*, *> {
        lowerGui = Gui.normal()
            .setStructure(
                arrayListOf(
                    ". . . . . . . . .",
                    ". . . u f f . . .",
                    ". . . t b l . . .",
                    ". . . . . . . . .",
                )
            )
            .addIngredient('t', GuiItems.BROWSER.createItemBuilder(), 36)
            .addIngredient('b', GuiItems.BUILD_MODE.createItemBuilder(), 45)
            .addIngredient('l', GuiItems.PLAYER_LISTING.createItemBuilder(), 8)
        menu?.getItem(0)?.lore?.let { lore ->
            if (lore.any { stripColor(it) == "Current Privacy: PUBLIC" }) {
                lowerGui!!.addIngredient('u', GuiItems.VISIBILITY_PUBLIC.createItemBuilder(), 0)
                lowerGui!!.addIngredient('f', GuiItems.VISIBILITY_PUBLIC_EMPTY.createItemBuilder(), 0)
            } else if (lore.any { stripColor(it) == "Current Privacy: PRIVATE" }) {
                lowerGui!!.addIngredient('u', GuiItems.VISIBILITY_PRIVATE.createItemBuilder(), 0)
                lowerGui!!.addIngredient('f', GuiItems.VISIBILITY_PRIVATE_EMPTY.createItemBuilder(), 0)
            } else {
                lowerGui!!.addIngredient('u', GuiItems.VISIBILITY_PUBLIC_EMPTY.createItemBuilder(), 0)
                lowerGui!!.addIngredient('f', GuiItems.VISIBILITY_PUBLIC_EMPTY.createItemBuilder(), 0)
            }
        }
        return lowerGui!!
    }
}