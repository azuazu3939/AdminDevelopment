package azuazu3939.admin_tutorial_04_01;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class InventoryListener implements Listener {

    private final Admin_Tutorial_04_01 main;
    public InventoryListener(Admin_Tutorial_04_01 main) {
        this.main = main;
        //コンストラクタというやつです。
        //別クラスのstaticでないフィールドとかを持ってくるために使います。
        //実践例ように使えます。
        //慣れてくるとこれ使っても使わなくてもこう書いてます。
    }

    @EventHandler
    public void onJoin(@NotNull PlayerJoinEvent e) {

        Player p = e.getPlayer();
        Bukkit.getScheduler().runTaskTimerAsynchronously(main, () -> {

            int level = 0;
            if (p.hasPotionEffect(PotionEffectType.SPEED))
                level+= Objects.requireNonNull(p.getPotionEffect(PotionEffectType.SPEED)).getAmplifier() + 1;

            if (level == 5) level = 0;

            p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, -1, level, false, false, false));
        }, 200L, 200L);

        /*
        なんじゃこりゃあ。。
        はい、サーバーに参加したら一定時間ごとに処理をするタイマー機能です。
        runTaskは同期で処理し、Asynchronouslyがつくと非同期(一般敵にいうなら軽く処理)です。
        Laterだと遅延して処理、そして今回使っているTimerは一定時間ごとに処理です。
        runTaskTimerAsynchronously(?, () -> {??}, 遅延, 間隔);

        ?の部分はどのプラグインによってタイマーが実行されているか、今回ならAdmin_Tutorial_04_01が実行しています。
        ??は処理です。普通に{}の中に書いていきましょう。

        遅延と間隔はtickごとに計算されています。つまり、これは10秒遅延してから、10秒間隔でタイマーします。

        ちなみにこれ何度もJoinすると何度も重複するのであんまり良くないコードだったり。
         */
    }
}
