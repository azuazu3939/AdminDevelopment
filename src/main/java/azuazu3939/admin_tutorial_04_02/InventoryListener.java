package azuazu3939.admin_tutorial_04_02;

import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.block.Block;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class InventoryListener implements Listener {

    private final Admin_Tutorial_04_02 main;
    public InventoryListener(Admin_Tutorial_04_02 main) {
        this.main = main;
    }

    @EventHandler
    public void onInteract(@NotNull PlayerInteractEvent e) {

        Player p = e.getPlayer();
        Block b = e.getClickedBlock();

        if (b == null) return;
        //クリックしたブロックがエンドポータルframeなら…
        if (b.getType().equals(Material.END_PORTAL_FRAME)) {
            e.setCancelled(true);

            p.closeInventory();
            //closeを先にするのはバグ対策です。
            p.openInventory(new TestHolder().getInventory());
            //右クリをキャンセルして、インベントリを開く！
        }
    }

    @EventHandler
    public void onClose(@NotNull InventoryCloseEvent e) {

        //インベントリホルダーを実装するのはこの判別で用意に自分が弄りたいインベントリを特定できるため。
        Inventory inv = e.getInventory();
        if (inv.getHolder() instanceof TestHolder) {

            List<ItemStack> list = new ArrayList<>();
            HumanEntity p = e.getPlayer();

            for (ItemStack item : inv.getContents()) {

                //その閉じたInvを全てのスロット分checkします。
                if (item == null || !item.hasItemMeta()) continue;
                //もしそのスロットのアイテムが空もしくはアイテムの情報？が無かったらスキップ
                //つまりアイテムのデータがある場合はlistにアイテムのデータを入れ込みます。
                list.add(item);

                ItemMeta meta = item.getItemMeta();
                NamespacedKey key = new NamespacedKey(main, "test");

                if (meta.getPersistentDataContainer().has(key, PersistentDataType.STRING)) {
                    p.getInventory().addItem(item);
                }
            }
            //ここでfor {}のかっこが終わってる為ここからの処理はforがし終わった後の処理です。
            //つまりlistにはinvのアイテムがある場合は全て詰められています。
            Bukkit.broadcast(Component.text(list.toString()));
        }
    }

    @EventHandler
    public void onClick(@NotNull InventoryClickEvent e) {

        if (e.getInventory().getHolder() instanceof TestHolder) {

            ItemStack item = e.getCurrentItem();
            if (item != null && item.hasItemMeta()) {

                ItemMeta meta = item.getItemMeta();
                NamespacedKey key = new NamespacedKey(main, "test");
                meta.getPersistentDataContainer().set(key, PersistentDataType.STRING, "1");
                item.setItemMeta(meta);

                //ItemMeta はアイテムの内部データをつかさどる神様です（？）
                //データを保存するにも許可が必要です。

                //item.setItemMeta(meta);

                //じゃぁItemMetaならなんでもいいの？   いいえ

                //ItemMeta meta = item.getItemMeta();のメタで変更した値のみ保存で確定できます。

                //つまり、ItemMeta meta = item.getItemMeta();　と item.setItemMeta(meta);はセットです。
                //NamespacedKey key = new NamespacedKey(main, "test");　は戸籍と名前みたいな感じ(?)

                //戸籍は唯一無二で、 "test"のとこは被る場合もあるのでそこがかぶっても戸籍が違うなら別物だよ～てきな…
                //NamespacedKey要求されたjavaPlugin(戸籍)と任意の名前です。 説明がムズイ

            }
        }
    }
}
