package avalon.net.lobby.utils;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class ItemBuilder extends ItemStack {
    public ItemBuilder(Material material) {
        super(material);
    }
    public ItemBuilder(Material material, Integer amount) {
        super(material, amount);
    }
    public ItemBuilder(Material material, Integer amount, Short subid) {
        super(material, amount, subid);
    }
    public void setName(String name) {
        getItemMeta().setDisplayName(name);
    }
}
