package azuazu3939.admin_tutorial_01_02;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class Admin_Tutorial_01_02 extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        //今回はクラスを分けていきます。
        //PluginManager pm = ~~~としたのは、省略です。
        //大きいPluginを作る場合は、pm.registerEv....というあテンプレがいくつも続きます。長いね。

        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new AdminTestListener(), this);
        //registerEvents(new 新しくクラス名(), JavaPluginを継承したクラスを書きます);
        //JavaPluginを継承したクラスはこのクラスのため、thisと書くことができます。

        pm.registerEvents(new AdminTestListener2(), getProvidingPlugin(Admin_Tutorial_01_02.class));
        //多分こういうのもできるけど、長い！！thisは使えるならそうしよう!!
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
