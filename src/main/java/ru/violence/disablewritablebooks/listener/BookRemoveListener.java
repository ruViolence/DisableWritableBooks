package ru.violence.disablewritablebooks.listener;

import org.bukkit.Material;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ItemSpawnEvent;
import org.bukkit.event.inventory.InventoryCreativeEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class BookRemoveListener implements Listener {
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        if (!player.hasPermission("disablewritablebook.bypass")) {
            player.getInventory().remove(Material.WRITABLE_BOOK);
        }
    }

    @EventHandler(ignoreCancelled = true)
    public void onInventoryOpen(InventoryOpenEvent event) {
        HumanEntity player = event.getPlayer();
        if (!player.hasPermission("disablewritablebook.bypass")) {
            event.getInventory().remove(Material.WRITABLE_BOOK);
        }
    }

    @EventHandler(ignoreCancelled = true)
    public void onItemSpawn(ItemSpawnEvent event) {
        Item item = event.getEntity();
        if (item.getItemStack().getType() == Material.WRITABLE_BOOK) {
            item.remove();
        }
    }

    @EventHandler(ignoreCancelled = true)
    public void onCreative(InventoryCreativeEvent event) {
        HumanEntity player = event.getWhoClicked();
        if (!player.hasPermission("disablewritablebook.bypass")) {
            if (event.getCursor().getType() == Material.WRITABLE_BOOK) {
                event.setCancelled(true);
            }
        }
    }
}
