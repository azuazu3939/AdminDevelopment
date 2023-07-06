package azuazu3939.admin_tutorial_01_02;

import net.kyori.adventure.text.Component;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.jetbrains.annotations.NotNull;

public class AdminTestListener implements Listener {

    @EventHandler
    public void onRespawn(@NotNull PlayerRespawnEvent e) {

        Player p = e.getPlayer();
        p.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, -1, 0, false, false, false));
        p.sendMessage(Component.text("暗視を付与しました!"));
        //リスポーンしたら暗視付与。
    }

    @EventHandler
    public void onJoin(@NotNull PlayerJoinEvent e) {

        Player p = e.getPlayer();
        p.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, -1, 0, false, false, false));
        p.sendMessage(Component.text("暗視を付与しました!"));
        //サーバーに参加したら暗視付与。
    }
}
