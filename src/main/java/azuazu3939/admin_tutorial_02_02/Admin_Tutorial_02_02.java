package azuazu3939.admin_tutorial_02_02;

import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class Admin_Tutorial_02_02 extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        Objects.requireNonNull(getCommand("test2")).setExecutor(new TestCommand());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
