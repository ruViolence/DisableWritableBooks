package ru.violence.disablewritablebooks;

import org.bukkit.NamespacedKey;
import org.bukkit.plugin.java.JavaPlugin;
import ru.violence.disablewritablebooks.listener.BookRemoveListener;

public final class Main extends JavaPlugin {
    @Override
    public void onEnable() {
        getServer().removeRecipe(NamespacedKey.minecraft("writable_book"));
        getServer().getPluginManager().registerEvents(new BookRemoveListener(), this);
    }
}
