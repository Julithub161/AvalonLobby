package avalon.net.lobby.listener;

import avalon.net.lobby.Lobby;
import avalon.net.lobby.commands.SetSpawnCommand;
import avalon.net.lobby.manager.SpawnPointManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class NavInventoryClickListener implements Listener {
    @EventHandler
    public void onInventoryClick(InventoryClickEvent e) {
        if(e.getInventory().getName().equals(ConnectionListener.navigatorItemName)) {
            e.setCancelled(true);
            Player p = (Player) e.getWhoClicked();
            if(e.getCurrentItem().getItemMeta().getDisplayName().equals(LobbyItemInteractListener.spawnName)) {
                p.closeInventory();
                if(SetSpawnCommand.lobbySpawn != null) {
                    SetSpawnCommand.lobbySpawn.teleportPlayer(p);
                } else {
                    p.sendMessage(Lobby.prefix + "§cDer Spawnpunkt wurde noch nicht gesetzt!");
                }
            } else if(e.getCurrentItem().getItemMeta().getDisplayName().equals(LobbyItemInteractListener.kitpvpName)) {
                p.closeInventory();
                if(SetSpawnCommand.kitpvpSpawn != null) {
                    SetSpawnCommand.kitpvpSpawn.teleportPlayer(p);
                } else {
                    p.sendMessage(Lobby.prefix + "§cDer Spawnpunkt wurde noch nicht gesetzt!");
                }
            } else if(e.getCurrentItem().getItemMeta().getDisplayName().equals(LobbyItemInteractListener.hcpvpName)) {
                p.closeInventory();
                if(SetSpawnCommand.hcpvpSpawn != null) {
                    SetSpawnCommand.hcpvpSpawn.teleportPlayer(p);
                } else {
                    p.sendMessage(Lobby.prefix + "§cDer Spawnpunkt wurde noch nicht gesetzt!");
                }
            }
        }
    }
}
