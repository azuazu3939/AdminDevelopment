package azuazu3939.admin_tutorial_03_01;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class Admin_Tutorial_03_01 extends JavaPlugin {

    /*
    さて、03はシリーズはコマンドとリスナーイベントの複合です。
    少し実践敵なります。
    また今回からは権限を使って使える人縛っていきます。
     */
    @Override
    public void onEnable() {
        // Plugin startup logic
        Objects.requireNonNull(getCommand("canBreak")).setExecutor(new CanBreakCommand());
        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new BreakBlockListener(), this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
