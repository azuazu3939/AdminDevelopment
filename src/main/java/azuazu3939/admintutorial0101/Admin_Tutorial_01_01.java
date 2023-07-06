package azuazu3939.admintutorial0101;

import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

public final class Admin_Tutorial_01_01 extends JavaPlugin implements Listener {

    /*
    始めに。

    Admin_Tutorialシリーズは基礎的な実装をテンプレで乗っけていきます。

    Admin_Tutorial_01_01 の始めの01はリスナーイベントのみになります。
    2個めの01はその実装タイプのテンプレ一回目です。

    始めの01はやることが増えると数字が変わります。
     */
    @Override
    public void onEnable() {
        // Plugin startup logic

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    /*
    今回はJavaPluginを拡張しているメインのクラスに
    リスナーを実装していきます。

    初歩としては書きやすく最適ですが、大きいPluginを書いていくとクラスを分けたほうがいいとされています。
     */

    //@EventHandler、これがリスナーイベントだよと設計図にメモを入れた状態となります。
    @EventHandler
    public void onJoin(@NotNull PlayerJoinEvent e) {

        //onJoin(~~~~)のonJoinはメソッド名です。他人がメソッド名だけ見てわかるように書くことを意識すると〇
        Player p = e.getPlayer();
        p.sendMessage(Component.text("完了"));

        //内容は、プレイヤーがサーバーに入ったらメッセージを送ります。それだけ。

        /////////////////////////////////////////////////////////////////
        //ここからはおまけになります。

        p.getInventory().addItem(new ItemStack(Material.DIAMOND, 1));

        //左から見ていきましょう。
        //プレイヤーのインベントリをgetし、addItemつまりなにかをプレイヤーのインベントリに追加する処理ですね。
        //addItem(?)の?は新しくダイヤモンドを1個作った状態です。それをそのまま?にぶち込んでるだけです。

        //new ItemStack(Material.CHEST, 64);
        //ちなみに↑の新しく別のクラスからメソッドを使いたいときは staticをいれてない場合は、
        // new クラス名().メソッド名(); となります。細かくすると()の中に色々入れる場合もあります。

    }
}
