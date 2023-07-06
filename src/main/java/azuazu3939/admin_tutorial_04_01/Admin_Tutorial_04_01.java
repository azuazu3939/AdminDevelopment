package azuazu3939.admin_tutorial_04_01;

import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class Admin_Tutorial_04_01 extends JavaPlugin {

    /*
    基礎編は終了です。ここからは応用的で実践的なコードをべたべた張っていきます。
    コード量は抑える上に、解説もできる限り入れていきます。
     */
    @Override
    public void onEnable() {
        // Plugin startup logic
        PluginManager pm = Bukkit.getPluginManager();
        //InventoryListener()ではなく、InventoryListener(this)になります。(?)にこのクラスの情報を流し込んでるかんじ？？
        pm.registerEvents(new InventoryListener(this), this);

        //これは正直、forEachで調べたほうがわかりやすいです。
        Bukkit.getOnlinePlayers().forEach(player -> player.sendMessage(LegacyComponentSerializer.legacyAmpersand().deserialize("&6はろ～")));

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
