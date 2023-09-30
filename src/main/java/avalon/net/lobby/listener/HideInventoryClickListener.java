package avalon.net.lobby.listener;

import avalon.net.lobby.Lobby;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class HideInventoryClickListener implements Listener {
    @EventHandler
    public void onInventoryClick(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();
        if(e.getView().getTitle().equals(ConnectionListener.hideItemName)) {
            e.setCancelled(true);
            if(e.getCurrentItem().getItemMeta().getDisplayName().equals(LobbyItemInteractListener.showAll)) {
                p.closeInventory();
                p.sendMessage(Lobby.prefix + "§aAlle Spieler werden nun angezeigt!");
                p.playSound(p.getLocation(), Sound.LAVA_POP, 1, 1);
                for(Player all : p.getServer().getOnlinePlayers()) {
                    p.showPlayer(all);
                }
            }
            if(e.getCurrentItem().getItemMeta().getDisplayName().equals(LobbyItemInteractListener.hideAll)) {
                p.closeInventory();
                p.sendMessage(Lobby.prefix + "§cAlle Spieler werden nun versteckt!");
                p.playSound(p.getLocation(), Sound.LAVA_POP, 1, 1);
                for(Player all : p.getServer().getOnlinePlayers()) {
                    p.hidePlayer(all);
                }
            }
            if(e.getCurrentItem().getItemMeta().getDisplayName().equals(LobbyItemInteractListener.showVips)) {
                p.closeInventory();
                p.sendMessage(Lobby.prefix + "§5Nur VIP´s werden nun angezeigt!");
                p.playSound(p.getLocation(), Sound.LAVA_POP, 1, 1);
                for(Player all : p.getServer().getOnlinePlayers()) {
                    if(all.hasPermission("lobby.vip")) {
                        p.showPlayer(all);
                    } else {
                        p.hidePlayer(all);
                    }
                }
            }
        }
    }
}
