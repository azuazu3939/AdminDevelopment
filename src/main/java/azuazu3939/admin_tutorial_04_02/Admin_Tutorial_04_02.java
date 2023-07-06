package azuazu3939.admin_tutorial_04_02;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class Admin_Tutorial_04_02 extends JavaPlugin {


    @Override
    public void onEnable() {
        // Plugin startup logic
        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new InventoryListener(this), this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
