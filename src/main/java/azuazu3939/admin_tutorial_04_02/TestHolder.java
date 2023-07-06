package azuazu3939.admin_tutorial_04_02;

import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.jetbrains.annotations.NotNull;

public class TestHolder implements InventoryHolder {

    //インベントリホルダーを実装し使用すると、インベントリの識別が異常に簡単になるため、おすすめ。
    @Override
    public @NotNull Inventory getInventory() {
        return Bukkit.createInventory(this, 54, Component.text("あほ"));
    }
}
