package azuazu3939.admin_tutorial_01_02;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.jetbrains.annotations.NotNull;

public class AdminTestListener2 implements Listener {

    @EventHandler
    public void onBlockBreak(@NotNull BlockBreakEvent e) {

        Player p = e.getPlayer();
        if (p.getGameMode().equals(GameMode.CREATIVE)) return;
        e.setCancelled(true);

        //これはクリエ以外プレイヤーは壊せない仕組みです。
        //なぜクリエ以外なの？？　-> クリエだった場合はreturn;…つまりそこで処理は中断されています。
        //キャンセルの処理まで到達しないからですね。
    }
}
