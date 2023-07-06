package azuazu3939.admin_tutorial_03_01;

import net.kyori.adventure.text.Component;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.jetbrains.annotations.NotNull;

import static azuazu3939.admin_tutorial_03_01.CanBreakCommand.canBreakSet;

public class BreakBlockListener implements Listener {

    @EventHandler
    public void onBreakBlock(@NotNull BlockBreakEvent e) {

        Player p = e.getPlayer();
        if (!p.hasPermission("tutorial.command.canBreak")) {
            p.sendMessage(Component.text("ぽまえ権限がないやろ"));
            e.setCancelled(true);

        } else if (!canBreakSet.contains(p)) {
            p.sendMessage(Component.text("ぽまえはコマンド実行してもろて"));
            e.setCancelled(true);

        } else {
            p.sendMessage(Component.text("ﾖｼログうるさいね！！"));
        }
    }
}
