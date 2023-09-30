package avalon.net.lobby.utils;

import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;

public class InventoryBuilder {
    private Inventory inv;
    public InventoryBuilder(String name, int rows) {
        this.inv = Bukkit.createInventory(null, rows*9, name);
    }
    public Inventory build() {
        return this.inv;
    }
}
