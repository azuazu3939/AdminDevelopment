package azuazu3939.admin_tutorial_03_01;

import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.HashSet;
import java.util.Set;

public class CanBreakCommand implements CommandExecutor {

    public static final Set<Player> canBreakSet = new HashSet<>();
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {

        if (commandSender instanceof Player) {

            Player p = (Player) commandSender;
            if (p.hasPermission("tutorial.command.canBreak")) {
                canBreakSet.add(p);
                p.sendMessage(LegacyComponentSerializer.legacyAmpersand().deserialize("&a&lブロックの破壊が可能になりました！"));
            } else {
                p.sendMessage(LegacyComponentSerializer.legacyAmpersand().deserialize("&c&l権限がありません。"));
                //LegacyComponentSerializer.legacyAmpersand()はカラーコード付けれるコードの一つです。
                //Paperじゃないとできないはず…
            }
        }
        return true;
    }
}
