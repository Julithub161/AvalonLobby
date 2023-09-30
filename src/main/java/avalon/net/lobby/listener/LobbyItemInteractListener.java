package avalon.net.lobby.listener;

import avalon.net.lobby.Lobby;
import avalon.net.lobby.utils.InventoryBuilder;
import avalon.net.lobby.utils.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;

public class LobbyItemInteractListener implements Listener {
    public static String hcpvpName = "§eHCPvP";
    public static String kitpvpName = "§9KitPvP";
    public static String spawnName = "§aSpawn";
    public static String hideAll = "§cAlle Spieler verstecken";
    public static String showAll = "§aAlle Spieler anzeigen";
    public static String showVips = "§5Nur VIP´s anzeigen";
    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent e) {
        Inventory hideInv = new InventoryBuilder(ConnectionListener.hideItemName, 1).build();
        Inventory navInv = new InventoryBuilder(ConnectionListener.navigatorItemName, 3).build();
        Player p = e.getPlayer();
        if(e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
            if(p.getItemInHand().getItemMeta().getDisplayName().equals(ConnectionListener.hideItemName)) {
                p.openInventory(hideInv);
                fillInv(p, hideInv);
            } else if(p.getItemInHand().getItemMeta().getDisplayName().equals(ConnectionListener.navigatorItemName)) {
                p.openInventory(navInv);
                fillInv(p, navInv);
            }
        }
    }
    public static HashMap<Player, Integer> slot = new HashMap<>();
    private int hideTask = -1;
    private void fillInv(Player p, Inventory inv) {
        slot.put(p, 0);
        hideTask = Bukkit.getScheduler().scheduleSyncRepeatingTask(Lobby.getPlugin(), new Runnable() {
            @Override
            public void run() {
                ItemStack item = new ItemBuilder(Material.STAINED_GLASS_PANE).name(" ").data((short) 7).build();
                if (slot.get(p) >= 9) {
                    if(inv.getName().equals(ConnectionListener.hideItemName)) {
                        setHideInvItems(inv);
                    } else if(inv.getName().equals(ConnectionListener.navigatorItemName)) {
                        setNavInvItems(inv);
                    }
                    Bukkit.getScheduler().cancelTask(hideTask);
                    p.playSound(p.getLocation(), Sound.DIG_WOOL, 4.0f, 4.0f);
                } else {
                    if(inv.getSize() == 9) {
                        inv.setItem(slot.get(p), item);
                    } else if(inv.getSize() == 18) {
                        inv.setItem(slot.get(p), item);
                        inv.setItem(slot.get(p) + 9, item);
                    } else if(inv.getSize() == 27) {
                        inv.setItem(slot.get(p), item);
                        inv.setItem(slot.get(p) + 9, item);
                        inv.setItem(slot.get(p) + 18, item);
                    }
                    slot.put(p, slot.get(p) + 1);
                    p.playSound(p.getLocation(), Sound.CLICK, 1.0f, 1.0f);
                }
            }
        }, 1L, 1L);
    }
    @EventHandler
    public void onInventoryClose(InventoryCloseEvent e) {
        Player p = (Player) e.getPlayer();
        if(e.getInventory().getName().equals(ConnectionListener.hideItemName) || e.getInventory().getName().equals(ConnectionListener.navigatorItemName)) {
            if (hideTask != -1) {
                Bukkit.getScheduler().cancelTask(hideTask);
            }
            slot.remove(p);
        }
    }
    private void setHideInvItems(Inventory inv) {
        inv.setItem(2, new ItemBuilder(Material.WOOL).name(showAll).data((short) 13).build());
        inv.setItem(4, new ItemBuilder(Material.WOOL).name(showVips).data((short) 10).build());
        inv.setItem(6, new ItemBuilder(Material.WOOL).name(hideAll).data((short) 14).build());
    }
    private void setNavInvItems(Inventory inv) {
        inv.setItem(11, new ItemBuilder(Material.GOLDEN_APPLE).name(hcpvpName).build());
        inv.setItem(13, new ItemBuilder(Material.SLIME_BALL).name(spawnName).build());
        inv.setItem(15, new ItemBuilder(Material.DIAMOND).name(kitpvpName).build());
    }
}
