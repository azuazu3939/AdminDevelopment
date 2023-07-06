package azuazu3939.admin_tutorial_02_01;

import net.kyori.adventure.text.Component;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public final class Admin_Tutorial_02_01 extends JavaPlugin implements CommandExecutor {

    //Admin_Tutorial_02シリーズはコマンドです。
    @Override
    public void onEnable() {
        // Plugin startup logic
        Objects.requireNonNull(getCommand("test")).setExecutor(this);
        //JavaPluginを拡張しているメインのクラスにCommandExecutorを実装した場合は、短く書くと上のようになります。

        //注意コマンドはplugin.ymlにも登録する必要があります。 resourceフォルダーにもgetCommand("?")の?と
        //同じコマンドが登録されているか確認しましょう。

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, String[] strings) {

        if (sender instanceof Player) {
            Player p  = (Player) sender;
            p.sendMessage(Component.text("やっほ"));
        } else {
            sender.sendMessage(Component.text("やっほーー"));
        }
        return true;
    }
}
