package azuazu3939.admin_tutorial_02_02;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.jetbrains.annotations.NotNull;

public class TestCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {

        //色付けてます今回は。他にもあります方法は。
        if (commandSender instanceof Player) {

            Player p = (Player) commandSender;
            p.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, -1, 0, false, false, false));
            p.sendMessage(LegacyComponentSerializer.legacyAmpersand().deserialize("&b&l暗視を付与しました！。"));
        } else {
            commandSender.sendMessage(Component.text("プレイヤー専用コマンドです。").color(TextColor.color(19,174,212)));
        }
        return true;
    }
}
